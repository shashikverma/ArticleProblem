package com.example.articles.object.request;

import java.util.Date;

public class ArticlePeriodReq {
	Date fromDate, toDate;

	/****************************
	 * Getters and Setters
	 ********************************************/

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
