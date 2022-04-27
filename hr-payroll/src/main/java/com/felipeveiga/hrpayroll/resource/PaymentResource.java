package com.felipeveiga.hrpayroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.felipeveiga.hrpayroll.entities.Payment;
import com.felipeveiga.hrpayroll.service.PaymentService;

@RestController
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@GetMapping("/payments/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok().body(payment);
	}
	
	
}
