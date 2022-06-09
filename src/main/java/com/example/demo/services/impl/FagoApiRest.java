package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.apiif.FagoApiIf;
import com.example.demo.eneity.FagoData;
import com.example.demo.jpa.FagoRepository;
import com.example.demo.services.FagoApiService;
import com.example.demo.util.UuidUtil;

@RestController
public class FagoApiRest implements FagoApiService {
	@Autowired
	private FagoRepository repository;

	@Override
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public FagoData getData(@RequestParam String key) {
		return getSingleFagoDataByKey(key);
	}

	@Override
	@RequestMapping(value = "put", method = RequestMethod.POST)
	public void makeData(@RequestBody FagoApiIf data) {
		FagoData dbData = new FagoData();
		dbData.setKey(data.key());
		dbData.setValue(data.value());
		if (repository.existsByKey(data.key())) {
			dbData.setUuid(getSingleFagoDataByKey(data.key()).getUuid());
		} else {
			dbData.setUuid(UuidUtil.getUUID());
		}
		repository.save(dbData);
	}

	private FagoData getSingleFagoDataByKey(String key) {
		List<FagoData> datas = repository.findByKey(key);
		if (datas.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
		}
		return datas.get(0);
	}

}
