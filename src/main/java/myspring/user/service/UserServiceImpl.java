package myspring.user.service;

import myspring.user.dao.UserDao;
import myspring.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void insertUser(UserVO user) {
        userDao.insert(user);
    }

    @Override
    public List<UserVO> getUserList() {
        return userDao.readAll();
    }

    @Override
    public UserVO getUser(String id) {
        return userDao.read(id);
    }

    @Override
    public void deleteUser(String id) {
        userDao.delete(id);
    }

    @Override
    public void updateUser(UserVO user) {
        userDao.update(user);
    }
}
