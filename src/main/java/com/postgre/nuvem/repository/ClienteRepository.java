package com.postgre.nuvem.repository;

import org.springframework.data.repository.CrudRepository;

import  com.postgre.nuvem.model.*;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}