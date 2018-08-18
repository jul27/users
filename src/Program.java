import java.util.Scanner;
import java.sql.*;

public class Program
{
    public static void main (String args[])

    {
        Program program = new Program();
        if (program.open()){
           // program.insert();
            program.select();
            program.close();
        }

    }

    Connection co;

    boolean open ()
    {
        try
        {

            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection ("jdbc:sqlite:c:\\sqlite\\users.db");
            System.out.println("Connected");
            return true;
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    boolean insert()
    {
        try {
            Scanner scanner = new Scanner (System.in);
            System.out.print("Enter fio");
            String fio = scanner.nextLine();
            System.out.print("Enter theme");
            String theme = scanner.nextLine();
            System.out.print("Enter status");
            String status = scanner.nextLine();
            System.out.print("Enter date_end");
            String date_end = scanner.nextLine();

            String query = "INSERT INTO users (fio, theme, status, date_end) " +
            "VALUES ('" + fio + "', '" + theme + "', '" + status + "', '" + date_end + "')";

            Statement statement = co.createStatement ();
            statement.executeUpdate (query);

            System.out.println ("Rows added");
            statement.close();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    void select(){
        try
        {
            Statement statement = co.createStatement();
            String query = "SELECT id, fio, theme, status, date_end " +
                           " FROM users ORDER BY fio";
            ResultSet rs = statement.executeQuery (query);
            while (rs.next()){
                int id = rs.getInt("id");
                String fio = rs.getString("fio");
                String theme = rs.getString("theme");
                String status = rs.getString("status");
                String date_end = rs.getString("date_end");
                System.out.println(id + "\t| " + fio + "\t| " + theme +
                "\t| " + status + "\t| " + date_end);
            }
            rs.close();
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
          //  return false;
        }
    }

    boolean close()
    {
        try
        {
            co.close();
            return true;
        }
        catch (Exception e) {
           System.out.println(e.getMessage());
           return false;
        }
    }

}