package com.hackathon.ping.git;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GitRepoTest {

//	@Mock
	GitRepo gitrepo;
	@Before
	public void setUp() throws IOException {
		gitrepo = new GitRepo("https://github.com/christ66/subversion-plugin.git", "/tmp/gittest");
	}

	@Test(expected = IllegalStateException.class)
	public void testCreateRepo() throws IOException {
		gitrepo.createRepo();
		fail("Should create repo during setup.");
	}

	@Test
	public void testCloneRepo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddFile() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testPush() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testPull() {
		fail("Not yet implemented"); // TODO
	}

}
