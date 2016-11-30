/**
 * Created by Adam Manley Kelly - R00113196 on 30/11/2016.
 *https://github.com/adammanley-kelly/Assignment5-AOP-2016
 *
 * The GUI does come up very small after attempting to implement this in JavaFX I went
 * back to Swing which im not fantastic at regarding layouts
 */

import java.awt.*;
import java.rmi.*;
import java.rmi.server.*;
import javax.swing.*;

public class CallBackClient extends javax.swing.JFrame {

    JLabel activityLabel;
    JTextField movieLabel,yearLabel;
    JButton getMovie;
    MovieInterface movie;
    MovieCheck movieNotify;

    public CallBackClient() {
        initComponents();
        LabelChanger lb = new LabelChanger(activityLabel);
        lb.start();
        try {
            Remote remoteObject = Naming.lookup("MOVIE");

            movie = (MovieInterface) remoteObject ;
            movieNotify = new MovieCheck(movieLabel, yearLabel, movie);
        }
        catch(Exception e){
            System.out.println("Oh no!!!1");
        };

    }

    private void initComponents() {
        activityLabel = new javax.swing.JLabel();
        getMovie = new javax.swing.JButton();
        movieLabel = new javax.swing.JTextField();
        yearLabel = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        activityLabel.setText(" ");
        getContentPane().add(activityLabel, java.awt.BorderLayout.NORTH);

        getMovie.setText("Get me a Movie");
        getMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMovieActionPerformed(evt);
            }
        });

        getContentPane().add(getMovie, java.awt.BorderLayout.CENTER);
        getContentPane().add(yearLabel, BorderLayout.EAST);
        getContentPane().add(movieLabel, java.awt.BorderLayout.WEST);

        pack();
    }

    private void getMovieActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            movie.nextMovie(movieNotify);
        }
        catch(Exception e){
            System.out.println("Oh no!!!2");
        };
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CallBackClient().setVisible(true);
            }
        });
    }

}

class LabelChanger extends Thread {

    JLabel label;

    public LabelChanger(JLabel lb){
        label = lb;
    }

    public void run() {
        while (true){
            try {
                label.setText("Hello There!");
                Thread.sleep(1000);
                label.setText(" ");
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println("Oh no!!!3");
            };
        }
    }
}
class MovieCheck extends UnicastRemoteObject implements Notify {

    JTextField textfield,textfieldY;
    MovieInterface remoteMovie;

    public MovieCheck(JTextField tf,JTextField tfy, MovieInterface f) throws RemoteException {
        textfield = tf;
        textfieldY = tfy;
        remoteMovie = f;
    }

    public void done() {
        try {
            textfield.setText(remoteMovie.getMovie().getMovie());
            textfieldY.setText(Integer.toString(remoteMovie.getMovie().getYear()));

        }
        catch(Exception e){
            System.out.println("Oh no!!!4");
            e.printStackTrace();
        };
    }
}


