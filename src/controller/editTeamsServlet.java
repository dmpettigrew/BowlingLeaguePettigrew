package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class editTeamsServlet
 */
@WebServlet("/editTeamsServlet")
public class editTeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editTeamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeamHelper th = new TeamHelper();
		String action = request.getParameter("doThisToTeam");
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/viewAllTeams.jsp").forward(request, response);
		} else if (action.equals("Delete Selected Team")) {
			Integer id = Integer.parseInt(request.getParameter("teamId"));
			Team teamToDelete = th.searchForTeamById(id);
			th.deleteTeams(teamToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
			
		} else if (action.equals("Add New Team")) {
			getServletContext().getRequestDispatcher("/addTeamInfo.html").forward(request, response);
			
		} else if (action.equals("Edit Selected Team")) {
			
			Integer id = Integer.parseInt(request.getParameter("teamId"));
			//System.out.println(id);
			Team teamToEdit = th.searchForTeamById(id);
			request.setAttribute("teamToEdit", teamToEdit);
			//System.out.println(teamToEdit.toString());
			getServletContext().getRequestDispatcher("/editTeam.jsp").forward(request, response);
			//getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		}
	}

}
