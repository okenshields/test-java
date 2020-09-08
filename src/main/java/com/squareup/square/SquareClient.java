package com.squareup.square;

import java.util.Map;
import java.util.HashMap;

import com.squareup.square.api.ApplePayApi;
import com.squareup.square.api.BankAccountsApi;
import com.squareup.square.api.CashDrawersApi;
import com.squareup.square.api.CatalogApi;
import com.squareup.square.api.CheckoutApi;
import com.squareup.square.api.CustomerGroupsApi;
import com.squareup.square.api.CustomersApi;
import com.squareup.square.api.CustomerSegmentsApi;
import com.squareup.square.api.DefaultApplePayApi;
import com.squareup.square.api.DefaultBankAccountsApi;
import com.squareup.square.api.DefaultCashDrawersApi;
import com.squareup.square.api.DefaultCatalogApi;
import com.squareup.square.api.DefaultCheckoutApi;
import com.squareup.square.api.DefaultCustomerGroupsApi;
import com.squareup.square.api.DefaultCustomersApi;
import com.squareup.square.api.DefaultCustomerSegmentsApi;
import com.squareup.square.api.DefaultDevicesApi;
import com.squareup.square.api.DefaultDisputesApi;
import com.squareup.square.api.DefaultEmployeesApi;
import com.squareup.square.api.DefaultInventoryApi;
import com.squareup.square.api.DefaultInvoicesApi;
import com.squareup.square.api.DefaultLaborApi;
import com.squareup.square.api.DefaultLocationsApi;
import com.squareup.square.api.DefaultLoyaltyApi;
import com.squareup.square.api.DefaultMerchantsApi;
import com.squareup.square.api.DefaultMobileAuthorizationApi;
import com.squareup.square.api.DefaultOAuthApi;
import com.squareup.square.api.DefaultOrdersApi;
import com.squareup.square.api.DefaultPaymentsApi;
import com.squareup.square.api.DefaultRefundsApi;
import com.squareup.square.api.DefaultSubscriptionsApi;
import com.squareup.square.api.DefaultTeamApi;
import com.squareup.square.api.DefaultTerminalApi;
import com.squareup.square.api.DefaultTransactionsApi;
import com.squareup.square.api.DefaultV1EmployeesApi;
import com.squareup.square.api.DefaultV1ItemsApi;
import com.squareup.square.api.DefaultV1LocationsApi;
import com.squareup.square.api.DefaultV1TransactionsApi;
import com.squareup.square.api.DevicesApi;
import com.squareup.square.api.DisputesApi;
import com.squareup.square.api.EmployeesApi;
import com.squareup.square.api.InventoryApi;
import com.squareup.square.api.InvoicesApi;
import com.squareup.square.api.LaborApi;
import com.squareup.square.api.LocationsApi;
import com.squareup.square.api.LoyaltyApi;
import com.squareup.square.api.MerchantsApi;
import com.squareup.square.api.MobileAuthorizationApi;
import com.squareup.square.api.OAuthApi;
import com.squareup.square.api.OrdersApi;
import com.squareup.square.api.PaymentsApi;
import com.squareup.square.api.RefundsApi;
import com.squareup.square.api.SubscriptionsApi;
import com.squareup.square.api.TeamApi;
import com.squareup.square.api.TerminalApi;
import com.squareup.square.api.TransactionsApi;
import com.squareup.square.api.V1EmployeesApi;
import com.squareup.square.api.V1ItemsApi;
import com.squareup.square.api.V1LocationsApi;
import com.squareup.square.api.V1TransactionsApi;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpClientConfiguration;
import com.squareup.square.http.client.OkClient;
import com.squareup.square.http.client.ReadonlyHttpClientConfiguration;
import com.squareup.square.http.Headers;

/**
 * Gateway class for the library.
 * This class acts as a factory for Apis.
 * It holds the state of the SDK.
 */
