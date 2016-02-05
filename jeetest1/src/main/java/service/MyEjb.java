package service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.UnitDAOImpl;
import entity.Unit;

@Stateless
public class MyEjb {
	
	@Inject
	private UnitDAOImpl unitDAOImpl;

	public String generateNumber(int num) {
	
		
		return new Random().ints().limit(num).mapToObj(String::valueOf).collect(Collectors.toList()).toString();
	}
	
	public List<Unit> dotest(){
		
		unitDAOImpl.save(Unit.create("save1","save2"));
		
		return unitDAOImpl.findAll();
	}
}
