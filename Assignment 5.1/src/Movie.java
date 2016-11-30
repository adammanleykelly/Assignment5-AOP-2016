/**
 * Created by Adam Manley Kelly - R00113196 on 30/11/2016.
 * https://github.com/adammanley-kelly/Assignment5-AOP-2016
 */
import java.io.Serializable;
public class Movie  extends Thread implements Serializable
{
    String movies[]={"The Breakfast Club","Ferris Buellers day Off","Deadpool","Home Alone"};
    int [] year = {1985,1986,2016};
    int i = 3;
    Notify notify;

    public Movie(Notify n) {
        notify = n;
    }

    public void run()  {
        try {
            i++;
            if (i == 4) {
                i = 0;
            }
            Thread.sleep(3000);
            notify.done();
        }
        catch(Exception e){
            System.out.println("Server: Oh no!!!");
        }
    }
    public String getMovie() {
        return movies[i];
    }

    public int getYear() {return year[i];}
}
