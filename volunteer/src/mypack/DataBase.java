package mypack;
import java.sql.*;
public class DataBase {
    private String dbUrl ="jdbc:postgresql://localhost:5432/Test";//���ݿ�
    private String dbUser="postgres";                              //�û���
    private String dbPwd="123456";                            //����

    public DataBase() 
    {
        try {
            //�������ݿ���������
            Class.forName("org.postgresql.Driver" );
        } catch (ClassNotFoundException exception) {
        	exception.printStackTrace();
        }
    }
    //��ȡ���ݿ�����
    public Connection getConnection()
    {
        Connection con = null;
        try {
          //�������ݿ�����
          con = java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (SQLException exception) {
          exception.printStackTrace();
        }
        return con;
    }
    //�ر����ݿ�����
    public void closeConnection(Connection con){
        try{
            if(con!=null) con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

