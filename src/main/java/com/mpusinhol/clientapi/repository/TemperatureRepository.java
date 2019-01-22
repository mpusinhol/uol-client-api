package com.mpusinhol.clientapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mpusinhol.clientapi.domain.Temperature;

@Repository
public interface TemperatureRepository extends PagingAndSortingRepository<Temperature, Long> {

}
