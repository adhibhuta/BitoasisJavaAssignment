package com.bitoasis.javadevelopertask.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ticker data model
 * 
 * @author debjyoti
 *
 */
@Entity
@Table(name = "ticker")
public class Ticker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	String symbol;
	float bid;
	float bidsize;
	float ask;
	float asksize;
	float dailychange;
	float dailychangerelative;
	float lastprice;
	float volume;
	float high;
	float low;
	
	@Temporal(TemporalType.DATE)
	Date date = new Date(System.currentTimeMillis());

	public Ticker() {
	}

	public Ticker(String symbol, float bid, float bidsize, float ask, float asksize, float dailychange,
			float dailychangerelative, float lastprice, float volume, float high, float low) {

		this.symbol = symbol;
		this.bid = bid;
		this.bidsize = bidsize;
		this.ask = ask;
		this.asksize = asksize;
		this.dailychange = dailychange;
		this.dailychangerelative = dailychangerelative;
		this.lastprice = lastprice;
		this.volume = volume;
		this.high = high;
		this.low = low;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getBid() {
		return bid;
	}

	public void setBid(float bid) {
		this.bid = bid;
	}

	public float getBidsize() {
		return bidsize;
	}

	public void setBidsize(float bidsize) {
		this.bidsize = bidsize;
	}

	public float getAsk() {
		return ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}

	public float getAsksize() {
		return asksize;
	}

	public void setAsksize(float asksize) {
		this.asksize = asksize;
	}

	public float getDailyChange() {
		return dailychange;
	}

	public void setDailyChange(float dailychange) {
		this.dailychange = dailychange;
	}

	public float getDailyChangeRelative() {
		return dailychangerelative;
	}

	public void setDailychangerelative(float dailychangerelative) {
		this.dailychangerelative = dailychangerelative;
	}

	public float getLastprice() {
		return lastprice;
	}

	public void setLastprice(float lastprice) {
		this.lastprice = lastprice;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
