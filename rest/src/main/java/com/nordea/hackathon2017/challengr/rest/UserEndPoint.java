package com.nordea.hackathon2017.challengr.rest;







import com.nordea.hackathon2017.pojo.User;
import com.nordea.hackathon2017.utils.DatabaseUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by g50135 on 26/01/2017.
 */
@Path("/json/userEndPoint")
public class UserEndPoint {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserInJSON() {
        //get some user info
        User user = new User();
        user.setName("Per");
        user.setId(2);
        user.setEmail("per@email.com");
        return user;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUserInJSON(User user) throws SQLException {
        //send user to database check if ok return id error handling
        DatabaseUtil.makeConnection();
        DatabaseUtil.insertIntoUsers(user);
        User dbUser = DatabaseUtil.selectFromUsers(user);
        String result = dbUser == null ? "{}" : dbUser.toString() ;
        return Response.status(201).entity(result).build();

    }
}
