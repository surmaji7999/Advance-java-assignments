package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {
    Connection con;
    ResultSet rs;

    public UserDao(Connection con) {
        super();
        this.con = con;
    }

//    insert into database
    public boolean insertIntoDB(User user) {

        boolean f = false;
        
        String query = "INSERT INTO party(firstName, lastName, address, city, zip, state, country, phone) VALUES(?,?,?,?,?,?,?,?);";
        String query1 = "INSERT INTO userLogin(userLoginId, password, partyid) VALUES(?,?,?);";
        try {
            PreparedStatement pst = this.con.prepareStatement("SELECT userLoginId FROM userlogin WHERE userLoginId=?");
            pst.setString(1, user.getEmail());
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                f=false;
            }else {
            pst = this.con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getAddress());
            pst.setString(4, user.getCity());
            pst.setInt(5, user.getZip());
            pst.setString(6, user.getState());
            pst.setString(7, user.getCountry());
            pst.setString(8, user.getPhone());

            pst.executeUpdate();

            rs = pst.getGeneratedKeys();
            if (rs.next()) {

                String id = rs.getString(1);
                pst = con.prepareStatement(query1);
                pst.setString(1, user.getEmail());
                pst.setString(2, user.getPassword());
                pst.setString(3, id);

                pst.executeUpdate();
                f = true;
            }
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return f;
    }

//Select all data from database
    public List<User> selectData() {
        List<User> userDataList = new ArrayList<>();
        try {

            PreparedStatement pst = this.con.prepareStatement(
                    "Select party.partyid,party.firstname,party.lastname,party.address,party.city,party.zip,party.state,party.country,party.phone,userlogin.userloginid  from party inner join userlogin on party.partyid=userlogin.partyid order by party.partyid");

            ResultSet rs = pst.executeQuery();

            User user;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("partyid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setAddress(rs.getString("address"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setZip(rs.getInt("zip"));
                user.setCountry(rs.getString("country"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("userloginid"));
                userDataList.add(user);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return userDataList;
    }

//    search by id
    public User selectDataById(String id) {
        User user = new User();
        try {

            PreparedStatement pst = this.con.prepareStatement(
                    "Select party.partyid,party.firstname,party.lastname,party.address,party.city,party.zip,party.state,party.country,party.phone,userlogin.userloginid,userlogin.password from party inner join userlogin on party.partyid=userlogin.partyid where party.partyid=?");
            int id1 = Integer.parseInt(id);
            pst.setInt(1, id1);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("partyid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setAddress(rs.getString("address"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setZip(rs.getInt("zip"));
                user.setCountry(rs.getString("country"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("userloginid"));
                user.setPassword(rs.getString("password"));
                String name = rs.getString("firstname");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

//search by user name
    public User getByUsername(String username) {
        User user = new User();

        try {
            PreparedStatement preparedStatement = this.con
                    .prepareStatement("select userloginid,password from userlogin where userloginid=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String usName = resultSet.getString("userloginid");
                String pass = resultSet.getString("password");
                user.setEmail(usName);
                user.setPassword(pass);

            }

        } catch (SQLException sqlException) {

        }
        return user;
    }

//delete databases
    public boolean deleteData(String id,  String userName) {
        boolean f = false;
        String userId=""; 
        try {
//            for logged user check 
            PreparedStatement ps = con.prepareStatement("SELECT userloginid FROM userlogin WHERE partyId=?" );
            ps.setString(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
             userId = resultSet.getString("userloginid");  
            }
            System.out.println(userId);
            if(userId.equals(userName)) {
                System.out.println("equal");
                f=false;
            }else {
            
            String query = " delete from userlogin Where partyId=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();

            query = " delete from Party Where partyId=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();

            f = true;
            ps.close();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
       
        return f;
    }

//update databaase
    public boolean updateDb(User user) {
        boolean f = false;
        PreparedStatement pst;

        try {
            pst = this.con.prepareStatement(
                    "UPDATE party INNER JOIN userlogin ON party.partyid=userlogin.partyid SET firstName=?, lastName=?, address=?, city=?, zip=?, state=?, country=?, phone=?,userloginid=?,password=? WHERE party.partyid=?");

            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getAddress());
            pst.setString(4, user.getCity());
            pst.setInt(5, user.getZip());
            pst.setString(6, user.getState());
            pst.setString(7, user.getCountry());
            pst.setString(8, user.getPhone());
            pst.setString(9, user.getEmail());
            pst.setString(10, user.getPassword());
            pst.setInt(11, user.getId());

            pst.executeUpdate();
            f = true;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return f;

    }

    public List<User> search(String searchType, String searchName) {

        List<User> searchList = new ArrayList<User>();
        User user = new User();
        String query;
        System.out.println(searchType);
        System.out.println(searchName);
        if (searchType.equals("firstName")) {
System.out.println("true11");
            query = "Select party.partyid,party.firstname,party.lastname,party.address,party.city,party.zip,party.state,party.country,party.phone,userlogin.userloginid,userlogin.password from party inner join userlogin on party.partyid=userlogin.partyid where party.firstname LIKE ?";
        } else {

            query = "Select party.partyid,party.firstname,party.lastname,party.address,party.city,party.zip,party.state,party.country,party.phone,userlogin.userloginid,userlogin.password from party inner join userlogin on party.partyid=userlogin.partyid where party.lastname LIKE ?";
        }
        PreparedStatement pst;
        try {
            pst = this.con.prepareStatement(query);

            pst.setString(1, searchName);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("partyid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setAddress(rs.getString("address"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setZip(rs.getInt("zip"));
                user.setCountry(rs.getString("country"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("userloginid"));
                user.setPassword(rs.getString("password"));
                
                searchList.add(user);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return searchList;

    }
}
