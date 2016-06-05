import java.sql.*;
import java.util.LinkedList;

public class Connector {
    public Connector(){
        res = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public LinkedList<String> getSeriesPhotos(){
        LinkedList<String> result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {}
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = cn.createStatement();
            String SQLRequest = "Select photo FROM series";
            ResultSet rs = statement.executeQuery(SQLRequest);
            result = new LinkedList<String>();
            while(rs.next()){
                result.add(rs.getString(1));
            }
        } catch (Exception ex) {} finally {
            try {
                if (cn != null) {
                    cn.close();
                    return result;
                }
            } catch (SQLException ex) {}
        }
        return result;
    }
    public boolean Done() {
        return res;
    }
    private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/paperoll";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    private boolean res;
}
