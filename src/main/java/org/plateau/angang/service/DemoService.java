package org.plateau.angang.service;

import org.plateau.angang.dao.DemoMapper;
import org.plateau.angang.models.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DemoService {
	
	@Autowired
	private DemoMapper mapper;
	
	public Demo getDemoById(int id) {
		return mapper.getDemo(id);
	}
	
	public void testMonitor() {
		throw new RuntimeException();
	}

}
