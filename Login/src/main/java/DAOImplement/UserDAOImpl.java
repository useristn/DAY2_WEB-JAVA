package DAOImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.UserDAO;
import DBConnection.DBConnection;
import Model.User;

public class UserDAOImpl implements UserDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	//Viết hàm xử lý DAO tại đây
	@Override
	public User get(String username) {
		String sql = "SELECT * FROM [User] WHERE username = ? ";
		try {
		conn = new DBConnection().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("username"));
		user.setFullName(rs.getString("fullname"));
		user.setPassWord(rs.getString("password"));
		user.setAvatar(rs.getString("avatar"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreatedDate(rs.getDate("createdDate"));
		return user; }
		} catch (Exception e) {e.printStackTrace(); }
		return null;

	}
}
