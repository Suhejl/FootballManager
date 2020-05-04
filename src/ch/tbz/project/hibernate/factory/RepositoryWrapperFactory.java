package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.RepositoryWrapper;
import ch.tbz.project.hibernate.repo_interface.IRepositoryWrapper;

public class RepositoryWrapperFactory {
  private static IRepositoryWrapper repositoryWrapper;

  public static IRepositoryWrapper getRepositoryWrapper(){
    if (repositoryWrapper == null) {
      repositoryWrapper = new RepositoryWrapper();
    }
    return repositoryWrapper;
  }
}
