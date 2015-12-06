package src;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import model.Lion;
import model.Pond;
import model.Region;
import model.Ambulance;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

public class DataCollector {
	static String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	static String jdbcString = "jdbc:oracle:thin:@localhost:1521:XE";
	static String userName = "panthera";
	static String password = "cheng1223";

	public DataCollector() {

	}

	public void getRegions(List<Region> regions) {
		String query = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			stmt = conn.createStatement();
			query = "SELECT * FROM region";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				STRUCT dbObject = (STRUCT) rs.getObject(3);
				JGeometry geom = JGeometry.load(dbObject);
				double[] ordArray = geom.getOrdinatesArray();
				regions.add(new Region(rs.getInt("region_id"), rs.getInt("vertices"), ordArray));
			}

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

	public void getLions(List<Lion> lions) {
		String query = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			stmt = conn.createStatement();
			query = "SELECT * FROM lion";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				STRUCT dbObject = (STRUCT) rs.getObject(2);
				JGeometry geom = JGeometry.load(dbObject);
				double[] ordArray = geom.getPoint();
				lions.add(new Lion(rs.getInt("lion_id"), ordArray));
			}

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

	public void getPonds(List<Pond> ponds) {
		String query = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			stmt = conn.createStatement();
			query = "SELECT * FROM pond";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				STRUCT dbObject = (STRUCT) rs.getObject(2);
				JGeometry geom = JGeometry.load(dbObject);
				double[] ordArray = geom.getOrdinatesArray();
				ponds.add(new Pond(rs.getInt("pond_id"), ordArray));
			}

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

	public void getAmbulances(List<Ambulance> ambulances) {
		String query = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			stmt = conn.createStatement();
			query = "SELECT * FROM ambulance";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				STRUCT dbObject = (STRUCT) rs.getObject(2);
				JGeometry geom = JGeometry.load(dbObject);
				double[] ordArray = geom.getOrdinatesArray();
				ambulances.add(new Ambulance(rs.getInt("ambulance_id"), ordArray));
			}

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

	public List<Integer> getLionInsideRegion(int regionId) {
		String query = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		List<Integer> res = new LinkedList<Integer>();
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			stmt = conn.createStatement();
			query = "select lion_id from lion where SDO_INSIDE(lion.location,(select shape from region where region_id="
					+ regionId + ")) = 'TRUE'";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				res.add(rs.getInt("lion_id"));
			}

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
		return res;
	}

	public List<Integer> getPondInsideRegion(int regionId) {
		String query = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		List<Integer> res = new LinkedList<Integer>();
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcString, userName, password);
			stmt = conn.createStatement();
			query = "select pond_id from pond where SDO_INSIDE(pond.shape,(select shape from region where region_id="
					+ regionId + ")) = 'TRUE'";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				res.add(rs.getInt("pond_id"));
			}

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
		return res;
	}
}
