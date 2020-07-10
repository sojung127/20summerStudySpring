package myspring.user.dao;

import myspring.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class UserDaoImplJDBC implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource);    }

    class UserMapper implements RowMapper<UserVO> {
        @Override
        public UserVO mapRow(ResultSet resultSet, int i) throws SQLException{
            UserVO user = new UserVO();
            user.setUserId(resultSet.getString("userId"));
            user.setName(resultSet.getString("name"));
            user.setGender(resultSet.getString("gender"));
            user.setCity(resultSet.getString("city"));
            return user;
        }
    }

    @Override
    public UserVO read(String id) {
        String SQL = "select * from users where userid = ?";
        try{
            UserVO user = jdbcTemplate.queryForObject(SQL,
                    new Object[] { id }, new UserMapper());
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void insert(UserVO user) {
        String SQL = "insert into users (userId, name, gender, city) values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL,user.getUserId(),user.getName(),user.getGender(),user.getCity());

        System.out.println("Inserted Record UserId = "+user.getUserId()+" Name = "+user.getName());
    }

    @Override
    public List<UserVO> readAll() {
        String SQL = "select * from users";
        List<UserVO> userList = jdbcTemplate.query(SQL, new UserMapper());
        return userList;
    }

    @Override
    public void delete(String id) {
        String SQL = "delete from users where userId= ?";
        jdbcTemplate.update(SQL,id);
        System.out.println("deleted Record with ID= "+id);
    }

    @Override
    public void update(UserVO user) {
        String SQL = "update users set name = ?, gender = ?, city =? where userId= ?";
        jdbcTemplate.update(SQL,user.getName(),user.getGender(),user.getCity(),user.getUserId());
        System.out.println("updated Record with Id = "+user.getUserId());
    }
}
