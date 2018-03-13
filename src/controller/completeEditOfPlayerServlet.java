package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class completeEditOfPlayerServlet
 */
@WebServlet("/completeEditOfPlayerServlet")
public class completeEditOfPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public completeEditOfPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlayerHelper dao = new PlayerHelper();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String screenName = request.getParameter("screenName");
		Integer id = Integer.parseInt(request.getParameter("playerId"));
		//System.out.println("playerId just parsed:" + id);
		Player playerToUpdate = dao.searchForPlayerById(id);
		//System.out.println("Found player based on id:" + playerToUpdate.toString());
		playerToUpdate.setFirstName(firstName);
		playerToUpdate.setLastName(lastName);
		playerToUpdate.setPhoneNumber(phoneNumber);
		playerToUpdate.setScreenName(screenName);
		//System.out.println("player updates:" + playerToUpdate.toString());
		
		dao.updatePlayer(playerToUpdate);
		//System.out.println("After playerToUpdate");
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}

}
