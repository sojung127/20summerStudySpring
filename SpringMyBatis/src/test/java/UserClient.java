import myspring.user.vo.UserVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;

public class UserClient {
    @Autowired
    ApplicationContext context;
    @Autowired
    UserService service;

    @Test
    public void getUserTest(){
        UserVO user = service.getUser("gildong");
        System.out.println("User info: "+user);
        assertEquals("홍길동",user.getName());
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
        service.updateUser(new UserVO("polar","연아2","여2","경기2"));
        System.out.println(service.getUser("polar"));
    }

    @Test
    public void deleteUserTest(){
        service.deleteUser("polar");

        for(UserVO user:service.getUserList()){
            System.out.println(user);
        }
    }
}
