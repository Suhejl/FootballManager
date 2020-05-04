package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.BootsRepository;
import ch.tbz.project.hibernate.repo_interface.IBootsRepository;

public class BootsRepositoryFactory {
  private static IBootsRepository bootsRepository;

  public static IBootsRepository getBootsRepository(){
    if (bootsRepository == null) {
      bootsRepository = new BootsRepository();
    }
    return bootsRepository;
  }
}
