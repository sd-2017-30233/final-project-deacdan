package Business;

import javax.swing.*;
import java.sql.ResultSet;

/**
 * Created by dandeac on 20/05/2017.
 */
public interface Table {

    public JTable displayTable(ResultSet resultSet);
}
