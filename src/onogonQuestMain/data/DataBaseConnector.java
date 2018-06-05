package onogonQuestMain.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import characters.playerCharacters.Hero;

public class DataBaseConnector {
	/**
	 * @param args
	 */
	static final String LOAD = "SELECT * FROM PLAYER";
	static String SAVE = "UPDATE PLAYER SET ID = 1, CHARACTER_NO = 1, NAME = ?, HP = ?, MP = ?, MONEY= ? WHERE ID = 1";

	public static void main(String[] args) {
		try {
			// JDBCドライバーの指定
			Class.forName("org.sqlite.JDBC");

			// データベースに接続する なければ作成される
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:/pg/sqlite3/onogonQuest.db");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// Connection の例外が発生した時
			e.printStackTrace();
		}
	}

	public static Data load() {
		String sql = LOAD;
		Data data = new Data();

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager
					.getConnection("jdbc:sqlite:db/onogonQuest.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);

			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					switch (i) {
					case 1:
						data.setId(rs.getInt(i));
						break;
					case 2:
						data.setCharacterNo(rs.getInt(i));
						break;
					case 3:
						data.setName(rs.getString(i));
						break;
					case 4:
						data.setHp(rs.getInt(i));
						break;
					case 5:
						data.setMp(rs.getInt(i));
						break;
					case 6:
						data.setMoney(rs.getInt(i));
						break;
					default:
						break;
					}
				}
			}
			return data;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return null;

	}

	public static void save(Hero hero) {
		String sql = SAVE;

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager
					.getConnection("jdbc:sqlite:db/onogonQuest.db");
			ps = conn.prepareStatement(sql);
			ps.setQueryTimeout(30);
			ps.setString(1, hero.getName());
			ps.setInt(2, hero.getHp());
			ps.setInt(3, hero.getMp());
			ps.setInt(4, hero.getMoney());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
}