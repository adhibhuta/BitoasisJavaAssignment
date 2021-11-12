package com.bitoasis.JavaDeveloperTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bitoasis.javadevelopertask.JavaDeveloperTaskApplication;
import com.bitoasis.javadevelopertask.entity.Ticker;
import com.bitoasis.javadevelopertask.exception.NoTickerFound;
import com.bitoasis.javadevelopertask.repository.TickerRepository;
import com.bitoasis.javadevelopertask.service.TickerService;

@SpringBootTest(classes = JavaDeveloperTaskApplication.class)
class JavaDeveloperTaskApplicationTests {

	@MockBean
	private TickerRepository tickerRepo;

	@Autowired
	TickerService tickerService;

	@Test
	public void getAllTickersTest() {

		Ticker t1 = new Ticker("tETHUSD", 63560, 8124326, 635660, 81734915, -18696187, -286, 63545, 40190803, 65421,
				65421);
		Ticker t2 = new Ticker("tETHUSD", 63560, 8124326, 635660, 81734915, -18696187, -286, 63545, 40190803, 65421,
				65421);

		when(tickerRepo.findAll()).thenReturn(Stream.of(t1, t2).collect(Collectors.toList()));

		assertEquals(2, tickerService.getAllTickers().size());

	}

	@Test
	public void getTickerByIdTest() throws NoTickerFound {
		Ticker ticker = new Ticker("tETHUSD", 63560, 8124326, 635660, 81734915, -18696187, -286, 63545, 40190803, 65421,
				65421);
		int id = 1;

		when(tickerRepo.findById(id)).thenReturn(Optional.of(ticker));

		assertEquals(63560, tickerService.getTickerById(id).getBid());

	}

	@Test
	public void updateTickerTest() {
		Ticker ticker = new Ticker("tETHUSD", 63560, 8124326, 635660, 81734915, -18696187, -286, 63545, 40190803, 65421,
				65421);

		when(tickerRepo.save(ticker)).thenReturn(ticker);

		assertEquals(ticker, tickerService.updateTicker(ticker));
	}

	@Test
	public void deleteTicketTest() {
		
		tickerService.deleteTickerById(1);

		verify(tickerRepo, times(1)).deleteById(1);
	}

}
