package clase6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import clase6.utilities.Utilities;

public class DataBase {
	String dbUrl;
	String username;
	String password;
	Faker faker;
	
	static String selectQuery = "select * from Personas;";
	static String selectMinorThan28Query = "select * from Personas where edad < 28;";
	static String insertQuery = "INSERT INTO Personas (nombre, apellido, edad, email, telefono) VALUES(?, ?, ?, ?, ?);";
	
	static Connection con;
	@BeforeTest
	public void setDatabaseConnection() throws ClassNotFoundException, SQLException {
		faker = new Faker();
		dbUrl = "jdbc:mysql://localhost:3306/mydb";
		username = "root";
		password = "tu clave";
	
		con = Utilities.getConnectionFromDataBase(dbUrl, username, password);
		
	}
	@Test 
	public void selectTest() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String lastname = rs.getString(3);
			String age = rs.getString(4);
			String email = rs.getString(5);
			String phone = rs.getString(6);
			
			System.out.println("id: " + id + " name: " + name + " lastname: " + lastname + " age: " + age + " email: " + email + " phone: " + phone);
			
		}
	}
	@Test
	public void selectUnder27Test() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectMinorThan28Query);
		
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String lastname = rs.getString(3);
			String age = rs.getString(4);

			String email = rs.getString(5);
			String phone = rs.getString(6);
			
			Assert.assertTrue(Integer.parseInt(age) < 28); 
			System.out.println("id: " + id + " name: " + name + " lastname: " + lastname + " age: " + age + " email: " + email + " phone: " + phone);
			
		}
		
	}
	@Test
	public void insertTest() throws SQLException {
		String name = faker.name().firstName();
		String lastname = faker.name().lastName();
	    String age = "44";
		String email = faker.internet().emailAddress();
		String phone = faker.phoneNumber().cellPhone();
		
		PreparedStatement pmtm = con.prepareStatement(insertQuery);
				
		pmtm.setString(1, name);
		pmtm.setString(2, lastname);
		pmtm.setString(3, age);
		pmtm.setString(4, email);
		pmtm.setString(5, phone);
		
		int affectedRows = pmtm.executeUpdate();
		Assert.assertTrue(affectedRows > 0);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Personas WHERE nombre = " + "'" + name + "'");
		
		while(rs.next()) {
			String id = rs.getString(1);
			String nameSelect = rs.getString(2);
			String lastnameSelect = rs.getString(3);
			String ageSelect = rs.getString(4);
			String emailSelect = rs.getString(5);
			String phoneSelect = rs.getString(6);
			
			Assert.assertEquals(nameSelect, name);
			Assert.assertEquals(lastnameSelect, lastname);
			Assert.assertEquals(ageSelect, age);
			Assert.assertEquals(emailSelect, email);
			Assert.assertEquals(phoneSelect, phone);
			
			System.out.println("id: " + id + " name: " + nameSelect + " lastname: " + lastnameSelect + 
				           " age: " + ageSelect + " email: " + emailSelect + " phone: " + phoneSelect);
						
		}
			
	}
	
}