public final class SquareClient implements SquareClientInterface {
    private MobileAuthorizationApi mobileAuthorization;
    private OAuthApi oAuth;
    private V1LocationsApi v1Locations;
    private V1EmployeesApi v1Employees;
    private V1TransactionsApi v1Transactions;
    private V1ItemsApi v1Items;
    private ApplePayApi applePay;
    private BankAccountsApi bankAccounts;
    private CashDrawersApi cashDrawers;
    private CatalogApi catalog;
    private CustomersApi customers;
    private CustomerGroupsApi customerGroups;
    private CustomerSegmentsApi customerSegments;
    private DevicesApi devices;
    private DisputesApi disputes;
    private EmployeesApi employees;
    private InventoryApi inventory;
    private InvoicesApi invoices;
    private LaborApi labor;
    private LocationsApi locations;
    private CheckoutApi checkout;
    private TransactionsApi transactions;
    private LoyaltyApi loyalty;
    private MerchantsApi merchants;
    private OrdersApi orders;
    private PaymentsApi payments;
    private RefundsApi refunds;
    private SubscriptionsApi subscriptions;
    private TeamApi team;
    private TerminalApi terminal;

    /**
     * Get the instance of MobileAuthorizationApi
     * @return mobileAuthorization
     */
    public MobileAuthorizationApi getMobileAuthorizationApi() {
        return mobileAuthorization;
    }

    /**
     * Get the instance of OAuthApi
     * @return oAuth
     */
    public OAuthApi getOAuthApi() {
        return oAuth;
    }

    /**
     * Get the instance of V1LocationsApi
     * @return v1Locations
     */
    public V1LocationsApi getV1LocationsApi() {
        return v1Locations;
    }

    /**
     * Get the instance of V1EmployeesApi
     * @return v1Employees
     */
    public V1EmployeesApi getV1EmployeesApi() {
        return v1Employees;
    }

    /**
     * Get the instance of V1TransactionsApi
     * @return v1Transactions
     */
    public V1TransactionsApi getV1TransactionsApi() {
        return v1Transactions;
    }

    /**
     * Get the instance of V1ItemsApi
     * @return v1Items
     */
    public V1ItemsApi getV1ItemsApi() {
        return v1Items;
    }

    /**
     * Get the instance of ApplePayApi
     * @return applePay
     */
    public ApplePayApi getApplePayApi() {
        return applePay;
    }

    /**
     * Get the instance of BankAccountsApi
     * @return bankAccounts
     */
    public BankAccountsApi getBankAccountsApi() {
        return bankAccounts;
    }

    /**
     * Get the instance of CashDrawersApi
     * @return cashDrawers
     */
    public CashDrawersApi getCashDrawersApi() {
        return cashDrawers;
    }

    /**
     * Get the instance of CatalogApi
     * @return catalog
     */
    public CatalogApi getCatalogApi() {
        return catalog;
    }

    /**
     * Get the instance of CustomersApi
     * @return customers
     */
    public CustomersApi getCustomersApi() {
        return customers;
    }

    /**
     * Get the instance of CustomerGroupsApi
     * @return customerGroups
     */
    public CustomerGroupsApi getCustomerGroupsApi() {
        return customerGroups;
    }

    /**
     * Get the instance of CustomerSegmentsApi
     * @return customerSegments
     */
    public CustomerSegmentsApi getCustomerSegmentsApi() {
        return customerSegments;
    }

    /**
     * Get the instance of DevicesApi
     * @return devices
     */
    public DevicesApi getDevicesApi() {
        return devices;
    }

    /**
     * Get the instance of DisputesApi
     * @return disputes
     */
    public DisputesApi getDisputesApi() {
        return disputes;
    }

    /**
     * Get the instance of EmployeesApi
     * @return employees
     */
    public EmployeesApi getEmployeesApi() {
        return employees;
    }

