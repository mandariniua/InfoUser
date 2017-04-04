
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.BranchElement;

import org.apache.catalina.ContainerServlet;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
			String line = null;
			String st = null;
			while ((line = br.readLine()) != null) {
				st = line;
			}
			if (st.contains(name)) {
				response.getWriter().write("Sorry this name is not available");
			} else {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))) {
					bw.write(name + " " + password + "|");
					response.getWriter().write("Thank you!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
