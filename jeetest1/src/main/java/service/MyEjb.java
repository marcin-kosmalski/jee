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
	
	@Inject
	private MySingleton mySingleton;

	public String generateNumber(int num) {
	
		
		return new Random().ints().limit(num).mapToObj(String::valueOf).collect(Collectors.toList()).toString();
	}
	
	public void testSingleton(){
		
		Unit unit=Unit.create("save1","save2");
		unit=unitDAOImpl.save(unit);
		mySingleton.update(unit, unit.getId());
	}
	
	public List<Unit> dotest(){
		
		unitDAOImpl.save(Unit.create("save1","save2"));
		
		return unitDAOImpl.findAll();
	}
}
