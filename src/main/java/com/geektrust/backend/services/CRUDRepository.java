package com.geektrust.backend.services;

import java.util.Optional;

public interface CRUDRepository<T, ID> {
    public Optional<T> findById(ID id);
}
