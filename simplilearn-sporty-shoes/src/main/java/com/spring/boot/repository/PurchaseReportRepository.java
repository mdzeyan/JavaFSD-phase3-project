package com.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.model.PurchaseReport;

public interface PurchaseReportRepository extends CrudRepository<PurchaseReport, Integer> {

}
