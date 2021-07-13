package myhome.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myhome.domain.MemberDao;
import myhome.domain.MemberDto;

@WebServlet("/view/member/manage")
public class ManageLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트가 관리자 유형인지?
		HttpSession session = request.getSession();
		MemberDto currentDto = 
				(MemberDto)session.getAttribute("currentDto");
		
		// 로그인을 안했거나 (세션이 만료되었거나), 회원 유형이 '관리자'가 아닌 경우
		if(currentDto == null || currentDto.getType() != 0) {
			// 로그인 페이지로 리다이렉트
			response.sendRedirect("/myhome/view/member/login.jsp");
			return;
		}
		
		MemberDao dao = MemberDao.getInstance();
		List<MemberDto> list = dao.selectAll();
		
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("manage.jsp")
				.forward(request, response);
		
	}
}
