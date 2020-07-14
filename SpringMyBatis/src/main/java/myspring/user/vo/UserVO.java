package myspring.user.vo;

public class UserVO {
    private String userId;
    private String name;
    private String gender;
    private String city;

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
