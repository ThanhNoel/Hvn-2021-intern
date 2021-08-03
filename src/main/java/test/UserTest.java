package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.User;

public class UserTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	private User createTestSubject() {
		return new User();
	}

	@Test
	public void testCheckAge() throws Exception {
		User testSubject;
		int a = 84;
		boolean result;
		boolean expected = true;

		// default test
		testSubject = createTestSubject();
		result = testSubject.checkAge(a);
		assertEquals(expected, result);
	}

	@Test
	public void testCheckUserEmail() throws Exception {
		User testSubject;
		String str = "letunglam001@gmail.com";
		boolean result;
		boolean expected = true;
		// default test
		testSubject = createTestSubject();
		result = testSubject.checkUserEmail(str);
		assertEquals(expected, result);
	}

	@Test
	public void testCheckUserName() throws Exception {
		User testSubject;
		String str = "Lam1";
		boolean result;	
		boolean expected = false;
		// default test
		testSubject = createTestSubject();
		result = testSubject.checkUserName(str);
		assertEquals(expected, result);
	}
}