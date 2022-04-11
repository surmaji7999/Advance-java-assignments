import java.util.List;

import Dao.ConnectionProvider;
import Dao.UserDao;
import entity.User;

public class Test {
  public static void demo() {
      
      UserDao userDao = new UserDao(ConnectionProvider.getConnection());
      List<User> userData1 =  userDao.selectData();
       
       
      for(User data:userData1) { 
          System.out.println( data.getAddress());
          
    
          
      }
  }
    
 
   
}
