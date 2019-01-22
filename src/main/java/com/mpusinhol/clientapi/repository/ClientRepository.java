package com.mpusinhol.clientapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mpusinhol.clientapi.domain.Client;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

}
