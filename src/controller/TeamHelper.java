package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

public class TeamHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("bowlingleaguepettigrew");

	public void addTeam(Team toAdd) {
		// TODO Auto-generated method stub

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
/*	public List<Team> showAllTeamsWithPlayers() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Team> allResults = em.createQuery("select t.teamName, p.firstName, p.lastName from Team t join Player p on t.teamId = p.teamId", Team.class);
		List<Team> allTeamsWithPlayers = allResults.getResultList();
		em.close();
		return allTeamsWithPlayers;
	}*/
	
	public List<Team> showAllTeams() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Team> allResults = em.createQuery("select t from Team t ", Team.class);
		List<Team> allTeams = allResults.getResultList();
		em.close();
		return allTeams;
	}
	
/*	public void deleteTeams(Team toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select t from Team t where t.teamName = :selectedTeamName",Team.class);
		typedQuery.setParameter("selectedTeamName", toDelete.getTeamName());
		typedQuery.setMaxResults(1);
		Team result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}*/
	
	public void deleteTeams(Team toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team find = em.find(Team.class, toDelete.getTeamId());
		em.remove(find);
		em.getTransaction().commit();
		em.close();
	}
	
	public Team searchForTeamByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select t from Team t where t.teamName = :selectedTeamName", Team.class);
		typedQuery.setParameter("selectedTeamName", name);
		typedQuery.setMaxResults(1);
		Team result = typedQuery.getSingleResult();
		em.close();
		return result;
	}
	
	public void updateTeam(Team toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public Team searchForTeamById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Team foundTeam = em.find(Team.class, idToEdit);
		em.close();
		return foundTeam;
	}
	
	}