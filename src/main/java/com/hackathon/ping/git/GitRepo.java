/**
 * 
 */
package com.hackathon.ping.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.DetachedHeadException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.RemoteConfig;


/**
 * 
 * @author schristou88
 *
 */
public class GitRepo {
	
	/**
	 * Create a new instance of a git repository.
	 * 
	 * @param remoteUrl
	 * @param localPath
	 * @throws IOException
	 */
	public GitRepo(String remoteUrl, String localPath) throws IOException {
		this.localPath = localPath;
		this.remoteUrl = remoteUrl;
		
		repository = new FileRepository(localPath + "/.git");
		git = new Git(repository);
	}
	
	public Git getRepository() {
		return git;
	}
	
	/**
	 * Create the repository
	 * 
	 * Git command: No command.
	 * 
	 * @throws IOException only if there are I/O issues.
	 */
	public void createRepo() throws IOException{
		repository.create();
	}
	
	/**
	 * Clone the repository.
	 * 
	 * Git command: git clone ${remoteUrl} ${localPath}
	 * 
	 * @throws InvalidRemoteException
	 * @throws TransportException
	 * @throws GitAPIException
	 */
	public void cloneRepo() throws InvalidRemoteException, TransportException, GitAPIException {
		Git.cloneRepository()
		   .setURI(remoteUrl)
		   .setDirectory(new File(localPath))
		   .call();
	}
	
	/**
	 * Accepts a file pattern for adding new files
	 * 
	 * E.g. A pattern of '*' means include everything
	 * 
	 * 
	 * Git command: git add "filePattern"
	 * 
	 * @param filePattern
	 * @throws NoFilepatternException
	 * @throws GitAPIException
	 */
	public void addFile(String filePattern) throws NoFilepatternException, GitAPIException {		
		git.add()
		   .addFilepattern(filePattern)
		   .call();
	}
	
	/**
	 * Push to repository
	 * 
	 * Git command: git pull
	 * 
	 * @throws InvalidRemoteException
	 * @throws TransportException
	 * @throws GitAPIException
	 */
	public void push() throws InvalidRemoteException, TransportException, GitAPIException {
		git.push()
		   .call();
		
	}
	
	/**
	 * Do a pull
	 * 
	 * Git command: git pull
	 * 
	 * @throws WrongRepositoryStateException
	 * @throws InvalidConfigurationException
	 * @throws DetachedHeadException
	 * @throws InvalidRemoteException
	 * @throws CanceledException
	 * @throws RefNotFoundException
	 * @throws NoHeadException
	 * @throws TransportException
	 * @throws GitAPIException
	 */
	public void pull() throws WrongRepositoryStateException, InvalidConfigurationException, DetachedHeadException, InvalidRemoteException, CanceledException, RefNotFoundException, NoHeadException, TransportException, GitAPIException {
		git.pull()
		   .call();
	}
	
	

	/**
	 * Remote URL
	 */
	private String remoteUrl;
	
	/**
	 * Local path on instance
	 */
	private String localPath;
	
	/**
	 * Actual git repository
	 */
	private Git git;
	
	/**
	 * Local repository on machine
	 */
	private Repository repository;
	
}