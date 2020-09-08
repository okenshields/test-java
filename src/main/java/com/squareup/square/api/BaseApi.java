package com.squareup.square.api;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;


import com.squareup.square.AuthManager;
import com.squareup.square.Configuration;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;

/**
 * Base class for all Apis.
 */
public abstract class BaseApi {

    /**
     * Protected variables to hold an instance of Configuration
     */
    protected final Configuration config;
    protected static final String userAgent = "Square-Java-SDK/6.3.0.20200826";

    /**
     * Protected variable to hold an instance of HttpCallback if the user provides it
     */
    protected final HttpCallback httpCallback;

    protected Map<String, AuthManager> authManagers;

    private HttpClient httpClient;
    protected BaseApi(Configuration config,
            HttpClient httpClient, Map<String, AuthManager> authManagers) {
        this(config, httpClient, authManagers, null);
    }
    
    protected BaseApi(Configuration config,
            HttpClient httpClient, Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        this.config = config;
        this.httpClient = httpClient;
        this.authManagers = authManagers;
        this.httpCallback = httpCallback;
    }
    
    /**
     * Get httpCallback associated with this controller
     * @return HttpCallback
     */
    public HttpCallback getHttpCallback() {
        return httpCallback;
    }
    
    /**
     * Shared instance of the Http client
     * @return The shared instance of the http client 
     */
    public HttpClient getClientInstance() {
        return httpClient;
    }

    /**
     * Validates the response against HTTP errors defined at the API level
     * @param   response    The response recieved
     * @param   context     Context of the request and the recieved response 
     */
    protected void validateResponse(HttpResponse response, HttpContext context) 
            throws ApiException {
        //get response status code to validate
        int responseCode = response.getStatusCode();
        if ((responseCode < 200) || (responseCode > 208)) //[200,208] = HTTP OK
            throw new ApiException("HTTP Response Not OK", context);
    }

    /**
     * RequestSupplier
     */
    protected interface RequestSupplier {
        
        /**
         * Supplies the HttpRequest object
         * @return    An object of type HttpRequest
        */
        HttpRequest supply() throws ApiException, IOException;
    }

    /**
     * RequestExecutor
     */
    protected interface RequestExecutor {

        /**
         * Execute a given HttpRequest to get the response back
         * @param   request    The given HttpRequest to execute
         * @return  CompletableFuture<HttpResponse> after execution
         */
        CompletableFuture<HttpResponse> execute(HttpRequest request);
    }

    /**
     * ResponseHandler
     */
    protected interface ResponseHandler<T> {
        
        /**
         * Handles the response for an endpoint
         * @param   context    HttpContext of the request and the received response
         * @return   An object of type T
         */
        T handle(HttpContext context) throws ApiException, IOException;
    }
    
    /**
     * Make an asynchronous HTTP endpoint call
     * @param   requestSupplier    An object of RequestSupplier to supply an instance of HttpRequest
     * @param   requestExecutor    An object of RequestExecutor to execute the request & get the response
     * @param   responseHandler    An object of ResponseHandler to handle the endpoint response
     * @return  An object of type CompletableFuture<T>
     */
    public <T> CompletableFuture<T> makeHttpCallAsync(RequestSupplier requestSupplier,
            RequestExecutor requestExecutor, ResponseHandler<T> responseHandler) {
        final HttpRequest request;
        try {
            request = requestSupplier.supply();
        } catch (Exception e) {
            CompletableFuture<T> futureResponse = new CompletableFuture<>();
            futureResponse.completeExceptionally(e);
            return futureResponse;
        }

        // Invoke request and get response
        return requestExecutor.execute(request).thenApplyAsync(response -> {
            HttpContext context = new HttpContext(request, response);
            try {
                return responseHandler.handle(context);
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        });
    }
}
