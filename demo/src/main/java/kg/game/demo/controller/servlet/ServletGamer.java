package kg.game.demo.controller.servlet;

import kg.game.demo.controller.GamerController;
import kg.game.demo.entity.Gamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gamerlog")
public class ServletGamer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Gamer gamer = new Gamer();
        gamer.setFullName(req.getParameter("fullName"));
        gamer.setAge(Long.valueOf(req.getParameter("age")));
        gamer.setGender(req.getParameter("gender"));
        GamerController webGamer = new GamerController();
        webGamer.saveGamer(gamer);
        PrintWriter outWrite = resp.getWriter();
        outWrite.println("<h1> Hi i withe promis working</h1>");

    }
}
