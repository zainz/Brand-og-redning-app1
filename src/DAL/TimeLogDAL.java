/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Firemen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Lars Radoor
 */
public class TimeLogDAL extends AbstractDAL {
    
    
    public void timeRegister(String date, Firemen f, int role, int type, boolean holiday, String loginTime, String logoutTime, int hours) throws SQLException{
        
        int ferieDag = (holiday) ? 1 : 0;
        
        Connection con = null;
        
        try{
            con = getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO midlertidig_løn (dato, brandmand, role, type_arbejde, ferie_dag, tid_logind, tid_logud, timer) "
                            + "VALUES ('" + date + "', '" + f.getCpr() + "', " + role + ", " + type + ", " + ferieDag + ", '" + loginTime + "', '" + logoutTime + "', " + hours + ")");
        } finally{
            if(con != null) con.close();
        }
    }
    
    public ArrayList<Firemen> getFiremen() throws SQLException{
        
        Connection con = null;
        ArrayList<Firemen> f = new ArrayList();
        
        try{
            con = getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM brandmand");
            while(rs.next()){
                String cprNo = rs.getString("cpr_no");
                String firstName = rs.getString("fornavn");
                String lastName = rs.getString("efternavn");
                String address = rs.getString("adresse");
                String phone = rs.getString("telefon");
                String callNo = rs.getString("udkaldsnummer");
                String paymentNo = rs.getString("løn_nummer");
                
                Firemen firemen = new Firemen(cprNo, firstName, lastName, address, phone, callNo, paymentNo);
                f.add(firemen);
            }
        } finally{
            if(con != null) con.close();
        }
        
        return f;
    }
}