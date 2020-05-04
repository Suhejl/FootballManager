package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.TrikotDesignRepository;
import ch.tbz.project.hibernate.repo_interface.ITrikotDesignRepository;

public class TrikotDesignRepositoryFactory {
  private static ITrikotDesignRepository trikotDesignRepository;

  public static ITrikotDesignRepository getTrikotDesignRepository(){
    if (trikotDesignRepository == null) {
      trikotDesignRepository = new TrikotDesignRepository();
    }
    return trikotDesignRepository;
  }
}
