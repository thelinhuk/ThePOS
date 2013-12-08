
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



class DBQuery{

	private String usr;
	private String pwd;
	private String host;
	private Connection conn;



	public DBQuery(String username,String password){
		usr = username;
		pwd = password;
		conn = null;
		host = "jdbc:mysql://localhost:3306/pos";
		

	}

	public void setHost(String host){
		this.host = host;
	}

	public void connectDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
			conn = DriverManager.getConnection( host, usr, pwd );
		}catch(Exception e){
			System.out.println("Could not established connection");
			System.out.println(e.toString());
			return;
		}
	}



	public ResultSet select(String table,String row_query,String con){
		String query = "Select * from " + table + " where " + row_query + "='" + con + "'";
		String value = "";
		Statement statement;
		ResultSet rs = null;
		try{
			if(conn != null){

				statement = conn.createStatement();
				rs = statement.executeQuery(query);
			}
		}catch(Exception e){
			System.out.println(e.toString());
			
		}


		return rs;
	}
	
	public boolean isLogin(String pwd){
		String val ="";
		ResultSet rs = select("staff","pwd",pwd);
		boolean isLogged = false;
		try {
				while(rs.next()){
					val = rs.getString("pwd");
				}
				if(val.equals(pwd)){
					isLogged = true;
				}
				
				rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(isLogged);
	
		return isLogged;
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	

}