    /**
     * Get the instance of InventoryApi
     * @return inventory
     */
    public InventoryApi getInventoryApi() {
        return inventory;
    }

    /**
     * Get the instance of InvoicesApi
     * @return invoices
     */
    public InvoicesApi getInvoicesApi() {
        return invoices;
    }

    /**
     * Get the instance of LaborApi
     * @return labor
     */
    public LaborApi getLaborApi() {
        return labor;
    }

    /**
     * Get the instance of LocationsApi
     * @return locations
     */
    public LocationsApi getLocationsApi() {
        return locations;
    }

    /**
     * Get the instance of CheckoutApi
     * @return checkout
     */
    public CheckoutApi getCheckoutApi() {
        return checkout;
    }

    /**
     * Get the instance of TransactionsApi
     * @return transactions
     */
    public TransactionsApi getTransactionsApi() {
        return transactions;
    }

    /**
     * Get the instance of LoyaltyApi
     * @return loyalty
     */
    public LoyaltyApi getLoyaltyApi() {
        return loyalty;
    }

    /**
     * Get the instance of MerchantsApi
     * @return merchants
     */
    public MerchantsApi getMerchantsApi() {
        return merchants;
    }

    /**
     * Get the instance of OrdersApi
     * @return orders
     */
    public OrdersApi getOrdersApi() {
        return orders;
    }

    /**
     * Get the instance of PaymentsApi
     * @return payments
     */
    public PaymentsApi getPaymentsApi() {
        return payments;
    }

    /**
     * Get the instance of RefundsApi
     * @return refunds
     */
    public RefundsApi getRefundsApi() {
        return refunds;
    }

    /**
     * Get the instance of SubscriptionsApi
     * @return subscriptions
     */
    public SubscriptionsApi getSubscriptionsApi() {
        return subscriptions;
    }

    /**
     * Get the instance of TeamApi
     * @return team
     */
    public TeamApi getTeamApi() {
        return team;
    }

    /**
     * Get the instance of TerminalApi
     * @return terminal
     */
    public TerminalApi getTerminalApi() {
        return terminal;
    }

    /**
     * Shutdown the underlying HttpClient instance
     */
    public static void shutdown() {
        OkClient.shutdown();
    }

    private SquareClient(Environment environment, String squareVersion, String accessToken, HttpClient httpClient,
            long timeout, ReadonlyHttpClientConfiguration httpClientConfig, Headers additionalHeaders,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        this.environment = environment;
        this.squareVersion = squareVersion;
        this.accessToken = accessToken;
        this.httpClient = httpClient;
        this.timeout = timeout;
        this.httpClientConfig = httpClientConfig;
        this.additionalHeaders = additionalHeaders;
        this.httpCallback = httpCallback;

        this.authManagers = (authManagers == null) ? new HashMap<>() : new HashMap<>(authManagers);
        if (!this.authManagers.containsKey("default")
                || ((AccessTokenManager) this.authManagers.get("default")).getAccessToken() != accessToken) {
            AuthManager accessTokenManager = new AccessTokenManager(accessToken);
            this.authManagers.put("default", accessTokenManager);
        }


        mobileAuthorization = new DefaultMobileAuthorizationApi(this, this.httpClient, this.authManagers, this.httpCallback);
        oAuth = new DefaultOAuthApi(this, this.httpClient, this.authManagers, this.httpCallback);
        v1Locations = new DefaultV1LocationsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        v1Employees = new DefaultV1EmployeesApi(this, this.httpClient, this.authManagers, this.httpCallback);
        v1Transactions = new DefaultV1TransactionsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        v1Items = new DefaultV1ItemsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        applePay = new DefaultApplePayApi(this, this.httpClient, this.authManagers, this.httpCallback);
        bankAccounts = new DefaultBankAccountsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        cashDrawers = new DefaultCashDrawersApi(this, this.httpClient, this.authManagers, this.httpCallback);
        catalog = new DefaultCatalogApi(this, this.httpClient, this.authManagers, this.httpCallback);
        customers = new DefaultCustomersApi(this, this.httpClient, this.authManagers, this.httpCallback);
        customerGroups = new DefaultCustomerGroupsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        customerSegments = new DefaultCustomerSegmentsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        devices = new DefaultDevicesApi(this, this.httpClient, this.authManagers, this.httpCallback);
        disputes = new DefaultDisputesApi(this, this.httpClient, this.authManagers, this.httpCallback);
        employees = new DefaultEmployeesApi(this, this.httpClient, this.authManagers, this.httpCallback);
        inventory = new DefaultInventoryApi(this, this.httpClient, this.authManagers, this.httpCallback);
        invoices = new DefaultInvoicesApi(this, this.httpClient, this.authManagers, this.httpCallback);
        labor = new DefaultLaborApi(this, this.httpClient, this.authManagers, this.httpCallback);
        locations = new DefaultLocationsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        checkout = new DefaultCheckoutApi(this, this.httpClient, this.authManagers, this.httpCallback);
        transactions = new DefaultTransactionsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        loyalty = new DefaultLoyaltyApi(this, this.httpClient, this.authManagers, this.httpCallback);
        merchants = new DefaultMerchantsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        orders = new DefaultOrdersApi(this, this.httpClient, this.authManagers, this.httpCallback);
        payments = new DefaultPaymentsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        refunds = new DefaultRefundsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        subscriptions = new DefaultSubscriptionsApi(this, this.httpClient, this.authManagers, this.httpCallback);
        team = new DefaultTeamApi(this, this.httpClient, this.authManagers, this.httpCallback);
        terminal = new DefaultTerminalApi(this, this.httpClient, this.authManagers, this.httpCallback);
    }

