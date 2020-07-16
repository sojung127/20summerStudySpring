import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/java/config/beans.xml")
public class UserClient {
    @Autowired
    ApplicationContext context;
    @Autowired
    UserService service;

    @Test
    public void dataSourceTest(){
        DataSource ds = (DataSource)context.getBean("dataSource");
        try{
            System.out.println(ds.getConnection());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    public void getUserTest(){
        UserVO user = service.getUser("gildong");
        System.out.println("User Information: "+user);

//        UserVO user = service.getUser("gildong");
        System.out.println("User info: "+user);
        assertEquals("연아2",user.getName());
    }

    @Test
    public void insertUserTest(){
        service.insertUser(new UserVO("polar","연아","여","경기"));

        for (UserVO user : service.getUserList()){
            System.out.println(user);
        }
    }

    @Test
    public void updateUserTest(){
        service.updateUser(new UserVO("gildong","연아2","여2","경기2"));
        System.out.println(service.getUser("gildong"));
    }

    @Test
    public void deleteUserTest(){
        service.deleteUser("polar");

        for(UserVO user:service.getUserList()){
            System.out.println(user);
        }
    }
}
