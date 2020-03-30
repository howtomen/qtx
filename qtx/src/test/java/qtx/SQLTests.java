package qtx;

import java.io.InputStream;
import java.sql.*;
import org.testng.annotations.Test;

public class SQLTests {

	@Test
	public Connection connectionTest() {
		Connection con = null;
		try {

			// Establishing Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sakila", "root", "1234");

			if (con == null) {
				throw new RuntimeException((new Exception("Failed to make connection!")));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	@Test
	public void TestProblem2() throws SQLException {
		Connection con = connectionTest();
		String query = "SELECT film.title from film WHERE film.title LIKE '%airplane%'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String filmTitle = rs.getString("title");
			System.out.println(filmTitle);
		}
		st.close();
	}

	@Test
	public void TestProblem7() throws SQLException {
		Connection con = connectionTest();

		String query = "{call sakila.film_in_stock( ?, ?, ?)}";
		CallableStatement st = con.prepareCall(query);
		st.setInt(1, 15);
		st.setInt(2, 2);
		st.setInt(3, 0);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			String inventoryID = rs.getString("inventory_id");
			System.out.println(inventoryID);
		}
		st.close();
	}
	
	@Test
	public void TestProblem8() throws SQLException {

		Connection con = connectionTest();
		try {
			con = connectionTest();
			con.setAutoCommit(false);
			String query = "SELECT  max(address_id) FROM address";
			String query2 = "SELECT ST_GeomFromText('POINT(1 1)')";
			String query3 = "SELECT  max(staff_id) FROM staff";

			Statement st = con.createStatement();
			Statement st2 = con.createStatement();
			Statement st3 = con.createStatement();

			ResultSet rs = st.executeQuery(query);
			ResultSet rs2 = st2.executeQuery(query2);
			ResultSet rs3 = st3.executeQuery(query3);
			rs.next();
			int maxAddyID = rs.getInt(1);
			rs2.next();
			InputStream file = rs2.getBinaryStream(1);
			rs3.next();
			int maxStaffID = rs3.getInt(1);
			st.close();
			st2.close();
			st3.close();

			String sqlInsert = "INSERT INTO address (address, district, city_id, phone, location)"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sqlInsert);
			pstmt.setString(1, "110 Main");
			pstmt.setString(2, "Alberta");
			pstmt.setInt(3, 300);
			pstmt.setLong(4, 14033335568L);
			pstmt.setBinaryStream(5, file);

			pstmt.execute();

			String sqlInsert2 = "INSERT INTO sakila.staff(staff_id,first_name,last_name,address_id,email,store_id, active, username) "
					+ " VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt2 = con.prepareStatement(sqlInsert2);
			pstmt2.setString(1, "3");
			pstmt2.setString(2, "John");
			pstmt2.setString(3, "Rando");
			pstmt2.setString(4, "18");
			pstmt2.setString(5, "Rando@gmail.com");
			pstmt2.setString(6, "2");
			pstmt2.setString(7, "1");
			pstmt2.setString(8, "newJohn");
			pstmt2.execute();

			String sqlInsert3 = "INSERT INTO store (manager_staff_id, address_id)" + " VALUES(?,?);";
			PreparedStatement pstmt3 = con.prepareStatement(sqlInsert3);
			pstmt3.setInt(1, 3);
			pstmt3.setInt(2, maxAddyID);
			pstmt3.execute();

			String sqlUpdate = "UPDATE staff SET store_id = ? WHERE staff_id = ?;";
			PreparedStatement pstmt4 = con.prepareStatement(sqlUpdate);
			pstmt4.setString(1, "3");
			pstmt4.setInt(2, maxStaffID);
			pstmt4.execute();

			con.commit();
		} catch (SQLException e) {
			con.rollback();
			System.out.println(e);
		}
	}
	@Test
	public void TestProblem9() throws SQLException {
		Connection con = connectionTest();

		String sqlUpdate = "UPDATE store SET last_update = ? WHERE store_id = ?;";
		PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
		pstmt.setString(1, "2020-03-27 1:00:00");
		pstmt.setString(2, "3");
		pstmt.execute();
		
		
	
	}
	
	@Test
	public void TestProblem10() throws SQLException {
		Connection con = connectionTest();

		String sqlUpdate = "UPDATE staff SET store_id = ? WHERE store_id = ?;";
		PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
		pstmt.setString(1, "2");
		pstmt.setString(2, "3");
		pstmt.execute();
		
		String sqlDelete1 = "DELETE FROM store WHERE store_id = ?;";
		PreparedStatement pstmtDelete = con.prepareStatement(sqlDelete1);
		pstmtDelete.setString(1, "3");
		pstmtDelete.execute();
		
		String sqlDelete2 = "DELETE FROM staff WHERE staff_id = ?;";
		PreparedStatement pstmtDelete2 = con.prepareStatement(sqlDelete2);
		pstmtDelete2.setString(1, "3");
		pstmtDelete2.execute();
		
		
		
		
	
	}
	
}
