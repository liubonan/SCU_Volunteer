package mypack;
import java.sql.*;
import java.util.*;

import com.dao.VolunteerDB;
import com.model.Department;
import com.model.Volunteer;
public class Test 
{
    public Test()
    {
    }
    
    public static void main(String[] args)
    {
        DataBase database = null;
        Connection con = null;
        try
        {
            database = new DataBase();
            con = database.getConnection();
        } 
        catch (Exception ex)
        {
        }
        //Volunteer volunteer = VolunteerDB.getVolunteer(con, "0743041001");
        //if(volunteer == null)
        //	System.out.println("您所指定的学号不存在!");
        //else
        //{
        //	System.out.println(volunteer.getSno() + " " + volunteer.getSname() + " "
        //		                                 + volunteer.getSsex());
        //}
        //VolunteerDB.setActivity(con, "007", "帮助女生擦电风扇", "2009/04/02", "1", "");
        //VolunteerDB.setUpdatePermission(con, "0743041001", 8);
        //VolunteerDB.setUpdatePassword(con, "123456");
        Department d = VolunteerDB.getDepartment(con, "001");
        //System.out.println(d.getVolunteers().size());
        Volunteer v = (Volunteer)d.getVolunteers().get(1);
        System.out.println(v.getSname());
        v = (Volunteer)d.getVolunteers().get(0);
        System.out.println(v.getSname());
        System.out.println("成功!");
    }
}
