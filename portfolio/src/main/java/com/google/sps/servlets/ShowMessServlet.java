package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.data.UserMessage;

import org.eclipse.jetty.server.Authentication.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/show-message")
public class ShowMessServlet extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //We make instance of Datastore
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

        //We query for results
        Query<Entity> query =
            Query.newEntityQueryBuilder().setKind("UserMessage").build();
        QueryResults<Entity> results = datastore.run(query);

        List<UserMessage> messages = new ArrayList<>();
    while (results.hasNext()) {
      Entity entity = results.next();

      long id = entity.getKey().getId();
      String text = entity.getString("text");
      

      UserMessage message = new UserMessage(id, text);
      messages.add(message);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(messages));
    }
    
}
