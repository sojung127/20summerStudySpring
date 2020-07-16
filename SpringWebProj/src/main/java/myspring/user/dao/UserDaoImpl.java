package myspring.user.dao;

import myspring.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    public UserVO read(String id) {
        UserVO user = userMapper.selectUserById(id);
        return user;
    }

    public List<UserVO> readAll() {
        List<UserVO> userList = userMapper.selectUserList();
        return userList;
    }

    public void insert(UserVO user) {
        userMapper.insertUser(user);
        System.out.println("등록된 Record UserId= "+user.getUserId()+
                " Name= "+user.getName());
    }

    public void update(UserVO user) {
        userMapper.updateUser(user);
    }

    public void delete(String id) {
        userMapper.deleteUser(id);
        System.out.println("삭제된 Record with ID= "+id);
    }
}
