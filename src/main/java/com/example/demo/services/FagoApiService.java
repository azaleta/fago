package com.example.demo.services;

import com.example.demo.apiif.FagoApiIf;
import com.example.demo.eneity.FagoData;

public interface FagoApiService {
	public FagoData getData(String key);
	public void makeData(FagoApiIf data);
}
