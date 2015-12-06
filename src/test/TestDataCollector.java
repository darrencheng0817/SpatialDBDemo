package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import model.Ambulance;
import model.Lion;
import model.Pond;
import model.Region;
import src.DataCollector;

public class TestDataCollector {
	DataCollector dc;
	static final int ExpectedRegionCount=16;
	static final int ExpectedLionsCount=14;
	static final int ExpectedPondCount=8;
	static final int ExpectedAmbulanceCount=5;
	@Before
	public void setUp() throws Exception {
		dc=new DataCollector();
	}

	@Test
	public void testGetRegions() {
		List<Region> expectedResult=new LinkedList<>();
		List<Region> actualResult=new LinkedList<>();
		dc.getRegions(actualResult);
		assertEquals(ExpectedRegionCount, actualResult.size());
	}
	@Test
	public void testGetLions() {
		List<Lion> expectedResult=new LinkedList<>();		
		List<Lion> actualResult=new LinkedList<>();
		dc.getLions(actualResult);
		assertEquals(ExpectedLionsCount, actualResult.size());
	}
	@Test
	public void testGetPonds(){
		List<Pond> expectedResult=new LinkedList<>();	
		List<Pond> actualResult=new LinkedList<>();
		dc.getPonds(actualResult);
		assertEquals(ExpectedPondCount, actualResult.size());
	}
	@Test
	public void testGetAmbulances(){
		List<Ambulance> expectedResult=new LinkedList<>();
		List<Ambulance> actualResult=new LinkedList<>();
		dc.getAmbulances(actualResult);
		assertEquals(ExpectedAmbulanceCount, actualResult.size());
	}
}
