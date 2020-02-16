package io.github.h2kb.repository.customer;

import io.github.h2kb.model.Customer;

public interface CustomerRepository {

    Customer findById(Long id);
}
