package net.codejava.javaee.bookstore.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CheckLoginTest.class, GetOneUser.class, ListAllUserTest.class })
public class AllTests_UserDAO {

}
