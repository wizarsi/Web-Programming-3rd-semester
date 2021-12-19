import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    Integer t;
    HttpServletResponse response;
    HttpServletRequest request;
    ServletContext servletContext;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        servletContext = request.getServletContext();
        response.setCharacterEncoding("UTF-8");
        makeAnswer();
    }

    public void makeAnswer() throws ServletException, IOException {
        String pathCheck = "/AreaCheckServlet";
        String paramT = request.getParameter("t");
        if (paramT != null) {
            t = Integer.parseInt(paramT);
            servletContext.setAttribute("t",t);
            if (t == 1) {
                contextWork(1);
                request.getRequestDispatcher(pathCheck).forward(request, response);
            } else if (t == 2) {
                contextWork(2);
                clearServletContext();
            } else if (t == 3) {
                contextWork(3);
            }

        }
    }

    public void clearServletContext() {
        servletContext.removeAttribute("answer");
        servletContext.removeAttribute("number");
        servletContext.removeAttribute("t");
    }

    public void contextWork(int t) throws IOException, ServletException {
        if (t == 1 && servletContext.getAttribute("answer") == null) {
            servletContext.setAttribute("answer", new LinkedList<String>());
            servletContext.setAttribute("number", 0);
        } else if (t == 2) {
            LinkedList<String> answer =new LinkedList<>();
            String s = "<td>Данных пока нет</td>";
            answer.add("<tr>" + s + s + s + s + s + s+"</tr>");
            servletContext.setAttribute("answer",
                    answer);
            request.getRequestDispatcher("index_upd.jsp").forward(request,response);
        } else if (t == 3 && servletContext.getAttribute("answer") != null) {
            response.sendRedirect("index_upd.jsp");
        }

    }



}
