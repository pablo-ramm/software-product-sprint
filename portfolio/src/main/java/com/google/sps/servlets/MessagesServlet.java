package com.google.sps.servlets;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.SortingFocusTraversalPolicy;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/messages")
public class MessagesServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    RequestDispatcher rd = request.getRequestDispatcher("messages.html");
    try{
    rd.include(request, response);
    }catch(Exception e){
        System.out.println(e);
    }
  }
  
}