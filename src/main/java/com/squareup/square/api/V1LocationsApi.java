package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.V1Merchant;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface V1LocationsApi {
    /**
     * Get the general information for a business.
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call
     */
    @Deprecated    V1Merchant retrieveBusiness() throws ApiException, IOException;

    /**
     * Get the general information for a business.
     * @deprecated
     * 
     * @return    Returns the V1Merchant response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Merchant> retrieveBusinessAsync();

    /**
     * Provides details for all business locations associated with a Square
     * account, including the Square-assigned object ID for the location.
     * @deprecated
     * 
     * @return    Returns the List<V1Merchant> response from the API call
     */
    @Deprecated    List<V1Merchant> listLocations() throws ApiException, IOException;

    /**
     * Provides details for all business locations associated with a Square
     * account, including the Square-assigned object ID for the location.
     * @deprecated
     * 
     * @return    Returns the List<V1Merchant> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1Merchant>> listLocationsAsync();

}
