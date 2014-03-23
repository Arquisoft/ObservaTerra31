import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import domain.Area;
import domain.ComplexOrganization;
import domain.Indicator;
import domain.InstantTime;
import domain.Observation;
import domain.Organization;
import domain.RangeTime;
import domain.SampleOrganization;
import domain.ScopeEnum;
import domain.Time;
import domain.User;

public class DomainTest {

	@Test
	public void sampleTestObservation() {
		Area area = new Area("Ethiopia", ScopeEnum.COUNTRY);
		Indicator indicator = new Indicator("HIV");
		Time time = new RangeTime(new InstantTime("2000"), new InstantTime(
				"2005"));
		Organization provider = new SampleOrganization("WorldStar HipHop",
				"WSHH", "http://www.worldstarhiphop.com");
		Long now = System.currentTimeMillis();
		Date publish = new Date(now);
		Observation observation = new Observation(time, "10%", indicator, area,
				provider, publish);

		assertTrue(indicator.getObservations().size() == 1);
		assertTrue(observation.getIndicator().equals(indicator));

		assertTrue(area.getObservations().size() == 1);
		assertTrue(observation.getArea().equals(area));

		assertTrue(observation.getTime().equals(time));
		assertTrue(observation.getPublishDate().equals(publish));

		assertTrue(provider.getObservations().size() == 1);
		assertTrue(observation.getProvider().equals(provider));

	}

	@Test
	public void sampleTestFollow() {

		User jayZ = new User("Jay", "Z", "jayz@brookylnfinest.com",
				"DrunkInL0veWitBeyonnn");
		User ai = new User("Allen", "Iverson", "ai@philly.com",
				"weTalkinBoutPractiseNotRealGame");

		Indicator sneakers = new Indicator("Sneakers Realeses");
		Indicator beyonceSingles = new Indicator("Beyonce Singles Realese");

		assertTrue(sneakers.getFollows().size() == 0);
		assertTrue(beyonceSingles.getFollows().size() == 0);
		assertTrue(ai.getFollows().size() == 0);
		assertTrue(jayZ.getFollows().size() == 0);

		jayZ.follow(sneakers);
		ai.follow(sneakers);

		assertTrue(sneakers.getFollows().size() == 2);
		assertTrue(ai.getFollows().size() == 1);
		assertTrue(jayZ.getFollows().size() == 1);
		assertTrue(beyonceSingles.getFollows().size() == 0);

		jayZ.unfollow(sneakers);

		assertTrue(sneakers.getFollows().size() == 1);
		assertTrue(ai.getFollows().size() == 1);
		assertTrue(jayZ.getFollows().size() == 0);
		assertTrue(beyonceSingles.getFollows().size() == 0);

		jayZ.follow(beyonceSingles);

		assertTrue(sneakers.getFollows().size() == 1);
		assertTrue(ai.getFollows().size() == 1);
		assertTrue(jayZ.getFollows().size() == 1);
		assertTrue(beyonceSingles.getFollows().size() == 1);

	}

	@Test
	public void sampleTestOrganization() {

		User jayZ = new User("Jay", "Z", "jayz@brookylnfinest.com",
				"DrunkInL0veWitBeyonnn");
		User ai = new User("Allen", "Iverson", "ai@philly.com",
				"weTalkinBoutPractiseNotRealGame");
		Organization provider = new SampleOrganization("WorldStar HipHop",
				"WSHH", "http://www.worldstarhiphop.com");

		assertTrue(ai.getOrganization() == null);
		assertTrue(jayZ.getOrganization() == null);
		assertTrue(provider.getUsers().size() == 0);
		assertTrue(provider.getObservations().size() == 0);

		provider.addUser(ai);

		assertTrue(ai.getOrganization().equals(provider));
		assertTrue(jayZ.getOrganization() == null);
		assertTrue(provider.getUsers().size() == 1);

		provider.removeUser(ai);

		assertTrue(ai.getOrganization() == null);
		assertTrue(jayZ.getOrganization() == null);
		assertTrue(provider.getUsers().size() == 0);

		provider.removeUser(ai);

		assertTrue(ai.getOrganization() == null);
		assertTrue(jayZ.getOrganization() == null);
		assertTrue(provider.getUsers().size() == 0);

		provider.addUser(ai);
		provider.addUser(ai);

		assertTrue(ai.getOrganization().equals(provider));
		assertTrue(jayZ.getOrganization() == null);
		assertTrue(provider.getUsers().size() == 1);

		provider.removeUser(ai);
		provider.addUser(jayZ);

		assertTrue(ai.getOrganization() == null);
		assertTrue(jayZ.getOrganization().equals(provider));
		assertTrue(provider.getUsers().size() == 1);

		assertTrue(ai.getOrganization() == null);
		assertTrue(jayZ.getOrganization().equals(provider));

	}

	@Test
	public void sampleTestComplexOrganization() {

		Set<Organization> organizations = new HashSet<Organization>();

		Organization wshh = new SampleOrganization("WorldStar HipHop", "WSHH",
				"http://www.worldstarhiphop.com");
		Organization nba = new SampleOrganization(
				"National Basketball Association", "NBA", "http://www.nba.com");

		User jayZ = new User("Jay", "Z", "jayz@brookylnfinest.com",
				"DrunkInL0veWitBeyonnn");
		User ai = new User("Allen", "Iverson", "ai@philly.com",
				"weTalkinBoutPractiseNotRealGame");

		wshh.addUser(jayZ);

		organizations.add(wshh);
		organizations.add(nba);

		Organization cosaNostra = new ComplexOrganization("La Cosa Nostra",
				"TS", "http://www.tonysopranowaityouinnewjersey.com",
				organizations);

		assertTrue(cosaNostra.getUsers().size() == 1);
		assertTrue(wshh.removeUser(jayZ).getUsers().size() == 0);
		assertFalse(cosaNostra.getUsers().size() == 1);

		assertTrue(nba.addUser(ai).getUsers().size() == 1);
		assertTrue(cosaNostra.getUsers().size() == 1);

		assertTrue(jayZ.getOrganization() == null);
		assertTrue(ai.getOrganization().equals(nba));
		assertTrue(cosaNostra.getUsers().contains(ai));

	}

	@Test
	public void testAddOrganizations() {
		Organization wshh = new SampleOrganization("WorldStar HipHop", "WSHH",
				"http://www.worldstarhiphop.com");
		Organization nba = new SampleOrganization(
				"National Basketball Association", "NBA", "http://www.nba.com");
		Organization cosaNostra = nba.addOrganization("La cosa nostra",
				"http://www.tonysopranoJustTakeItEasy.com", "TS", wshh);
		assertFalse(cosaNostra == null);
		assertTrue(cosaNostra.removeOrganization(nba).getOrganizations().size() == 1);
		assertTrue(cosaNostra.removeOrganization(wshh).getOrganizations()
				.size() == 0);
		assertTrue(cosaNostra != null);
		assertTrue(cosaNostra.addOrganization("Iluminati",
				"http://www.kaynewest.com", "KW", nba) != null);

	}

}
