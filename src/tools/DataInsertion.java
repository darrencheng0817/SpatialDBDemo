package tools;

import java.sql.*;


public class DataInsertion {
	static String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	static String jdbcString = "jdbc:oracle:thin:@localhost:1521:XE";
	static String userName = "panthera";
	static String password = "cheng1223";

	public static void main(String[] args) {
		insertRegionData();
		insertLionData();
		insertPondData();
		insertAmbulanceData();
	}

	public static void insertRegionData() {
		String sql = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			int num = 0;
			stmt = conn.createStatement();
			sql = "insert into region values(4,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(400,0,500,0,500,100,400,100,400,0)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(5,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(400,100,500,100,500,250,400,200,400,100)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(6,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(300,150,400,100,400,200,250,250,300,150)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(7,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(100,100,300,150,250,250,150,250,100,100)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(12,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(400,200,500,250,500,350,400,350,400,200)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(1,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(0,0,150,0,100,100,0,100,0,0)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(2,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(150,0,250,0,300,150,100,100,150,0)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(3,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(250,0,400,0,400,100,300,150,250,0)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(11,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(250,250,400,200,400,350,300,350,250,250)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(8,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(0,100,100,100,150,250,0,250,0,100)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(9,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(0,250,150,250,150,400,0,350,0,250)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(10,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(150,250,250,250,300,350,150,400,150,250)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(15,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(150,400,300,350,300,500,150,500,150,400)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(14,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(300,350,400,350,400,500,300,500,300,350)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(16,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(0,350,150,400,150,500,0,500,0,350)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into region values(13,4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(400,350,500,350,500,500,400,500,400,350)))";
			num = stmt.executeUpdate(sql);

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void insertLionData() {
		String sql = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			int num = 0;
			stmt = conn.createStatement();
			sql = "insert into lion values(14,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(350,50,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(10,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(355,190,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(11,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(30,210,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(12,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(50,200,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(13,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(170,230,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(6,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(350,300,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(7,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(35,10,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(4,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(450,300,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(5,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(20,20,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(2,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(230,475,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(3,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(370,455,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(1,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(50,450,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(8,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(115,350,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);
			sql = "insert into lion values(9,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(240,335,0),NULL,NUlL))";
			num = stmt.executeUpdate(sql);

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void insertPondData() {
		String sql = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			int num = 0;
			stmt = conn.createStatement();
			sql = "insert into pond values(2,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(235,430,220,445,220,415)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into pond values(3,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(385,435,370,450,370,420)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into pond values(1,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(90,430,75,445,75,415)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into pond values(6,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(235,320,220,335,220,305)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into pond values(7,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(485,280,470,295,470,265)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into pond values(4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(90,330,75,345,75,315)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into pond values(5,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(335,280,320,295,320,265)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into pond values(8,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(390,175,375,190,375,160)))";
			num = stmt.executeUpdate(sql);
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void insertAmbulanceData() {
		String sql = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			int num = 0;
			stmt = conn.createStatement();
			sql = "insert into ambulance values(1,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(190,400,100,490,100,310)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into ambulance values(3,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(490,400,400,490,400,310)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into ambulance values(2,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(340,400,250,490,250,310)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into ambulance values(5,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(390,100,300,190,300,10)))";
			num = stmt.executeUpdate(sql);
			sql = "insert into ambulance values(4,SDO_GEOMETRY(2003,NULL,NUlL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(490,250,400,340,400,160)))";
			num = stmt.executeUpdate(sql);
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
