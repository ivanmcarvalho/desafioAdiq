package com.desafio.desafio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootPayment{
    @JsonProperty("paymentAuthorization") 
    public PaymentAuthorization getPaymentAuthorization() { 
		 return this.paymentAuthorization; } 
    public void setPaymentAuthorization(PaymentAuthorization paymentAuthorization) { 
		 this.paymentAuthorization = paymentAuthorization; } 
    PaymentAuthorization paymentAuthorization;
}
