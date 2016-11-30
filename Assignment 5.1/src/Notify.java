/**
 * Created by Adam Manley Kelly - R00113196 on 30/11/2016.
 */
import java.rmi.*;

public interface Notify extends Remote {
    public void done() throws RemoteException;
}