package com.bc.album.infrastructure.webclient;

import java.util.List;

/**
 * ApiClient Interface that provides generic methods to add n clients with their
 * respective calls to obtain the desired information
 * @param <T>
 */
public interface ApiClient<T> {

    /**
     * Rest template exchange.
     * @return T type
     */
    List<T> fetchData();

    /**
     * Get T entity type.
     * @return Class T.
     */
    Class<T> getEntityType();

}
