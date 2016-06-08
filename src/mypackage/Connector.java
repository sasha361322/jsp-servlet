package mypackage;

import java.sql.*;
import java.util.LinkedList;

class Connector {

    private final String DB_URL = "jdbc:mysql://localhost:3306/paperoll";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    private boolean res;

    Connector(){
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
    LinkedList<Seria> getData(){
        LinkedList result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {}
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = cn.createStatement();
            String SQLRequest = "Select * FROM series";
            ResultSet rs = statement.executeQuery(SQLRequest);
            result = new LinkedList<Seria>();
            while(rs.next()){
                Seria seria=new Seria();
                seria.setId(rs.getInt(1));
                seria.setName(rs.getString(2));
                seria.setPhoto(rs.getString(3));
                seria.setDescription(rs.getString(4));
                result.add(seria);
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
}
