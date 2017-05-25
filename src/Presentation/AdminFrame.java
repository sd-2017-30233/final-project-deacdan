package Presentation;
import Business.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static Presentation.GUI.introFrame;

/**
 * Created by dandeac on 20/05/2017.
 */
public class AdminFrame {
    JFrame adminFrame;

    public JFrame getAdminFrame() {
        return adminFrame;
    }

    public void setAdminFrame(JFrame adminFrame) {
        this.adminFrame = adminFrame;
    }

    public AdminFrame(){
        JButton addMovieB;
        JLabel jcomp2;
        JButton deleteMovieB;
        JButton updateMovieB;
        JButton viewMoviesB;
        JLabel jcomp6;
        JButton addHallB;
        JButton deleteHallB;
        JButton updateHallB;
        JButton viewHallsB;
        JLabel jcomp11;
        JButton viewReservationByUsernameB;
        JLabel jcomp13;
        JButton viewReservationByID;
        JButton viewAllReservationsB;
        JButton viewMovieByNameB;
        JLabel jcomp17;
        JButton addScheduleB;
        JButton deleteScheduleB;
        JButton updateScheduleB;
        JButton viewAllScheduleB;
        JLabel jcomp22;
        JButton viewScheduleByIDB;
        JButton viewScheduleByMovieNameB;
        JLabel jcomp25;
        JButton viewAllUsersB;
        JButton viewUserByNameB;
        JButton logout;

        addMovieB = new JButton ("ADD");
        jcomp2 = new JLabel ("MOVIES");
        deleteMovieB = new JButton ("DELETE");
        updateMovieB = new JButton ("UPDATE");
        viewMoviesB = new JButton ("VIEW ALL");
        jcomp6 = new JLabel ("HALLS");
        addHallB = new JButton ("ADD");
        deleteHallB = new JButton ("DELETE");
        updateHallB = new JButton ("UPDATE");
        viewHallsB = new JButton ("VIEW ALL");
        jcomp11 = new JLabel ("RESERVATIONS");
        viewReservationByUsernameB = new JButton ("USERNAME");
        jcomp13 = new JLabel ("VIEW BY:");
        viewReservationByID = new JButton ("ID");
        viewAllReservationsB = new JButton ("VIEW ALL");
        viewMovieByNameB = new JButton ("VIEW BY NAME");
        jcomp17 = new JLabel ("SCHEDULE");
        addScheduleB = new JButton ("ADD");
        deleteScheduleB = new JButton ("DELETE");
        updateScheduleB = new JButton ("UPDATE");
        viewAllScheduleB = new JButton ("VIEW ALL");
        jcomp22 = new JLabel ("VIEW BY:");
        viewScheduleByIDB = new JButton ("ID");
        viewScheduleByMovieNameB = new JButton ("MOVIE NAME");
        jcomp25 = new JLabel ("USERS");
        viewAllUsersB = new JButton ("VIEW ALL");
        viewUserByNameB = new JButton ("VIEW BY NAME");
        logout = new JButton ("LOGOUT");

        addMovieB.setBounds (25, 60, 130, 25);
        jcomp2.setBounds (65, 25, 60, 40);
        deleteMovieB.setBounds (25, 95, 130, 25);
        updateMovieB.setBounds (25, 130, 130, 25);
        viewMoviesB.setBounds (25, 165, 130, 25);
        jcomp6.setBounds (225, 25, 60, 40);
        addHallB.setBounds (180, 60, 130, 25);
        deleteHallB.setBounds (180, 95, 130, 25);
        updateHallB.setBounds (180, 130, 130, 25);
        viewHallsB.setBounds (180, 165, 130, 25);
        jcomp11.setBounds (360, 25, 100, 40);
        viewReservationByUsernameB.setBounds (340, 95, 130, 25);
        jcomp13.setBounds (375, 60, 100, 25);
        viewReservationByID.setBounds (340, 130, 130, 25);
        viewAllReservationsB.setBounds (340, 165, 130, 25);
        viewMovieByNameB.setBounds (25, 200, 130, 25);
        jcomp17.setBounds (520, 25, 100, 40);
        addScheduleB.setBounds (490, 60, 125, 25);
        deleteScheduleB.setBounds (490, 95, 125, 25);
        updateScheduleB.setBounds (490, 130, 125, 25);
        viewAllScheduleB.setBounds (490, 165, 125, 25);
        jcomp22.setBounds (525, 185, 100, 25);
        viewScheduleByIDB.setBounds (490, 205, 125, 25);
        viewScheduleByMovieNameB.setBounds (490, 230, 125, 25);
        jcomp25.setBounds (680, 25, 85, 40);
        viewAllUsersB.setBounds (635, 60, 130, 25);
        viewUserByNameB.setBounds (635, 95, 130, 25);
        logout.setBounds (680, 0, 100, 25);





        adminFrame = new JFrame("ADMINISTRATOR PAGE");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.pack();
        adminFrame.setVisible(true);
        adminFrame.setPreferredSize(new Dimension (777, 293));
        adminFrame.setLayout(null);

        adminFrame.add (addMovieB);
        adminFrame.add (jcomp2);
        adminFrame.add (deleteMovieB);
        adminFrame.add (updateMovieB);
        adminFrame.add (viewMoviesB);
        adminFrame.add (jcomp6);
        adminFrame.add (addHallB);
        adminFrame.add (deleteHallB);
        adminFrame.add (updateHallB);
        adminFrame.add (viewHallsB);
        adminFrame.add (jcomp11);
        adminFrame.add (viewReservationByUsernameB);
        adminFrame.add (jcomp13);
        adminFrame.add (viewReservationByID);
        adminFrame.add (viewAllReservationsB);
        adminFrame.add (viewMovieByNameB);
        adminFrame.add (jcomp17);
        adminFrame.add (addScheduleB);
        adminFrame.add (deleteScheduleB);
        adminFrame.add (updateScheduleB);
        adminFrame.add (viewAllScheduleB);
        adminFrame.add (jcomp22);
        adminFrame.add (viewScheduleByIDB);
        adminFrame.add (viewScheduleByMovieNameB);
        adminFrame.add (jcomp25);
        adminFrame.add (viewAllUsersB);
        adminFrame.add (viewUserByNameB);
        adminFrame.add (logout);


        logout.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {


                adminFrame.dispose();
                JFrame frame = introFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();

            }
        });

        addMovieB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField name = new JTextField();
                JTextField description = new JTextField();
                JTextField director = new JTextField();
                JTextField rank = new JTextField();
                JTextField image = new JTextField();

                Object[] input = {
                        "Movie name:", name,
                        "Description:", description,
                        "Director:",director,
                        "Rank:",rank,
                        "Image link:",image
                };
                JOptionPane.showConfirmDialog(null, input, "ADD MOVIE", JOptionPane.OK_CANCEL_OPTION);

                try {
                    if(Float.parseFloat(rank.getText())>10 || Float.parseFloat(rank.getText())<0) JOptionPane.showMessageDialog(null,"THERE RANK IS NOT VALID");
                    else if(AdminBusiness.viewMovieByName(name.getText()).first())JOptionPane.showMessageDialog(null,"THERE IS A MOVIE WITH THE GIVEN NAME IN THE DB");
                    else AdminBusiness.addMovie( name.getText(), description.getText(), director.getText(), Float.parseFloat(rank.getText()), image.getText());
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        deleteMovieB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                JTextField id = new JTextField();

                Object[] input = {
                        "ID:",id
                };
                JOptionPane.showConfirmDialog(null, input, "DELETE MOVIE", JOptionPane.OK_CANCEL_OPTION);

                try {
                    if(!AdminBusiness.viewMovieByID(Integer.parseInt(id.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO MOVIE WITH THE GIVEN ID");
                    else AdminBusiness.removeMovie(Integer.parseInt(id.getText()));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        updateMovieB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField oldID = new JTextField();
                JTextField name = new JTextField();
                JTextField description = new JTextField();
                JTextField director = new JTextField();
                JTextField rank = new JTextField();
                JTextField image = new JTextField();

                Object[] input = {
                        "Old ID:", oldID,
                        "Movie name:", name,
                        "Description:", description,
                        "Director:",director,
                        "Rank:",rank,
                        "Image link:",image
                };
                JOptionPane.showConfirmDialog(null, input, "UPDATE MOVIE", JOptionPane.OK_CANCEL_OPTION);

                try {
                    if(!AdminBusiness.viewMovieByID(Integer.parseInt(oldID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO MOVIE WITH THE GIVEN ID");
                    else if(Float.parseFloat(rank.getText())>10 || Float.parseFloat(rank.getText())<0) JOptionPane.showMessageDialog(null,"THERE RANK IS NOT VALID");
                    else if(AdminBusiness.viewMovieByName(name.getText()).first())JOptionPane.showMessageDialog(null,"THERE IS A MOVIE WITH THE GIVEN NAME IN THE DB");
                    else AdminBusiness.updateMovie(Integer.parseInt(oldID.getText()), name.getText(),description.getText(),director.getText(),
                            Float.parseFloat(rank.getText()),image.getText());
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewMoviesB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {


                try {
                    Table movieTable = new MovieTable();
                    JTable table = movieTable.displayTable(AdminBusiness.viewAllMovies());
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE ARE NO MOVIES THAT ARE MATCHING YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewMovieByNameB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField name = new JTextField();

                Object[] input = {

                        "Movie name:", name
                };
                JOptionPane.showConfirmDialog(null, input, "VIEW BY NAME", JOptionPane.OK_CANCEL_OPTION);

                try {
                    Table movieTable = new MovieTable();
                    JTable table = movieTable.displayTable(AdminBusiness.viewMovieByName(name.getText()));
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE ARE NO MOVIES THAT ARE MATCHING YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        addHallB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField id = new JTextField();
                JTextField capacity = new JTextField();

                Object[] input = {

                        "ID:", id,
                        "Capacity:", capacity
                };
                JOptionPane.showConfirmDialog(null, input, "ADD HALL", JOptionPane.OK_CANCEL_OPTION);

                try {
                    if(AdminBusiness.viewHallByID(Integer.parseInt(id.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS A HALL WITH THE GIVEN ID IN THE DB");
                    else if(Integer.parseInt(capacity.getText())<= 0) JOptionPane.showMessageDialog(null,"CAPACITY SHOULD BE GREATER THAN 0");
                    else AdminBusiness.addHall(Integer.parseInt(id.getText()),Integer.parseInt(capacity.getText()));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        deleteHallB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField id = new JTextField();


                Object[] input = {

                        "ID:", id
                };
                JOptionPane.showConfirmDialog(null, input, "DELETE HALL", JOptionPane.OK_CANCEL_OPTION);

                try {


                    if(!AdminBusiness.viewHallByID(Integer.parseInt(id.getText())).first())   JOptionPane.showMessageDialog(null,"THERE IS NO HALL WITH THIS ID");
                   else AdminBusiness.deleteHall(Integer.parseInt(id.getText()));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        updateHallB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField oldID = new JTextField();
                JTextField newID = new JTextField();
                JTextField newCapacity = new JTextField();

                Object[] input = {

                        "Old ID:", oldID,
                        "New ID:", newID,
                        "New capacity:", newCapacity
                };
                JOptionPane.showConfirmDialog(null, input, "UPDATE HALL", JOptionPane.OK_CANCEL_OPTION);

                try {
                    if(!AdminBusiness.viewHallByID(Integer.parseInt(oldID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO HALL WITH THE GIVEN OLD ID IN THE DB");
                    else if(AdminBusiness.viewHallByID(Integer.parseInt(newID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS A HALL WITH THE GIVEN NEW ID IN THE DB");
                    else if(Integer.parseInt(newCapacity.getText())<= 0) JOptionPane.showMessageDialog(null,"CAPACITY SHOULD BE GREATER THAN 0");
                    else AdminBusiness.updateHall(Integer.parseInt(oldID.getText()),Integer.parseInt(newID.getText()),Integer.parseInt(newCapacity.getText()));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewHallsB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {


                try {
                   Table hallTable = new HallTable();
                   JTable table =  hallTable.displayTable(AdminBusiness.viewHalls());

                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE ARE NO HALLS THAT ARE MATCHING YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewReservationByUsernameB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField username = new JTextField();

                Object[] input = {

                        "Username:", username
                };
                JOptionPane.showConfirmDialog(null, input, "VIEW BY USERNAME", JOptionPane.OK_CANCEL_OPTION);

                try {
                    Table reservationTable = new ReservationTable();
                    JTable table = reservationTable.displayTable(AdminBusiness.viewReservationByUsername(username.getText()));
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE ARE NO RESERVATIONS THAT ARE MATCHING YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewReservationByID.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField id = new JTextField();

                Object[] input = {

                        "ID:", id
                };
                JOptionPane.showConfirmDialog(null, input, "VIEW BY ID", JOptionPane.OK_CANCEL_OPTION);

                try {
                    Table reservationTable = new ReservationTable();
                    JTable table = reservationTable.displayTable(AdminBusiness.viewReservationByID(Integer.parseInt(id.getText())));
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE ARE NO RESERVATIONS THAT ARE MATCHING YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewAllReservationsB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                try {
                    Table reservationTable = new ReservationTable();
                    JTable table = reservationTable.displayTable(AdminBusiness.viewAllReservations());
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE ARE NO RESERVATIONS THAT ARE MATCHING YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        addScheduleB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField id = new JTextField();
                JTextField movieName = new JTextField();
                JTextField hallID = new JTextField();
                JTextField leftCapacity = new JTextField();
                JTextField hours = new JTextField();

                Object[] input = {
                        "ID:", id,
                        "Movie name:", movieName,
                        "Hall:",hallID,
                        "Capacity:",leftCapacity,
                        "Hours:",hours
                };
                JOptionPane.showConfirmDialog(null, input, "ADD SCHEDULE", JOptionPane.OK_CANCEL_OPTION);

                try {
                    int hallCapacity=0;
                    ResultSet rs = AdminBusiness.viewHallCapacity(Integer.parseInt(hallID.getText()));
                    while (rs.next()) {
                        hallCapacity = rs.getInt("capacity");

                    }

                    if(AdminBusiness.viewScheduleByID(Integer.parseInt(id.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS A SCHEDULE WITH THE GIVEN ID IN THE DB");
                    else if(!AdminBusiness.viewMovieByName(movieName.getText()).first()) JOptionPane.showMessageDialog(null,"THERE IS NO MOVIE WITH THIS NAME");
                    else if(!AdminBusiness.viewHallByID(Integer.parseInt(hallID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO HALL WITH THIS ID");
                    else if(Integer.parseInt(leftCapacity.getText())>hallCapacity) JOptionPane.showMessageDialog(null,"CAPACITY GREATER THAN THE HALL CAPACITY");
                    else AdminBusiness.addSchedule(Integer.parseInt(id.getText()),movieName.getText(),Integer.parseInt(hallID.getText()),Integer.parseInt(leftCapacity.getText()),hours.getText());
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        deleteScheduleB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField id = new JTextField();


                Object[] input = {
                        "ID:", id,

                };
                JOptionPane.showConfirmDialog(null, input, "DELETE SCHEDULE", JOptionPane.OK_CANCEL_OPTION);

                try {
                    if(!AdminBusiness.viewScheduleByID(Integer.parseInt(id.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO SCHEDULE WITH THE GIVEN ID IN THE DB");
                    else AdminBusiness.deleteSchedule(Integer.parseInt(id.getText()));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        updateScheduleB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField oldID = new JTextField();
                JTextField newID = new JTextField();
                JTextField movieName = new JTextField();
                JTextField hallID = new JTextField();
                JTextField leftCapacity = new JTextField();
                JTextField hours = new JTextField();

                Object[] input = {
                        "Old ID:", oldID,
                        "New ID:", newID,
                        "Movie name:", movieName,
                        "Hall:",hallID,
                        "Capacity:",leftCapacity,
                        "Hours:",hours
                };
                JOptionPane.showConfirmDialog(null, input, "UPDATE SCHEDULE", JOptionPane.OK_CANCEL_OPTION);

                try {
                    int hallCapacity=0;
                    ResultSet rs = AdminBusiness.viewHallCapacity(Integer.parseInt(hallID.getText()));
                    while (rs.next()) {
                        hallCapacity = rs.getInt("capacity");
                    }
                    if(!AdminBusiness.viewScheduleByID(Integer.parseInt(oldID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO SCHEDULE WITH THE GIVEN OLD ID IN THE DB");
                    else if(AdminBusiness.viewScheduleByID(Integer.parseInt(newID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS A SCHEDULE WITH THE GIVEN NEW ID IN THE DB");
                    else if(!AdminBusiness.viewMovieByName(movieName.getText()).first()) JOptionPane.showMessageDialog(null,"THERE IS NO MOVIE WITH THIS NAME");
                    else if(!AdminBusiness.viewHallByID(Integer.parseInt(hallID.getText())).first()) JOptionPane.showMessageDialog(null,"THERE IS NO HALL WITH THIS ID");
                    else if(Integer.parseInt(leftCapacity.getText())>hallCapacity) JOptionPane.showMessageDialog(null,"CAPACITY GREATER THAN THE HALL CAPACITY");
                    else AdminBusiness.updateSchedule(Integer.parseInt(oldID.getText()),Integer.parseInt(newID.getText()),movieName.getText(),Integer.parseInt(hallID.getText()),Integer.parseInt(leftCapacity.getText()),hours.getText());
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewAllScheduleB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                try {
                    Table scheduleTable = new ScheduleTable();
                    JTable table = scheduleTable.displayTable(AdminBusiness.viewAllSchedule());
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE IS NO SCHEDULE THAT MATCHES YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewScheduleByIDB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField id = new JTextField();

                Object[] input = {

                        "ID:", id
                };
                JOptionPane.showConfirmDialog(null, input, "VIEW BY ID", JOptionPane.OK_CANCEL_OPTION);

                try {
                    Table scheduleTable = new ScheduleTable();
                    JTable table = scheduleTable.displayTable(AdminBusiness.viewScheduleByID(Integer.parseInt(id.getText())));
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE IS NO SCHEDULE THAT MATCHES YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewScheduleByMovieNameB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField movieName = new JTextField();

                Object[] input = {

                        "Movie name:", movieName
                };
                JOptionPane.showConfirmDialog(null, input, "VIEW BY MOVIE NAME", JOptionPane.OK_CANCEL_OPTION);

                try {
                    Table scheduleTable = new ScheduleTable();
                    JTable table = scheduleTable.displayTable(AdminBusiness.viewScheduleByMovie(movieName.getText()));
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE IS NO SCHEDULE THAT MATCHES YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        viewUserByNameB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField username = new JTextField();

                Object[] input = {

                        "Username:", username
                };
                JOptionPane.showConfirmDialog(null, input, "VIEW BY USERNAME", JOptionPane.OK_CANCEL_OPTION);

                try {
                    Table userTable = new UserTable();
                    JTable table = userTable.displayTable(AdminBusiness.viewUserByUsername(username.getText()));
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE IS NO USER THAT MATCHES YOUR SEARCH");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        viewAllUsersB.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                try {
                    Table scheduleTable = new UserTable();
                    JTable table = scheduleTable.displayTable(AdminBusiness.viewAllUsers());
                    if(table.getRowCount()==0)   JOptionPane.showMessageDialog(null,"THERE ARE NO USERS IN THE DB");
                    else JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
    }
}
