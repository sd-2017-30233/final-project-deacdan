package Presentation;

import Business.AdminBusiness;
import Business.UserBusiness;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by dandeac on 13/05/2017.
 */
public class GUI extends JPanel {


    public static JFrame introFrame(){

        JLabel intro;
        JTextField username;
        JPasswordField password;
        JButton login;
        JButton register;
        JLabel error;

        JFrame introFrame = new JFrame("INTRO PAGE");
        introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introFrame.pack();
        introFrame.setVisible(true);


        intro = new JLabel("Introduceti username-ul si parola:");
        username = new JTextField(5);
        password = new JPasswordField(5);
        login = new JButton("LOGIN");
        error = new JLabel("");
        register = new JButton("REGISTER");


        //adjust size and set layout
        introFrame.setPreferredSize(new Dimension(250, 280));
        introFrame.setLayout(null);


        //set component bounds (only needed by Absolute Positioning)
        intro.setBounds(13, 50, 225, 25);
        username.setBounds(80, 95, 100, 25);
        password.setBounds(80, 140, 100, 25);
        login.setBounds(95, 165, 75, 30);
        register.setBounds(90, 195, 85, 30);
        error.setBounds(115,215,100,25);

        error.setForeground(Color.red);
        login.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                String passText = new String(password.getPassword());
                if(username.getText().equals("admin") && passText.equals("admin")){
                    introFrame.setVisible(false);

                    AdminFrame frame = new AdminFrame();
                    frame.getAdminFrame().setVisible(true);
                    frame.getAdminFrame().pack();
                    frame.getAdminFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                }

                else{
                   UserBusiness buss = new UserBusiness();

                    try {

                        if(buss.loginVerification(username.getText(),passText)){
                            introFrame.setVisible(false);
                            String user = username.getText();
                           UserFrame frame = new UserFrame(user);
                            frame.getUserFrame().setVisible(true);
                            frame.getUserFrame().pack();
                           frame.getUserFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }
                        else{
                            error.setText("ERROR");
                            username.setText("");
                            password.setText("");
                        }
                    } catch (Exception e1) {

                        e1.printStackTrace();

                    }


                }
            }
        });

        register.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JTextField username = new JTextField();
                JTextField password = new JPasswordField();
                JTextField email = new JTextField();
                Object[] input = {
                        "Username:", username,
                        "Password:", password,
                        "Email:",email
                };
                JOptionPane.showConfirmDialog(null, input, "Register", JOptionPane.OK_CANCEL_OPTION);

               try {
                   if(UserBusiness.isUser(username.getText())) {
                       JOptionPane.showMessageDialog(introFrame, "User existent!");
                       JOptionPane.showConfirmDialog(null, input, "Register", JOptionPane.OK_CANCEL_OPTION);
                   }
                   else UserBusiness.addUser(username.getText(),password.getText(),email.getText());
               }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        //add components
        introFrame.add(intro);
        introFrame.add(username);
        introFrame.add(password);
        introFrame.add(login);
        introFrame.add(error);
        introFrame.add(register);


        return introFrame;
    }


    public static void main (String[] args) {
        JFrame main = introFrame();
        main.setVisible(true);
        main.pack();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
}
