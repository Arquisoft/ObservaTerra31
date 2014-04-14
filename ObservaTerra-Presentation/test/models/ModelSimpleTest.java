package models;


import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.api.test.FakeApplication;
import play.test.WithApplication;
import static play.test.Helpers.*;


public class ModelSimpleTest extends WithApplication {
	
	 
	@Before
	    public void setUp() {
	        start(fakeApplication(inMemoryDatabase()));
	    }

	@Test
	public void create() {
		Area original= new Area("Crimea", ScopeEnum.COUNTRY);
		Area.create(original);
		Area founded = Area.findByName("Crimea");
		assertTrue(founded.equals(original));
	}
	
	@Test
	public void delete() {
		Area original= new Area("Australia", ScopeEnum.COUNTRY);
		Area.create(original);
	}
	
	

}
