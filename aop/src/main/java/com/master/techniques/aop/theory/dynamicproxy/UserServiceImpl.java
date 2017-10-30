package com.master.techniques.aop.theory.dynamicproxy;

public class UserServiceImpl implements UserService {

    @MethodNeededAnnotation(MethodNeededAnnotation.MethodType.BEFORE)
    @Override
    public void updateUser() {
        System.out.println("updating user");
    }

    @MethodNeededAnnotation(MethodNeededAnnotation.MethodType.AFTER)
    @Override
    public void deleteUser() {
        System.out.println("deleting user");
    }

}