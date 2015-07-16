package divya.registrationform.controller;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import divya.registrationform.model.RegistrationDetails;


	
	public class RegistrationFormController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public RegistrationFormController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}*/

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			System.out.println("hii");
			
			StringBuffer sb = new StringBuffer();
				 
			    try 
			    {
			      BufferedReader reader = request.getReader();
			
			     String text=reader.readLine();
			     System.out.println("I entered"+text);
			     
			    	  sb.append(text);
			    	 
			    	  System.out.println("I am here"+sb.toString());
			    
			      
			    } catch (Exception e) { e.printStackTrace(); }
			  
			 
			    JSONParser parser = new JSONParser();
			    JSONObject joObj = null;
			    try
			    {
			      joObj = (JSONObject) parser.parse(sb.toString());
			      
			    }
			    catch (Exception e) 
			    { e.printStackTrace(); }
			   
			RegistrationDetails rd0=new RegistrationDetails();
			    
			rd0.setName((String)joObj.get("name"));
			rd0.setFname((String)joObj.get("fname"));
			rd0.setHouseno((String)joObj.get("houseno"));
			rd0.setStreetname((String)joObj.get("streetname"));
			rd0.setCity((String)joObj.get("city"));
		    
	
		    String objdata = new Gson().toJson(rd0);
		    response.setContentType("application/json");
            response.getWriter().write(objdata);
		  }
		}
		

