package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class editPlayerServlet
 */
@WebServlet("/editPlayerServlet")
public class editPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editPlayerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlayerHelper ph = new PlayerHelper();
		String action = request.getParameter("doThisToPlayer");

		if (action == null) {
			getServletContext().getRequestDispatcher("/viewAllPlayers.jsp").forward(request, response);
		} else if (action.equals("Delete Selected Player")) {
			Integer id = Integer.parseInt(request.getParameter("playerId"));
			Player playerToDelete = ph.searchForPlayerById(id);
			ph.deletePlayers(playerToDelete);

			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);

		} else if (action.equals("Add New Player")) {
			getServletContext().getRequestDispatcher("/addANewPlayer.html").forward(request, response);

		} else if (action.equals("Edit Selected Player")) {

			Integer id = Integer.parseInt(request.getParameter("playerId"));
			//System.out.println("editPlayerServlet:" + id);
			Player playerToEdit = ph.searchForPlayerById(id);
			request.setAttribute("playerToEdit", playerToEdit);
			//System.out.println("editPlayerServlet:" + playerToEdit.toString());
			getServletContext().getRequestDispatcher("/editPlayer.jsp").forward(request, response);
		

		}
	}

}
