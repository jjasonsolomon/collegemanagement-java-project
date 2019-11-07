package com.jas.servlets;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jas.bean.Department;
import com.jas.dao.DepartmentDao;




@WebServlet("/")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	private DepartmentDao depDao;	
	public void init() {
		depDao = new DepartmentDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertDep(request, response);
				break;
			case "/delete":
				deleteDep(request, response);
				break;
			case "/edit":
				showEditDep(request, response);
				break;
			case "/update":
				updateDep(request, response);
				break;
			case "/list":
				listDep(request, response);
				break;
			default:
				response.sendRedirect("login.jsp");
			
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listDep(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Department> listDep = depDao.selectAllDep();
		request.setAttribute("listDep", listDep);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dep-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("dep-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void showEditDep(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		String d_name = request.getParameter("d_name");
		Department existingDep = depDao.selectDep(d_name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dep-form.jsp");
		request.setAttribute("dep", existingDep);
		dispatcher.forward(request, response);

	}
	
	private void insertDep(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String d_name = request.getParameter("d_name");
		String location = request.getParameter("location");
		String hod = request.getParameter("hod");
		Department newDep = new Department(d_name,location, hod);
		depDao.insertDep(newDep);
		response.sendRedirect("list");
	}
	
	private void updateDep(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String d_name = request.getParameter("d_name");
		String location = request.getParameter("location");
		String hod = request.getParameter("hod");
		Department dep = new Department(d_name,location, hod);
		depDao.updateDep(dep);

		response.sendRedirect("list");
	}

	private void deleteDep(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String dname = request.getParameter("d_name");
		depDao.deleteDep(dname);
		response.sendRedirect("list");

	}
	
}