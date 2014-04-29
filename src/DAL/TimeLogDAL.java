/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Firemen;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author Lars Radoor
 */
public class TimeLogDAL extends AbstractDAL {
    
    public void timeRegister(Time loginTime, Time logoutTime, Firemen f) throws SQLException{
        
        Connection con = null;
        
        try{
            con = getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO brandmand_tidsregistering (brandmand, tid_login, tid_logud) "
                            + "VALUES ('" + f.getCpr() + "', " + loginTime + ", " + logoutTime + ")");
        } finally{
            if(con != null) con.close();
        }
    }
}
