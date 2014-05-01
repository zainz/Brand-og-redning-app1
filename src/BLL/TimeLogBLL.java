 /**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Firemen;
import DAL.TimeLogDAL;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Lars Radoor
 */
public class TimeLogBLL {
    
    TimeLogDAL tl = new TimeLogDAL();
    
    public void timeRegister(Firemen f, int type, int role, boolean holiday, String loginTime) throws SQLException{
        
        String logoutTime = new SimpleDateFormat("HH:mm:ss").format(new Timestamp(System.currentTimeMillis()));
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        String date = dateFormat.format(d);
        
        int hours = calculateTime(loginTime, logoutTime);
        
        tl.timeRegister(date, f, role, type, holiday, loginTime, logoutTime, hours);
    }
    
    public ArrayList<Firemen> getFiremen() throws SQLException{
       
        return tl.getFiremen();
    }
    
    private int calculateTime(String loginTime, String logoutTime){
    
        int hours = 2;
        
        try{
            String format = "HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);

            Date dateObj1 = sdf.parse(loginTime);
            Date dateObj2 = sdf.parse(logoutTime);
            
            long diff = dateObj2.getTime() - dateObj1.getTime();
            double diffInHours = diff / ((double) 1000 * 60 * 60);
            
            hours = (int)Math.ceil(diffInHours);
            
            if(hours < 2) hours = 2;
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return hours;
    }
}