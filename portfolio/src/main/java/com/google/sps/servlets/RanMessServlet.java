package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/quotes")
public class RanMessServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String quotes ="{\"messages\": [\"The happiness of your life depends upon the quality of your thoughts.\",\"All for one and one for all, united we stand divided we fall.\",\"The merit of all things lies in their difficulty.\"]}";
    response.setContentType("application/json;");
    response.getWriter().println(quotes);
  }
  
}
