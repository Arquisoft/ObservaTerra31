package persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import models.Area;
import models.ComplexOrganization;
import models.Follow;
import models.Indicator;
import models.InstantTime;
import models.Observation;
import models.Organization;
import models.SampleOrganization;
import models.ScopeEnum;
import models.Time;
import models.User;

public class PersistenceSimulator {

	private static PersistenceSimulator instance;

	private List<Area> areas;
	private List<Organization> organizations;
	private List<Follow> follows;
	private List<Indicator> indicators;
	private List<Observation> observations;
	private List<User> users;
	private Long counter = 1L;

	private PersistenceSimulator() {
		try {
			areas = new ArrayList<Area>();
			organizations = new ArrayList<Organization>();
			follows = new ArrayList<Follow>();
			indicators = new ArrayList<Indicator>();
			observations = new ArrayList<Observation>();
			users = new ArrayList<User>();
			createFakeDatabase();
		} catch (Exception e) {
			System.err.println("Wroooong:\n\t" + e.getMessage());
		}
	}

	public static PersistenceSimulator getInstance() {
		if (instance == null)
			instance = new PersistenceSimulator();
		return instance;
	}

	public User loginService(String email, String password) {
		for (User user : users)
			if (user.getEmail().equals(email)
					&& user.getPassword().equals(password))
				return user;
		return null;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public List<Indicator> getIndicators() {
		return indicators;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public List<User> getUsers() {
		return users;
	}

	private void createFakeDatabase() throws ParseException {

		Area brazil = new Area("Brazil", ScopeEnum.COUNTRY);
		Area usa = new Area("United States of America", ScopeEnum.COUNTRY);
		Area canada = new Area("Canada", ScopeEnum.COUNTRY);
		Area australia = new Area("Australia", ScopeEnum.COUNTRY);
		Area china = new Area("China", ScopeEnum.COUNTRY);
		Area baltimore = new Area("Baltimore (st.Maryland)", ScopeEnum.REGION);
		Area crimea = new Area("Countries in war", ScopeEnum.GROUPOFCOUNTRIES);

		areas.add(brazil);
		areas.add(usa);
		areas.add(canada);
		areas.add(australia);
		areas.add(china);
		areas.add(baltimore);
		areas.add(crimea);

		Set<Organization> orgs = new HashSet<Organization>();
		Organization microsoft = new SampleOrganization("Microsoft",
				"http://www.microsoft.com", "MS");
		Organization google = new SampleOrganization("Google",
				"http://www.google.com", "G");
		Organization wshh = new SampleOrganization("WorldStar HipHop",
				"http://www.wshh.com", "WSHH");
		orgs.add(microsoft);
		orgs.add(google);
		Organization unitedNations = new ComplexOrganization("United Nations",
				"http://www.un.org", "UN", orgs);

		organizations.add(microsoft);
		organizations.add(google);
		organizations.add(wshh);
		organizations.add(unitedNations);

		Indicator hiphop = new Indicator("hiphop presence");
		Indicator hiv = new Indicator("HIV presence");
		Indicator criminalRate = new Indicator("criminal rate");
		Indicator population = new Indicator("population");

		indicators.add(hiphop);
		indicators.add(hiv);
		indicators.add(criminalRate);
		indicators.add(population);

		User natalia = new User("Natalia", "Negri",
				"natalianegri@nohacenada.com", "nohagonada");
		User gonzalo = new User("Gonzalo", "Alonso", "ga@ga.com", "quietman");
		User lara = new User("Lara", "Alvarez", "lara@la.com",
				"jijixdxdnomyamspabaaa");
		User victor = new User("Victor", "Fernandez", "pepe@gmail.com",
				"0a128b1f11e23725cef6bc8bcc2e0dc3");
		User andrea = new User("Andrea", "Sanchez", "andrea@cern.com",
				"respectdaarchitect");
		User sergio = new User("Sergio", "G", "real@gangsta.com",
				"alleniverson<3nohomo");
		User labra = new User("Emilio", "Labra", "labra@uniovi.com", "labra");
		User easyLogin = new User("user", "user", "user", "user");

		users.add(natalia);
		users.add(gonzalo);
		users.add(lara);
		users.add(victor);
		users.add(andrea);
		users.add(sergio);
		users.add(labra);
		users.add(easyLogin);

		follows.add(new Follow(hiphop, sergio));
		follows.add(new Follow(hiv, sergio));
		follows.add(new Follow(criminalRate, sergio));

		follows.add(new Follow(population, andrea));
		follows.add(new Follow(hiphop, andrea));

		follows.add(new Follow(criminalRate, victor));
		follows.add(new Follow(population, victor));

		follows.add(new Follow(criminalRate, lara));
		follows.add(new Follow(population, lara));

		follows.add(new Follow(hiphop, gonzalo));

		follows.add(new Follow(hiv, natalia));

		// Labra no follows.

		follows.add(new Follow(criminalRate, easyLogin));

		Time _2k3 = new InstantTime("2003");
		Time _2k4 = new InstantTime("2004");
		Time _2k5 = new InstantTime("2005");
		Time _2k7 = new InstantTime("2007");
		//Time _2k = new RangeTime(_2k3, _2k7);

		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");

		Observation ob_hiv_1 = new Observation(++counter, _2k3, "10", "%", hiv, brazil,
				wshh, dateParser.parse("2004-08-10"));
		Observation ob_hiv_2 = new Observation(++counter,_2k3, "60", "%", hiv, usa, wshh,
				dateParser.parse("2004-08-10"));
		Observation ob_hiv_3 = new Observation(++counter,_2k3, "40", "%", hiv, canada,
				wshh, dateParser.parse("2004-08-10"));
		Observation ob_hiv_4 = new Observation(++counter,_2k3, "20", "%", hiv, crimea,
				wshh, dateParser.parse("2004-08-10"));
		Observation ob_hiv_5 = new Observation(++counter,_2k3, "100", "%", hiv,
				baltimore, wshh, dateParser.parse("2004-08-10"));

		observations.add(ob_hiv_1);
		observations.add(ob_hiv_2);
		observations.add(ob_hiv_3);
		observations.add(ob_hiv_4);
		observations.add(ob_hiv_5);
		
		Observation ob_criminal_rate_1 = new Observation(++counter,_2k4, "10", "%",
				criminalRate, usa, microsoft, dateParser.parse("2007-08-10"));
		Observation ob_criminal_rate_2 = new Observation(++counter,_2k4, "40", "%",
				criminalRate, brazil, microsoft, dateParser.parse("2007-08-10"));
		Observation ob_criminal_rate_3 = new Observation(++counter,_2k4, "60", "%",
				criminalRate, baltimore, microsoft,
				dateParser.parse("2007-08-10"));
		Observation ob_criminal_rate_4 = new Observation(++counter,_2k4, "20", "%",
				criminalRate, crimea, microsoft, dateParser.parse("2007-08-10"));
		Observation ob_criminal_rate_5 = new Observation(++counter,_2k4, "50", "%",
				criminalRate, canada, microsoft, dateParser.parse("2007-08-10"));

		observations.add(ob_criminal_rate_1);
		observations.add(ob_criminal_rate_2);
		observations.add(ob_criminal_rate_3);
		observations.add(ob_criminal_rate_4);
		observations.add(ob_criminal_rate_5);

		Observation ob_population_1 = new Observation(++counter,_2k5, "28000000000",
				"habitants", population, china, google,
				dateParser.parse("20010-08-10"));
		Observation ob_population_2 = new Observation(++counter,_2k5, "10000000000",
				"habitants", population, baltimore, google,
				dateParser.parse("20010-08-10"));
		Observation ob_population_3 = new Observation(++counter,_2k5, "30000000000",
				"habitants", population, canada, google,
				dateParser.parse("20010-08-10"));
		Observation ob_population_4 = new Observation(++counter,_2k5, "21000000000",
				"habitants", population, usa, google,
				dateParser.parse("20010-08-10"));
		Observation ob_population_5 = new Observation(++counter,_2k5, "11000000000",
				"habitants", population, brazil, google,
				dateParser.parse("20010-08-10"));

		observations.add(ob_population_1);
		observations.add(ob_population_2);
		observations.add(ob_population_3);
		observations.add(ob_population_4);
		observations.add(ob_population_5);

		Observation ob_hiphop_1 = new Observation(++counter,_2k7, "80", "%", hiphop, usa,
				wshh, dateParser.parse("2012-08-10"));
		Observation ob_hiphop_2 = new Observation(++counter,_2k7, "80", "%", hiphop,
				china, wshh, dateParser.parse("2012-08-10"));
		Observation ob_hiphop_3 = new Observation(++counter,_2k7, "20", "%", hiphop,
				canada, wshh, dateParser.parse("2012-08-10"));
		Observation ob_hiphop_4 = new Observation(++counter,_2k7, "50", "%", hiphop,
				brazil, wshh, dateParser.parse("2012-08-10"));
		Observation ob_hiphop_5 = new Observation(++counter,_2k7, "90", "%", hiphop,
				baltimore, wshh, dateParser.parse("2012-08-10"));

		observations.add(ob_hiphop_1);
		observations.add(ob_hiphop_2);
		observations.add(ob_hiphop_3);
		observations.add(ob_hiphop_4);
		observations.add(ob_hiphop_5);

	}

	public List<Observation> findHVIObservations() {
		List<Observation> ret = new ArrayList<Observation>();
		for (Observation ob : observations)
			if (ob.getIndicator().getName().contains("HIV"))
				ret.add(ob);
		return ret;
	}

}
