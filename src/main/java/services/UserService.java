package services;

import Models.User;
import utils.MyDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements Crud<User> {
    Connection con;

    public UserService() {
        this.con = MyDb.getMydb().getCon();


    }

    @Override
    public void insert(User obj) throws SQLException {
        String sql = "insert into user (firstName,lastName,age) values('" + obj.getFirstName() + "','" + obj.getLastName() + "','" + obj.getAge() + "')";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public void update(User obj) throws SQLException {
        String sql = "update user set firstName = ?, lastName = ?, age = ? where id = ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, obj.getFirstName());
        stmt.setString(2, obj.getLastName());
        stmt.setInt(3, obj.getAge());
        stmt.setInt(4, obj.getId());
        stmt.executeUpdate();
    }

    @Override
    public void delete(User obj) throws SQLException {

    }

    @Override
    public List<User> find() throws SQLException {
        String sql = "select * from user";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setAge(rs.getInt("age"));
            user.setId(rs.getInt("id"));
            users.add(user);
        }

        return users;
    }
}
