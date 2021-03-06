package com.example.workpigai.result;

public class Result {
    //响应码
    private int code;

    private String account;
    private String password;
    private String name;


    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String account, String password) {
        this.code = code;
        this.account = account;
        this.password = password;
    }

    public Result(int code, String account, String password, String name) {
        this.code = code;
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
