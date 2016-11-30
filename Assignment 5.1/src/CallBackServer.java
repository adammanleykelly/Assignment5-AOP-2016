/**
 * Created by Adam Manley Kelly - R00113196 on 30/11/2016.
 * https://github.com/adammanley-kelly/Assignment5-AOP-2016
 */

import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;


public class CallBackServer extends UnicastRemoteObject implements MovieInterface {

    Movie movie;

    public CallBackServer() throws RemoteException {
    }

    public void nextMovie(Notify n) throws RemoteException {
        movie = new Movie(n);
        movie.start();
    }

    public Movie getMovie() throws RemoteException {
        return movie;
    }


    public static void main(String[] args) {
        try {

            CallBackServer server = new CallBackServer();
            Naming.rebind("MOVIE", server);
            System.out.println("Server Started");

        }
        catch (java.net.MalformedURLException e) {
            System.out.println("Malformed URL for MessageServer name " + e.toString());
        }
        catch (RemoteException e) {
            System.out.println("Communication error " + e.toString());
        }
    }

}

