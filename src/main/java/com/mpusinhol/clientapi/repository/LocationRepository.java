package com.mpusinhol.clientapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mpusinhol.clientapi.domain.Location;

@Repository
public interface LocationRepository extends PagingAndSortingRepository<Location, Long>{

}
