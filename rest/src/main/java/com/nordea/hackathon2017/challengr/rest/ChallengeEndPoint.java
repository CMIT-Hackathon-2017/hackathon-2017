package com.nordea.hackathon2017.challengr.rest;

import com.nordea.hackathon2017.pojo.User;
import com.nordea.hackathon2017.utils.DatabaseUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by tamara on 27/01/2017.
 */
@Path("/json/challengeEndPoint")
public class ChallengeEndPoint {

  @GET
  @Path("/post")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUserInJSON() throws SQLException {
    //send user to database check if ok return id error handling
    DatabaseUtil.makeConnection();
    DatabaseUtil.insertIntoUsers(user);
    User dbUser = DatabaseUtil.selectFromUsers(user);
    String result = dbUser == null ? "{}" : dbUser.toString() ;
    return Response.status(201).entity(result).build();

  }
}
