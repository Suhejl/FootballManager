package ch.tbz.project.manager;

import ch.tbz.project.hibernate.factory.RepositoryWrapperFactory;
import ch.tbz.project.hibernate.model.Player;
import ch.tbz.project.hibernate.model.Team;
import ch.tbz.project.hibernate.model.Trikot;
import ch.tbz.project.hibernate.repo_interface.IRepositoryWrapper;
import ch.tbz.project.util.ConsoleReader;

import java.util.ArrayList;

public class PlayerManager {
  IRepositoryWrapper repositoryWrapper = RepositoryWrapperFactory.getRepositoryWrapper();

  /**
   * Creates a player and its Foreign Keys
   * @param player Player to create
   */
  public void createPlayer(Player player){
    repositoryWrapper.getBootsRepository().create(player.getID_Boots());
    repositoryWrapper.getPlayerRepository().create(player);
  }

  /**
   * Adds a player to a team
   * @param player Player to add
   * @param team Team to get Player
   */
  public void addPlayerToTeam(Player player, Team team){
    String fullname = player.getFirstname() + " " + player.getLastname();
    Trikot trikot = new Trikot(fullname, team.getID_TrikotDesign());
    repositoryWrapper.getTrikotRepository().create(trikot);
    player.setID_Trikot(trikot);
    player.setID_Team(team);
    repositoryWrapper.getPlayerRepository().update(player);
  }

  public ArrayList<Player> getPlayers(){
    return (ArrayList<Player>) repositoryWrapper.getPlayerRepository().list();
  }
}
