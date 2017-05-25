package Business;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

/**
 * Created by dandeac on 20/05/2017.
 */
public class UserTable implements Table {
    public JTable displayTable(ResultSet result){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("E-mail");



        try {


            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                String email = result.getString("email");

                {
                    model.addRow(new Object[]{username,password,email});
                }
            }
            JTable table = new JTable(model);

            table.setPreferredScrollableViewportSize(new Dimension(400, 300));
            return table;
        }
        catch(Exception e) {

            e.printStackTrace();


        }
        return null;
    }
}
