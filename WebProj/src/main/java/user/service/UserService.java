package user.service;

import user.vo.UserVO;

import java.util.List;

public interface UserService {

    public void insertUser(UserVO user);
    public List<UserVO> getUserList();
    public void deleteUser(String id);
    public UserVO getUser(String id);
    public void updateUser(UserVO user);
}
