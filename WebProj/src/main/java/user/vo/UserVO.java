package user.vo;

public class UserVO {
    private String userId;
    private String name;
    private String gender;
    private String city;

    public UserVO() {}
    public UserVO(String userId, String name, String gender, String city) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.city = city;
    }

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

    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", gender="
                + gender + ", city=" + city + "]";
    }
}
