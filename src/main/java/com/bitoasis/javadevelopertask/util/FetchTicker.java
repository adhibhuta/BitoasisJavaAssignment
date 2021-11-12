package com.bitoasis.javadevelopertask.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bitoasis.javadevelopertask.entity.Ticker;
import com.bitoasis.javadevelopertask.repository.TickerRepository;

/**
 * Fetch the ticker from API on multiple threads
 * 
 * @author debjyoti
**/
@Component
public class FetchTicker {

	@Autowired
	TickerRepository tickerRepository;

	@Value("${bitfinex.header.user-agent}")
	String userAgent;

	@Value("${bitfinex.ticker.uri}")
	String bitfinexUri;

	Logger logger = LoggerFactory.getLogger(FetchTicker.class);
	/**
	 * Uses threads from threadpool and computes async api calls
	 * 
	 * @param String
	 * @return CompletableFuture<Ticker>
	 * @throws URISyntaxException
	 */
	@Async
	public CompletableFuture<Ticker> saveTicker(String symbol) throws URISyntaxException {
		long start = System.currentTimeMillis();
		logger.info("Calling ticker with symbol " + symbol + " " + Thread.currentThread().getName());
		Ticker ticker = getTicker(symbol);
		ticker = tickerRepository.save(ticker);
		long end = System.currentTimeMillis();
		logger.info("Time taken: " + (end - start));
		return CompletableFuture.completedFuture(ticker);
	}
	/**
	 * Makes rest call using rest template
	 * 
	 * @param String
	 * @return Ticker
	 * @throws URISyntaxException
	 */
	private Ticker getTicker(String ticker) throws URISyntaxException {
		RestTemplate rt = new RestTemplate();
		URI uri = null;

		uri = new URI(bitfinexUri + ticker);

		HttpHeaders headers = new HttpHeaders();
		Map<String, String> param = new HashMap<>();

		HttpEntity entity = new HttpEntity(headers);

		headers.set("user-agent", userAgent);

		ResponseEntity<float[]> result = rt.exchange(uri, HttpMethod.GET, entity, float[].class);

		Ticker tickerObj = new Ticker(ticker, result.getBody()[0], result.getBody()[1], result.getBody()[2],
				result.getBody()[3], result.getBody()[4], result.getBody()[5], result.getBody()[6], result.getBody()[7],
				result.getBody()[8], result.getBody()[9]);

		return tickerObj;
	}

}
