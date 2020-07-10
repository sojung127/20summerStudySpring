package myspring.user.vo;

public class UserVO {

    private String userId;
    private String name;
    private String gender;
    private String city;

    public UserVO() { }

    public UserVO(String userId,String name,String gender,String city){
        this.userId=userId;
        this.name=name;
        this.gender=gender;
        this.city=city;
    }

    public String getUserId() { return userId; }
    public String getName() { return  name; }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }
}
