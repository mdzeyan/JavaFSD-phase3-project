package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.model.PurchaseReport;
import com.spring.boot.repository.PurchaseReportRepository;

@Component
public class PurchaseReportService {
	
	@Autowired
	private PurchaseReportRepository purchaseReportRepository;
	
	public PurchaseReport addPurchaseReport(PurchaseReport prs)
	{
		PurchaseReport result = purchaseReportRepository.save(prs);
		return result;
	}
	
//	public List<PurchaseReport> getAllPurchaseReport()
//	{
//		List<PurchaseReport> list = (List<PurchaseReport>) purchaseReportRepository.findAll();
//		return list;
//	}

	public List<PurchaseReport> getAllPurchaseReport() {
		// TODO Auto-generated method stub
		List<PurchaseReport> list = (List<PurchaseReport>) purchaseReportRepository.findAll();
		return list;
	}

	
	

}
