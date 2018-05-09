package domain.mediator;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.model.Member;

public class MemberListModelManagerTest {


	private MemberListModelManager model;

	@Before
	public void setUp() throws Exception
	{
		model= new MemberListModelManager();
	}


	@Test
	public void testAddMember() {
		Member member =new Member("ZUCC", "zucc@facebook.com", "ringring", 2017, "Reincarnation");
		Member member2 =new Member("KanyeWest", "LoveTrump@facebook.com", "Kanye-100-100", 2018, "Alternative Health Care");
		Member member3 =new Member("BillCosby", "Jail@facebook.com", "Jail-Number", 2017, "Trips");
		model.addMember(member);
		model.addMember(member2);
		model.addMember(member3);
		if(model.getPaidMembers().equals(model.getNotPaidMembers()))
			fail("Not list returned/wrong members returned");
		if(model.removeMember(0) != member)
			fail("Wrong Member removed/not removed");
		if(model.removeMember(0) != member2)
			fail("Wrong Member removed/not removed");
	}


	@After
	public void tearDown() throws Exception
	{
	// nothing
	}
}
