/**
 * Created by Adam Manley Kelly - R00113196 on 30/11/2016.
 * https://github.com/adammanley-kelly/Assignment5-AOP-2016
 */
import java.rmi.*;
public interface MovieInterface extends Remote {
    void nextMovie(Notify n) throws RemoteException ;

    Movie getMovie() throws RemoteException;
}