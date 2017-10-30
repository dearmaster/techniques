package com.master.techniques.aop.theory.dynamicproxy;

public class GroupServiceImpl implements GroupService {

    @MethodNeededAnnotation(MethodNeededAnnotation.MethodType.AROUND)
    @Override
    public void loadGroup() {
        System.out.println("loading group");
    }

}