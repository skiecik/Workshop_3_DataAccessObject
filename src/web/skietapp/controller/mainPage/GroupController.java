package web.skietapp.controller.mainPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.skietapp.connection.DbUtil;
import web.skietapp.dao.GroupDao;
import web.skietapp.model.Group;

@WebServlet("/groups")
public class GroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try (Connection conn = DbUtil.getConn()){
			List<Group> groups = GroupDao.readAllGroups(conn);
			request.setAttribute("groups", groups);
			getServletContext().getRequestDispatcher("/views/groupsView.jsp").forward(request, response);
			
		} catch (SQLException e) {
			response.getWriter().append("Something goes wrong!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
