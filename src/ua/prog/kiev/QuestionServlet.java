package ua.prog.kiev;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuestionServlet", urlPatterns = {"/stat", "/"})
public class QuestionServlet extends javax.servlet.http.HttpServlet {
    private String template = "<html>" +
            "<head><Title>Statistic</title></head>" +
            "<body>%s</body></html>";
    static public QuestionList questionList = new QuestionList(
            "Do you like JAVA?",
            "Do you like C#?",
            "Do you like Python?",
            "Do you like Coldplay?)"
    );

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        for(int i = 0; i < questionList.size(); i++){
            questionList.addAnswer(i, request.getParameter("answer".concat(String.valueOf(i))));
        }
        response.getWriter().println(template);
    }
}
