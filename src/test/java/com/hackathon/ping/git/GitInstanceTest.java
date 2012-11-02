package com.hackathon.ping.git;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.eclipse.egit.github.core.Repository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

public class GitInstanceTest extends LiveTest {
	GitInstance GITINSTANCE;
	
	@Before
	public void setUp() {
		GITINSTANCE = GitInstance.getInstance();
	}
	
	
	@Test
	public void testGitRepoConstructor() throws IOException {
		assertNotNull("Environment variable: github.test.password \n is not set.");
		GITINSTANCE.login(client.getUser(), System.getProperty("github.test.password").toCharArray());
	}
}
