package GenericUtilities_API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class DatabaseLibrary 
{
  Driver driverRef;
  Connection con;
  
  /**
   * this method is used to connect with mysql db
   * @author 
   * @throws SQLException
   */
  
  public void connectTODB() throws SQLException
  {
	  driverRef= new Driver();
	  DriverManager.registerDriver(driverRef);
	  con=DriverManager.getConnection(Iconstants.dbURL,Iconstants.dbUserName,Iconstants.dbPassword);
	  
  }
  
  public void closeDB() throws SQLException
  {
	con.close();  
  }
  
  /**
   * @author mujeeb
   * This method will execute the query and return the value only if the validation is successfull
   * @param query
   * @param ColumnIndex
   * @param expData
   * @return
   * @throws SQLException
   */
  
  public String readDataFromDBAndValidate(String query,int columnIndex,String expData) throws SQLException
  {
	 boolean flag=false;
	 ResultSet result = con.createStatement().executeQuery(query);
	 while (result.next())
	 {
		 if(result.getString(columnIndex).equalsIgnoreCase(expData))
		 {
			 flag=true;
			 break;
		 }
	 }
	 
	 if(flag)
	 {
		 System.out.println("verified");
		 return expData;
	 }
	 else
	 {
		 System.out.println("Data not Verified");
		 return "";
  }
	  
  }
  
  
  
}
