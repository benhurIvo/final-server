/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1.endpoint;

/**
 *
 * @author benhur
 */
import final1.ws.PeopleImpl;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.io.IOException;


import javax.xml.ws.Endpoint;

public class PeoplePublisher {
	 public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException{
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        if (HOSTNAME.equals("127.0.0.1"))
        {
            HOSTNAME = "localhost";
        }
        String PORT = "6902";
        String BASE_URL = "/ws/people";

        if (String.valueOf(System.getenv("PORT")) != "null"){
            PORT=String.valueOf(System.getenv("PORT"));
        }
        String endpointUrl = PROTOCOL+HOSTNAME+":"+PORT+BASE_URL;
        System.out.println("Starting People Service...");
        System.out.println("--> Published. Check out "+endpointUrl+"?wsdl");
        Endpoint.publish(endpointUrl, new PeopleImpl());
	     
    }
}
//http://peaceful-scrubland-97910.herokuapp.com/ws/people?wsdl