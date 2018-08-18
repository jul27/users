import java.awt.*;
import javax.swing.*;

public class table extends  JFrame {
    JTable table;

    public table() {
        setLayout(new FlowLayout());

        String[] columnNames = {"id", "fio", "theme", "status", "date_end"};
        Object[][] data = {
                {"1", "Chuprina", "svoboda slova", "ok", "10.02.2018"},
                {"2", "Ivanoov", "love is//", "ne ok", "20.02.2019"},
        };
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public  static  void main (String args[]){
        table gui = new table();
        //gui.setDefaulCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(600,200);
        gui.setVisible(true);
        gui.setTitle(" My table");
    }
}
