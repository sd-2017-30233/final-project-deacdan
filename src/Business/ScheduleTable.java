package Business;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

/**
 * Created by dandeac on 20/05/2017.
 */
public class ScheduleTable implements Table {

    public JTable displayTable(ResultSet result){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Movie");
        model.addColumn("Hall");
        model.addColumn("Left capacity");
        model.addColumn("Hours");




        try {


            while (result.next()) {
                int id = result.getInt("id");
                String movieName = result.getString("movieName");
                int hall = result.getInt("hallID");
                int leftCapacity = result.getInt("leftCapacity");
                String hours = result.getString("hours");
                {
                    model.addRow(new Object[]{id,movieName,hall,leftCapacity,hours});
                }
            }
            JTable table = new JTable(model);

            table.setPreferredScrollableViewportSize(new Dimension(700, 300));
            return table;
        }
        catch(Exception e) {

            e.printStackTrace();


        }
        return null;
    }
}
