package Presentation;

import Business.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;
import java.util.concurrent.ThreadLocalRandom;

import static Presentation.GUI.introFrame;

/**
 * Created by dandeac on 20/05/2017.
 */
public class UserFrame {
public JFrame userFrame;
    String toAddress="";


    public JFrame getUserFrame() {
        return userFrame;
    }

    public void setUserFrame(JFrame userFrame) {
        this.userFrame = userFrame;
    }




    public String[] addOneIntToArray(String[] initialArray , String newValue) {

        String[] newArray = new String[initialArray.length + 1];
        for (int index = 0; index < initialArray.length; index++) {
            newArray[index] = initialArray[index];
        }

        newArray[newArray.length - 1] = newValue;
        return newArray;
    }

    public UserFrame(String username){
        userFrame = new JFrame("USER PAGE");
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.pack();
        userFrame.setVisible(true);
        userFrame.setPreferredSize(new Dimension(681, 790));
        userFrame.setLayout(null);

        JTextArea descriptionArea;
         JComboBox dropMenu;
         JLabel descriptionLabel;
         JLabel rankLabel;
         JLabel rankL;
         JLabel directorLabel;
         JLabel directorL;
         JLabel photoL;
         JButton viewScheduleB;
         JButton logout;
         JLabel menuLabel;
         JButton addReservationB;
         JButton deleteReservationB;
         JButton updateReservationB;
         JButton viewReservationsB;

        //construct preComponents
        String[] dropMenuItems={};


        try{
        ResultSet resultSet = UserBusiness.viewMovieNames();
            while (resultSet.next()) {
                dropMenuItems = addOneIntToArray(dropMenuItems,resultSet.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //construct components
        dropMenu = new JComboBox (dropMenuItems);
        descriptionLabel = new JLabel ("Description:");
        rankLabel = new JLabel ("Rank:");
        rankL = new JLabel ("");
        directorLabel = new JLabel ("Director:");
        directorL = new JLabel ("");
        photoL = new JLabel("");
        viewScheduleB = new JButton ("VIEW SCHEDULE");
        logout = new JButton ("LOGOUT");
        menuLabel = new JLabel ("MENU");
        addReservationB = new JButton ("MAKE RESERVATION");
        deleteReservationB = new JButton ("DELETE RESERVATION");
        updateReservationB = new JButton ("UPDATE RESERVATION");
        viewReservationsB = new JButton ("VIEW YOUR RESERVATIONS");
        descriptionArea = new JTextArea(2, 20);


        dropMenu.setBounds (25, 5, 425, 25);
        descriptionLabel.setBounds (30, 35, 100, 25);
        descriptionArea.setBounds (110, 40, 415, 125);
        rankLabel.setBounds (30, 100, 100, 25);
        rankL.setBounds (110, 100, 100, 25);
        directorLabel.setBounds (30, 130, 100, 25);
        directorL.setBounds (110, 130, 225, 25);
        photoL.setBounds (30, 150, 450, 580);
        viewScheduleB.setBounds (165, 740, 150, 25);
        logout.setBounds (530, 5, 100, 25);
        menuLabel.setBounds (570, 195, 100, 25);
        addReservationB.setBounds (485, 230, 195, 30);
        deleteReservationB.setBounds (485, 275, 195, 25);
        updateReservationB.setBounds (485, 320, 195, 25);
        viewReservationsB.setBounds (485, 365, 195, 25);

        //add components
        userFrame.add (dropMenu);
        userFrame.add (descriptionLabel);
        userFrame.add(descriptionArea);
        userFrame.add (rankLabel);
        userFrame.add (rankL);
        userFrame.add (directorLabel);
        userFrame.add (directorL);
        userFrame.add (photoL);
        userFrame.add (viewScheduleB);
        userFrame.add (logout);
        userFrame.add (menuLabel);
        userFrame.add (addReservationB);
        userFrame.add (deleteReservationB);
        userFrame.add (updateReservationB);
        userFrame.add (viewReservationsB);



        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setOpaque(false);
        descriptionArea.setEditable(false);
        descriptionArea.setFocusable(false);


        try {
            ResultSet userDetails = UserBusiness.viewUserDetails(username);
            while (userDetails.next()) {
                toAddress = userDetails.getString("email");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logout.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {


                userFrame.dispose();
                JFrame frame = introFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();

            }
        });


        dropMenu.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                String movieName = String.valueOf(dropMenu.getSelectedItem());
                try {
                     ResultSet resultSet = UserBusiness.viewMovieByName(movieName);

                    String description="";
                    String director="";
                    Float rank=null;
                    String imageLink="";
                    while (resultSet.next()) {
                         description = resultSet.getString("description");
                        director = resultSet.getString("director");
                         rank = resultSet.getFloat("rank");
                         imageLink = resultSet.getString("image");
                    }



                    descriptionArea.setText(description);
                    rankL.setText(Float.toString(rank));
                   directorL.setText(director);

                    URL url = new URL(imageLink);
                    BufferedImage image = ImageIO.read(url);
                    int w = image.getWidth();
                    int h = image.getHeight();
                    BufferedImage resizedImage = new BufferedImage((int)(w*0.6), (int)(h*0.6), image.getType());


                    Graphics2D g = resizedImage.createGraphics();
                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g.drawImage(image, 0, 0, (int)(w*0.6), (int)(h*0.6), 0, 0, w, h, null);
                    g.dispose();

                    ImageIcon icon = new ImageIcon(resizedImage);

                    photoL.setIcon(icon);

                } catch (Exception exp) {
                    exp.printStackTrace();
                }




            }
        });

        viewScheduleB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                String movieName = String.valueOf(dropMenu.getSelectedItem());
                try {

                    Table scheduleTable = new ScheduleTable();
                    JTable table = scheduleTable.displayTable(UserBusiness.scheduleForMovie(movieName));
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));



                } catch (Exception exp) {
                    exp.printStackTrace();
                }



            }
        });


        addReservationB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {


                JTextField scheduleId = new JTextField();
                JTextField seats = new JTextField();

                Object[] input = {
                        "Schedule ID:", scheduleId,
                        "Number of seats:",seats
                };
                JOptionPane.showConfirmDialog(null, input, "ADD RESERVATION", JOptionPane.OK_CANCEL_OPTION);


                try {
                    int leftCapacity=0;
                    ResultSet rs = UserBusiness.viewScheduleByID(Integer.parseInt(scheduleId.getText()));
                    while (rs.next()) {
                        leftCapacity = rs.getInt("leftCapacity");

                    }


                    String movieName="";
                    int hall=0;
                    String hours="";
                    ResultSet resultSet = UserBusiness.viewScheduleByID(Integer.parseInt(scheduleId.getText()));
                    while (resultSet.next()) {
                        movieName = resultSet.getString("movieName");
                        hall = resultSet.getInt("hallID");
                        hours = resultSet.getString("hours");
                    }

                    if(!UserBusiness.viewScheduleByID(Integer.parseInt(scheduleId.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO SCHEDULE WITH THE GIVEN ID IN THE DB");
                    else if(Integer.parseInt(seats.getText())>leftCapacity) JOptionPane.showMessageDialog(null,"THERE ARE NOT ENOUGH SEATS AVAILABLE");
                    else {
                        int id;


                        id = ThreadLocalRandom.current().nextInt(0, 100000);
                        UserBusiness.addReservation(id,username,Integer.parseInt(scheduleId.getText()),Integer.parseInt(seats.getText()));
                        UserBusiness.updateScheduleCapacity(Integer.parseInt(scheduleId.getText()),leftCapacity-Integer.parseInt(seats.getText()));

                        EmailBody email = new EmailBody();
                        email.setTo(toAddress);
                        email.setSubject("CINEMA APPLICATION");
                        email.setMessage("Reservation number: "+id +"\nMovie name: "+movieName+"\nHall number: "+hall+"\nHours: "+hours+"\nNumber of seats: "+Integer.parseInt(seats.getText())+"\n\n THANK YOU!");
                        Email.sendEmail(email);
                    }
                 }
                catch(Exception e1){
                    e1.printStackTrace();
                }



            }
        });

        deleteReservationB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {


                JTextField reservationID = new JTextField();


                Object[] input = {
                        "Reservation ID:", reservationID
                };
                JOptionPane.showConfirmDialog(null, input, "DELETE RESERVATION", JOptionPane.OK_CANCEL_OPTION);
                int oldSchedule=0;
                int oldSeats=0;
                String actualUser="";
                try {
                    ResultSet resultSet = UserBusiness.viewReservationByID(Integer.parseInt(reservationID.getText()));

                    while (resultSet.next()) {
                         actualUser = resultSet.getString("user");
                         oldSchedule = resultSet.getInt("schedule");
                         oldSeats = resultSet.getInt("seats");
                    }

                    int capacity=0;
                    ResultSet rs = UserBusiness.viewScheduleByID(oldSchedule);
                    while (rs.next()) {
                        capacity = rs.getInt("leftCapacity");

                    }
                    if(!UserBusiness.viewReservationByID(Integer.parseInt(reservationID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO RESERVATION WITH THE GIVEN ID IN THE DB");
                    else if(!actualUser.equalsIgnoreCase(username)) JOptionPane.showMessageDialog(null,"THE RESERVATION WITH THE GIVEN ID IS NOT YOURS");
                    else {
                        UserBusiness.removeReservationByID(Integer.parseInt(reservationID.getText()));
                        UserBusiness.updateScheduleCapacity(oldSchedule,oldSeats+capacity);

                        EmailBody email = new EmailBody();
                        email.setTo(toAddress);
                        email.setSubject("CINEMA APPLICATION");
                        email.setMessage("Reservation number: "+reservationID.getText() +" was canceled. \n\n THANK YOU!");
                        Email.sendEmail(email);
                    }
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }



            }
        });

        updateReservationB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {


                JTextField reservationID = new JTextField();
                JTextField newScheduleId = new JTextField();
                JTextField newSeats = new JTextField();

                Object[] input = {
                        "Reservation ID:",reservationID,
                        "New schedule ID:",newScheduleId,
                        "Number of seats:",newSeats
                };
                JOptionPane.showConfirmDialog(null, input, "UPDATE RESERVATION", JOptionPane.OK_CANCEL_OPTION);
                String actualUser="";
                int oldSchedule=0;
                int oldSeats=0;
                try {
                    int leftCapacity=0;
                    ResultSet rs = UserBusiness.viewScheduleByID(Integer.parseInt(newScheduleId.getText()));
                    while (rs.next()) {
                        leftCapacity = rs.getInt("leftCapacity");

                    }

                    ResultSet resultSet = UserBusiness.viewReservationByID(Integer.parseInt(reservationID.getText()));

                    while (resultSet.next()) {
                        actualUser = resultSet.getString("user");
                        oldSchedule = resultSet.getInt("schedule");
                        oldSeats = resultSet.getInt("seats");
                    }

                    int oldCapacity=0;
                    ResultSet res = UserBusiness.viewScheduleByID(oldSchedule);
                    while (res.next()) {
                        oldCapacity = res.getInt("leftCapacity");

                    }

                    if(!UserBusiness.viewReservationByID(Integer.parseInt(reservationID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO RESERVATION WITH THE GIVEN ID IN THE DB");
                    else if(!actualUser.equalsIgnoreCase(username)) JOptionPane.showMessageDialog(null,"THE RESERVATION WITH THE GIVEN ID IS NOT YOURS");
                    else  if(!UserBusiness.viewScheduleByID(Integer.parseInt(newScheduleId.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO SCHEDULE WITH THE GIVEN ID IN THE DB");
                    else if(Integer.parseInt(newSeats.getText())>leftCapacity) JOptionPane.showMessageDialog(null,"THERE ARE NOT ENOUGH SEATS AVAILABLE");
                    else {

                        UserBusiness.updateScheduleCapacity(oldSchedule,oldCapacity+oldSeats);
                        UserBusiness.updateReservation(Integer.parseInt(reservationID.getText()),Integer.parseInt(newScheduleId.getText()),Integer.parseInt(newSeats.getText()));
                        int leftCapacity2=0;
                        ResultSet rs2 = UserBusiness.viewScheduleByID(Integer.parseInt(newScheduleId.getText()));
                        while (rs2.next()) {
                            leftCapacity2 = rs2.getInt("leftCapacity");

                        }
                        UserBusiness.updateScheduleCapacity(Integer.parseInt(newScheduleId.getText()),leftCapacity2-Integer.parseInt(newSeats.getText()));


                        EmailBody email = new EmailBody();
                        email.setTo(toAddress);
                        email.setSubject("CINEMA APPLICATION");
                        email.setMessage("Reservation number: "+reservationID.getText() +" was updated. \n\n THANK YOU!");
                        Email.sendEmail(email);
                    }
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }



            }
        });

        viewReservationsB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                try {



                    Table reservationTable = new ReservationTable();
                    JTable table = reservationTable.displayTable(UserBusiness.viewReservationByUsername(username));
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));



                } catch (Exception exp) {
                    exp.printStackTrace();
                }



            }
        });
    }
}
