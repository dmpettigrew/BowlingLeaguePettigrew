package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class completeEditOfTeamServlet
 */
@WebServlet("/completeEditOfTeamServlet")
public class completeEditOfTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public completeEditOfTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeamHelper dao = new TeamHelper();
		String teamName = request.getParameter("teamName");
		String teamType = request.getParameter("teamType");
		String preferredNight = request.getParameter("preferredNight");
		Integer id = Integer.parseInt(request.getParameter("id"));
		//System.out.println("completeEditOfTeamServlet:" + id);
		
		Team teamToUpdate = dao.searchForTeamById(id);
		//System.out.println("Found team based on id:" + teamToUpdate.toString());
		teamToUpdate.setTeamName(teamName);
		teamToUpdate.setTeamType(teamType);
		teamToUpdate.setPreferredNight(preferredNight);
		//System.out.println("team updates:" + teamToUpdate.toString());
		
		dao.updateTeam(teamToUpdate);
		//System.out.println("After teamToUpdate");
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}
