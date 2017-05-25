package Business;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

/**
 * Created by dandeac on 20/05/2017.
 */
public class HallTable implements Table {


    public JTable displayTable(ResultSet result){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Capacity");



        try {


            while (result.next()) {
                int id = result.getInt("id");
                int capacity = result.getInt("capacity");

                {
                    model.addRow(new Object[]{id,capacity});
                }
            }
            JTable table = new JTable(model);

            table.setPreferredScrollableViewportSize(new Dimension(200, 300));
             return table;
        }
        catch(Exception e) {

            e.printStackTrace();


        }
        return null;
    }
}
