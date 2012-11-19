package mypack;
import java.sql.*;
public class DataBase {
    private String dbUrl ="jdbc:postgresql://localhost:5432/Test";//数据库
    private String dbUser="postgres";                              //用户名
    private String dbPwd="123456";                            //密码

    public DataBase() 
    {
        try {
            //加载数据库驱动程序
            Class.forName("org.postgresql.Driver" );
        } catch (ClassNotFoundException exception) {
        	exception.printStackTrace();
        }
    }
    //获取数据库连接
    public Connection getConnection()
    {
        Connection con = null;
        try {
          //建立数据库连接
          con = java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (SQLException exception) {
          exception.printStackTrace();
        }
        return con;
    }
    //关闭数据库连接
    public void closeConnection(Connection con){
        try{
            if(con!=null) con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

