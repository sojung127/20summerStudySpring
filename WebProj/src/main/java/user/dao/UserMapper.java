package user.dao;

import user.vo.UserVO;

import java.util.List;

public interface UserMapper {
    UserVO selectUserById(String id);
    List<UserVO> selectUserList();
    void insertUser(UserVO userVO);
    void updateUser(UserVO userVO);
    void deleteUser(String id);
}
