package com.football.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.football.util.ServerConstants;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("seasons")
public class MyResource {

	private BufferedReader bufferedReader = null;
    private StringBuilder stringBuilder = new StringBuilder();

    @GET
    @Produces("application/json")
    @Path("leagues")
    public Response getLeagues() {
        try {
            String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), line = null;

            URL url = new URL(ServerConstants.URI + ServerConstants.SEASON + year);
            System.out.println(url.toString());
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestProperty("Authorization", "X-Auth-Token=" + ServerConstants.TOKEN);
            httpUrlConnection.setRequestMethod("GET");
           
            bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
           
            //stringBuilder.append("{ \"leagues\" :");
           
            while ((line = bufferedReader.readLine()) != null)
                stringBuilder.append(line);
           
            //stringBuilder.append("}");
           
            System.out.println(stringBuilder);
            return Response.ok(stringBuilder.toString(), MediaType.APPLICATION_JSON).build();
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("{id}/teams")
    public Response getTeams(@PathParam("id") String id) {
        try {
            String line = null;

            URL url = new URL(ServerConstants.URI + id + ServerConstants.TEAMS);
            System.out.println(url.toString());
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestProperty("Authorization", "X-Auth-Token=" + ServerConstants.TOKEN);
            httpUrlConnection.setRequestMethod("GET");
           
            bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
           
            //stringBuilder.append("{ \"leagues\" :");
           
            while ((line = bufferedReader.readLine()) != null)
                stringBuilder.append(line);
           
            //stringBuilder.append("}");
           
            System.out.println(stringBuilder);
            return Response.ok(stringBuilder.toString(), MediaType.APPLICATION_JSON).build();
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("{id}/leagueTable")
    public Response getLeagueTable(@PathParam("id") String id) {
        try {
            String line = null;

            URL url = new URL(ServerConstants.URI + id + ServerConstants.LEAGUETABLE);
            System.out.println(url.toString());
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestProperty("Authorization", "X-Auth-Token=" + ServerConstants.TOKEN);
            httpUrlConnection.setRequestMethod("GET");
           
            bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
           
            //stringBuilder.append("{ \"leagues\" :");
           
            while ((line = bufferedReader.readLine()) != null)
                stringBuilder.append(line);
           
            //stringBuilder.append("}");
           
            System.out.println(stringBuilder);
            return Response.ok(stringBuilder.toString(), MediaType.APPLICATION_JSON).build();
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
