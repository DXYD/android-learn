package com.example.myapplication.Bean;

/**
 * @author Administrator
 */
public class User {
    private Integer _id;
    private String sex;
    private String usernmae;
    private String password;

    public User(String usernmae, String sex, String password) {
        this.sex = sex;
        this.usernmae = usernmae;
        this.password = password;
    }


    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getAge() {
        return sex;
    }

    public void setAge(String age) {
        this.sex = age;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
