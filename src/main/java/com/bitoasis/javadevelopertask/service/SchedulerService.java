package com.bitoasis.javadevelopertask.service;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bitoasis.javadevelopertask.util.FetchTicker;

/**
 * Scheduled operation to fetch data from api every 10seconds
 * 
 * @author debjyoti
 *
 */
@Service
public class SchedulerService {

	@Value("#{'${ticker.symbols}'.split(',')}")
	private List<String> tickers;

	@Autowired
	FetchTicker fetchTicker;

	Logger logger = LoggerFactory.getLogger(SchedulerService.class);
	
	/**
	 * Method to perform scheduled operation
	 * 
	 */
	@Scheduled(cron = "0/10 * * * * *")
	public void fetchTicker(){
		logger.info("Ran Scheduler at: " + new Date(System.currentTimeMillis()));
		tickers.forEach(t -> {

			try {
				fetchTicker.saveTicker(t);
			} catch (URISyntaxException e) {
				logger.error("Causer URI exception: ", e);
			}
		});

	}

}
