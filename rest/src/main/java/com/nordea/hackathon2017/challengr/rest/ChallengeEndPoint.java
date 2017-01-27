package com.nordea.hackathon2017.challengr.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nordea.hackathon2017.pojo.Challenge;
import com.nordea.hackathon2017.pojo.User;
import com.nordea.hackathon2017.utils.DatabaseUtil;
import javafx.scene.chart.PieChart;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tamara on 27/01/2017.
 */
@Path("/json/challengeEndPoint")
public class ChallengeEndPoint {

  ObjectMapper mapper = new ObjectMapper();

  @GET
  @Path("/get")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUserInJSON() throws SQLException {
    //send user to database check if ok return id error handling
    DatabaseUtil.makeConnection();
    List<Challenge> challengeList = DatabaseUtil.selectAllChallenges();


    String result = null;
    try {
      result = challengeList.isEmpty() ? "{}" : mapper.writeValueAsString(challengeList);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      result = "{}";
    }
    return Response.status(201).entity(result).build();
  }
}
