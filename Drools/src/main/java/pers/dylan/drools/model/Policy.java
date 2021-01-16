package pers.dylan.drools.model;

public class Policy {

    private String sex;

    private Integer age;

    private Boolean userSingle;

    private Boolean userMarry;

    private Boolean userParenting;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getUserSingle() {
        return userSingle;
    }

    public void setUserSingle(Boolean userSingle) {
        this.userSingle = userSingle;
    }

    public Boolean getUserMarry() {
        return userMarry;
    }

    public void setUserMarry(Boolean userMarry) {
        this.userMarry = userMarry;
    }

    public Boolean getUserParenting() {
        return userParenting;
    }

    public void setUserParenting(Boolean userParenting) {
        this.userParenting = userParenting;
    }
}
