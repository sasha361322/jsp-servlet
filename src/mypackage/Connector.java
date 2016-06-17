package mypackage;

import java.sql.*;
import java.util.LinkedList;

class Connector {
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
    public boolean Done() {
        return res;
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
                seria.setName_ru(rs.getString(3));
                seria.setPhoto(rs.getString(4));
                seria.setDescription(rs.getString(5));
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
    LinkedList<Type_work> getTypesOfWork(int id){
        LinkedList<Type_work> result = null;
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            String SQLRequest = "Select * FROM type_work WHERE series_id=?";
            PreparedStatement pst = cn.prepareStatement(SQLRequest);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            result = new LinkedList<Type_work>();
            while(rs.next()){
                Type_work type_work=new Type_work();
                type_work.setId(rs.getInt(1));
                type_work.setPhoto(rs.getString(2));
                type_work.setName(rs.getString(3));
                type_work.setSeries_id(rs.getInt(4));
                type_work.setDescription(rs.getString(5));
                result.add(type_work);
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
    LinkedList<Work> getWorks(int id, boolean is_finished){
        LinkedList<Work> result = null;
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            String SQLRequest = "Select * FROM work WHERE type_work_id=? AND count_lists is ";
            if (!is_finished)
                SQLRequest += "NOT ";
            SQLRequest += "NULL ";
            PreparedStatement pst = cn.prepareStatement(SQLRequest);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            result = new LinkedList<Work>();
            while(rs.next()){
                Work work =new Work();
                work.setId(rs.getInt(1));
                work.setArticle(rs.getString(2));
                work.setDescription(rs.getString(3));
                work.setType_work_id(rs.getInt(4));
                work.setPrice(rs.getInt(5));
                work.setSize_x(rs.getInt(6));
                work.setSize_y(rs.getInt(7));
                work.setOwn_photo(rs.getString(8));
                work.setCount_lists(rs.getString(9));
                result.add(work);
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

    private final String DB_URL = "jdbc:mysql://localhost:3306/paperoll";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    private boolean res;
}
