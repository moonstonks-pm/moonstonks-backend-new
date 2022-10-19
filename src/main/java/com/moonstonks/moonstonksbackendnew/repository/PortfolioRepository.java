package com.moonstonks.moonstonksbackendnew.repository;

import com.moonstonks.moonstonksbackendnew.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}