    /**
     * Current API environment
     */
    private final Environment environment;

    /**
     * Square Connect API versions
     */
    private final String squareVersion;

    /**
     * OAuth 2.0 Access Token
     */
    private final String accessToken;

    /**
     * The HTTP Client instance to use for making HTTP requests.
     */
    private final HttpClient httpClient;

    /**
     * The timeout to use for making HTTP requests.
     */
    private final long timeout;

    /**
     * Http Client Configuration instance.
     */
    private final ReadonlyHttpClientConfiguration httpClientConfig;

    /**
     * Additional headers to add to each API request
     */
    private final Headers additionalHeaders;

    /**
     * Map of authentication Managers.
     */
    private Map<String, AuthManager> authManagers;

    /**
     * Callback to be called before and after the HTTP call for an endpoint is made.
     */
    private final HttpCallback httpCallback;

    /**
     * Current API environment
     * @return environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Square Connect API versions
     * @return squareVersion
     */
    public String getSquareVersion() {
        return squareVersion;
    }

    /**
     * OAuth 2.0 Access Token
     * @return accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * The HTTP Client instance to use for making HTTP requests.
     * @return httpClient
     */
    private HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * The timeout to use for making HTTP requests.
     * @return timeout
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * Http Client Configuration instance.
     * @return httpClientConfig
     */
    public ReadonlyHttpClientConfiguration getHttpClientConfig() {
        return httpClientConfig;
    }

    /**
     * Additional headers to add to each API request
     * @return a copy of additionalHeaders
     */
    public Headers getAdditionalHeaders() {
        return new Headers(additionalHeaders);
    }

    /**
     * Current SDK Version
     * @return sdkVersion
     */
    public String getSdkVersion() {
        return "6.3.0.20200826";
    }

    /**
     * Get base URI by current environment
     * @param server Server for which to get the base URI
     * @return Processed base URI
     */
    public String getBaseUri(Server server) {
        StringBuilder baseUrl = new StringBuilder(environmentMapper(environment, server));
        Map<String, Object> parameters = new HashMap<>();
        ApiHelper.appendUrlWithTemplateParameters(baseUrl, parameters, false);
        return baseUrl.toString();
    }

