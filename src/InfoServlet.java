

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("password");
		
		try (BufferedWriter buff = new BufferedWriter(new FileWriter("infoUsers.txt", true))) {
			
			try(FileReader fr = new FileReader("infoUsers.txt"); BufferedReader br = new BufferedReader(fr)) {
				StringBuffer sb = new StringBuffer();
				
				String line;
				while((line = br.readLine())!= null) {
					sb.append(line);
				}
				if(sb.append(line).equals(name + " " + email)) {
					response.getWriter().write("Sorry this login is empty");
				} else {
					response.getWriter().write("Thank you!");
					for (int i = 0; i < 1 ; i++) {
						buff.newLine();
						buff.write("Login: " + name + " - " + "Password: " + email + "\n");
					}
				}
				
			} 			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
								
		
	}

}
