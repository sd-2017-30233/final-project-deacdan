package Business;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

/**
 * Created by dandeac on 20/05/2017.
 */
public class ReservationTable implements Table {

    public JTable displayTable(ResultSet result){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Reservation no");
        model.addColumn("Movie");
        model.addColumn("Hours");
        model.addColumn("Hall");
        model.addColumn("Seats");



        try {


            while (result.next()) {
                int id = result.getInt("id");
                int scheduleID = result.getInt("schedule");
                int seats = result.getInt("seats");
                String movieName="";
                int hall=0;
                String hours="";
                ResultSet resultSet = UserBusiness.viewScheduleByID(scheduleID);
                while (resultSet.next()) {
                    movieName = resultSet.getString("movieName");
                     hall = resultSet.getInt("hallID");
                     hours = resultSet.getString("hours");
                }
                {
                    model.addRow(new Object[]{id,movieName,hours,hall,seats});
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
