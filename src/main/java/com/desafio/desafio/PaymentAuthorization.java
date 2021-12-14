package com.desafio.desafio;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentAuthorization{
    @JsonProperty("paymentId") 
    public String getPaymentId() { 
		 return this.paymentId; } 
    public void setPaymentId(String paymentId) { 
		 this.paymentId = paymentId; } 
    String paymentId;
    @JsonProperty("statusDescription") 
    public String getStatusDescription() { 
		 return this.statusDescription; } 
    public void setStatusDescription(String statusDescription) { 
		 this.statusDescription = statusDescription; } 
    String statusDescription;
    @JsonProperty("transactionDate") 
    public Date getTransactionDate() { 
		 return this.transactionDate; } 
    public void setTransactionDate(Date transactionDate) { 
		 this.transactionDate = transactionDate; } 
    Date transactionDate;
}

