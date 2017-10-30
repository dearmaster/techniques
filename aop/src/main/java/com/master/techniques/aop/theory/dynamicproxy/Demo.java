package com.master.techniques.aop.theory.dynamicproxy;

public class Demo {

    public static void main(String[] args) {
        GroupService groupService = (GroupService) new DynamicProxy().bind(new GroupServiceImpl(), new Log());
        groupService.loadGroup();

        System.out.println("------------");

        UserService userService = (UserService) new DynamicProxy().bind(new UserServiceImpl(), new Authentication());
        userService.deleteUser();
        System.out.println("------------");
        userService.updateUser();
    }

}