    /**
     * Get base URI by current environment
     * @return Processed base URI
     */
    public String getBaseUri() {
        return getBaseUri(Server.ENUM_DEFAULT);
    }

    /**
     * Base URLs by environment and server aliases
     * @param environment Environment for which to get the base URI
     * @param server Server for which to get the base URI
     * @return base URL
     */
    private static String environmentMapper(Environment environment, Server server) {
        if (environment.equals(Environment.PRODUCTION)) {
            if (server.equals(Server.ENUM_DEFAULT)) {
                return "https://connect.squareup.com";
            }
        }
        if (environment.equals(Environment.SANDBOX)) {
            if (server.equals(Server.ENUM_DEFAULT)) {
                return "https://connect.squareupsandbox.com";
            }
        }
        return "https://connect.squareup.com";
    }

    
    /**
     * Builds a new {@link SquareClient.Builder} object.
     * Creates the instance with the state of the current client.
     * @return a new {@link SquareClient.Builder} object
     */
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.environment = getEnvironment();
        builder.squareVersion = getSquareVersion();
        builder.accessToken = getAccessToken();
        builder.httpClient = getHttpClient();
        builder.timeout = getTimeout();
        builder.additionalHeaders = getAdditionalHeaders();
        builder.authManagers = authManagers;
        builder.httpCallback = httpCallback;
        builder.setHttpClientConfig(httpClientConfig);
        return builder;
    }

    /**
     * Class to build instances of {@link SquareClient}
     */
    public static class Builder {
        private Environment environment = Environment.PRODUCTION;
        private String squareVersion = "2020-08-26";
        private String accessToken = "TODO: Replace";
        private HttpClient httpClient;
        private long timeout = 60;
        private Headers additionalHeaders = new Headers();
        private Map<String, AuthManager> authManagers = null;
        private HttpCallback httpCallback = null;

        private HttpClientConfiguration httpClientConfig;

        /**
         * Current API environment
         * @param environment
         */
        public Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }
        /**
         * Square Connect API versions
         * @param squareVersion
         */
        public Builder squareVersion(String squareVersion) {
            if (squareVersion == null) {
                throw new NullPointerException("squareVersion cannot be null");
            }
            this.squareVersion = squareVersion;
            return this;
        }
        /**
         * OAuth 2.0 Access Token
         * @param accessToken
         */
        public Builder accessToken(String accessToken) {
            if (accessToken == null) {
                throw new NullPointerException("accessToken cannot be null");
            }
            this.accessToken = accessToken;
            return this;
        }
        /**
         * The timeout to use for making HTTP requests.
         * @param timeout must be greater then 0.
         */
        public Builder timeout(long timeout) {
            if (timeout > 0) {
                this.timeout = timeout;
            }
            return this;
        }
        /**
         * Additional headers to add to each API request
         * @param additionalHeaders
         */
        public Builder additionalHeaders(Headers additionalHeaders) {
            if (additionalHeaders == null) {
                throw new NullPointerException("additionalHeaders cannot be null");
            }
            this.additionalHeaders = additionalHeaders;
            return this;
        }
        /**
         * HttpCallback
         * @param httpCallback
         */
        public Builder httpCallback(HttpCallback httpCallback) {
            this.httpCallback = httpCallback;
            return this;
        }


        private void setHttpClientConfig(ReadonlyHttpClientConfiguration httpClientConfig) {
            this.timeout = httpClientConfig.getTimeout();
        }

        /**
         * Builds a new SquareClient object using the set fields.
         * @return SquareClient
         */
        public SquareClient build() {
            httpClientConfig = new HttpClientConfiguration();
            httpClientConfig.setTimeout(timeout);
            httpClient = new OkClient(httpClientConfig);

            return new SquareClient(environment, squareVersion, accessToken, httpClient, timeout, httpClientConfig,
                    additionalHeaders, authManagers, httpCallback);
        }
    }
}
