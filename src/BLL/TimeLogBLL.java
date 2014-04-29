/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Firemen;
import DAL.TimeLogDAL;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Lars Radoor
 */
public class TimeLogBLL {
    
    TimeLogDAL tl = new TimeLogDAL();
    
    Time loginTime1, loginTime2, loginTime3, loginTime4, loginTime5, loginTime6, loginTime7, loginTime8, loginTime9, loginTime10;
    Time logoutTime1, logoutTime2, logoutTime3, logoutTime4, logoutTime5, logoutTime6, logoutTime7, logoutTime8, logoutTime9, logoutTime10;
    
    public void loginRegister(Firemen f){
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String sTime = String.valueOf(timestamp);
        //firemen.loginTime = Time.valueOf(sTime);        
        loginTime1 = Time.valueOf(sTime);
    }
    
    public void logoutRegister(Firemen f) throws SQLException{
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String sTime = String.valueOf(timestamp);
        //firemen.loginTime = Time.valueOf(sTime);        
        logoutTime1 = Time.valueOf(sTime);
        
        tl.timeRegister(loginTime1, logoutTime1, f);
    }
    
    public void resetTime(Firemen f){
        
        loginTime1 = null;
        logoutTime1 = null;
    }
}
