package com.bitoasis.javadevelopertask.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitoasis.javadevelopertask.entity.Ticker;

/**
 * Ticker Spring Data Repository
 * @author debjyoti
 *
 */
@Repository
public interface TickerRepository extends JpaRepository<Ticker,Integer>{
	
	public List<Ticker> findAllByDate(Date publicationDate);

}
