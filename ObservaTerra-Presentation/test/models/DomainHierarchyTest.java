package models;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.Before;

public class DomainHierarchyTest {

	Map<String, Organization> orgs;

	@Before
	public void organizations() {
		orgs = new HashMap<String, Organization>();

		Organization wshh = new SampleOrganization("World Star Hiphop", "", "");
		Organization nike = new SampleOrganization("Nike", "", "");
		Organization apple = new SampleOrganization("Apple", "", "");
		Organization jordan = new SampleOrganization("Jordan", "", "");
		Organization reebok = new SampleOrganization("Reebok", "", "");
		Organization microsoft = new SampleOrganization("Microsoft", "", "");

		orgs.put(wshh.getName(), wshh);
		orgs.put(nike.getName(), nike);
		orgs.put(apple.getName(), apple);
		orgs.put(jordan.getName(), jordan);
		orgs.put(reebok.getName(), reebok);
		orgs.put(microsoft.getName(), microsoft);
	}

	@Test
	public void testSampleAppendOrganization() {
		Organization microsoft = orgs.get("Microsoft");
		Organization reebok = orgs.get("Reebok");

		Organization result = reebok.addOrganization("Illuminati", "TRIANGLE",
				"KAYNEWESTWHYULEFTNIKE???", microsoft);
		assertTrue(result != null);
	}

	@Test
	public void testInfiniteRecursion() {
		Organization a = orgs.get("Microsoft");
		Organization result = a.addOrganization("Illuminati", "TRIANGLE",
				"KAYNEWESTWHYULEFTNIKE???", a);

		assertTrue(result == null);
	}

	@Test
	public void testComplexAppendRemoveOrganization() {
		Organization apple = orgs.get("Apple");
		Organization nike = orgs.get("Nike");
		Organization wshh = orgs.get("World Star Hiphop");
		Organization jordan = orgs.get("Jordan");

		Organization result = jordan.addOrganization("Swaginess", "YOLO",
				": D", nike);

		assertTrue(result != null);
		assertTrue(jordan.getParent().equals(result));
		assertTrue(nike.getParent().equals(result));
		assertTrue(result.getOrganizations().contains(jordan));
		assertTrue(result.getOrganizations().contains(nike));

		Organization djKhaled = apple.addOrganization("DJKHALED", "WETEHBEST",
				"", wshh);
		assertTrue(djKhaled != null);

		Organization djKhaled2 = apple.addOrganization("DJKHALED", "WETEHBEST",
				"", wshh);
		assertTrue(djKhaled2 == null);

		Organization illuminati = djKhaled.addOrganization("Illuminati",
				"TRIANGLE", "KAYNEWESTWHYULEFTNIKE???", result);

		assertTrue(illuminati != null);
		assertTrue(djKhaled.getParent().equals(illuminati));
		assertTrue(result.getParent().equals(illuminati));

		illuminati.removeOrganization(djKhaled);
		assertTrue(djKhaled.getParent() == null);
		assertFalse(illuminati.getOrganizations().contains(djKhaled));
		Organization revert = illuminati.addOrganization("", "", "", djKhaled);
		assertTrue(!revert.equals(illuminati));
		assertTrue(revert.getName().isEmpty());
	}

}
