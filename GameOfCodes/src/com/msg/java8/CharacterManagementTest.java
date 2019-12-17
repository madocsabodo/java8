package com.msg.java8;



import static org.junit.Assert.assertTrue;

import org.junit.*;



public class CharacterManagementTest {
	
	CharacterManagement characterManagement = new CharacterManagement();
	
	@Before
	public void setUp() {
		characterManagement.readCharacters();
	}
	
	@Test
	public void testMaleStarkCount() {
		long maleStarkCount =  characterManagement.maleStarkCount();
		
		characterManagement.maleStarkList();
		
		assertTrue(maleStarkCount == 72);
	}
	

	@Test
	public void testTotalAgePerHouse() {
		Integer totalAgePerHouse =  characterManagement.totalAgePerHouse("House Stark");
		
		assertTrue(totalAgePerHouse == 348);
	}

}
