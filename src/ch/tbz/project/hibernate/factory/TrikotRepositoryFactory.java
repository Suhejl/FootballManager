package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.TrikotPersister;
import ch.tbz.project.hibernate.repo_interface.ITrikotRepository;

public class TrikotRepositoryFactory {
  private static ITrikotRepository trikotRepository;

  public static ITrikotRepository getTrikotRepository(){
    if (trikotRepository == null) {
      trikotRepository = new TrikotPersister();
    }
    return trikotRepository;
  }
}
