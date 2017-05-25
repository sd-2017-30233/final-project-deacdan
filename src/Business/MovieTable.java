package Business;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

/**
 * Created by dandeac on 20/05/2017.
 */
public class MovieTable implements Table {
    public  JTable displayTable(ResultSet result){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Director");
        model.addColumn("Rank");



        try {


            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                String director = result.getString("director");
                float rank = result.getFloat("rank");

                {
                    model.addRow(new Object[]{id,name,description,director,rank});
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
