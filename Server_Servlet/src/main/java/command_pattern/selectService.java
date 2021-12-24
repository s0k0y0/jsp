package command_pattern;

import java.util.ArrayList;




import javax.servlet.http.HttpServletRequest;

public class selectService {

	public ArrayList<EmpDTO> execute(HttpServletRequest request, HttpServletRequest response) {

		EmpDAO dao=new EmpDAO();
		System.out.println("B");
		return dao.select();
	}

}
