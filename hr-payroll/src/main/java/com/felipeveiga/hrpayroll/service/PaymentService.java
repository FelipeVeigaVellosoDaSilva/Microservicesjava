package com.felipeveiga.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeveiga.hrpayroll.entities.Payment;
import com.felipeveiga.hrpayroll.entities.Worker;
import com.felipeveiga.hrpayroll.feingnclient.WorkerFeingnClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeingnClient workerFeingnClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeingnClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
