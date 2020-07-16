package myspring.user.service;

import myspring.user.dao.UserDao;
import myspring.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userdao;

    @Override
    public void insertUser(UserVO user) {
        userdao.insert(user);
    }

    @Override
    public List<UserVO> getUserList() {
        return userdao.readAll();
    }

    @Override
    public void deleteUser(String id) {
        userdao.delete(id);
    }

    @Override
    public UserVO getUser(String id) {
        return userdao.read(id);
    }

    @Override
    public void updateUser(UserVO user) {
        userdao.update(user);
    }
}
