package com.rz.customnavigationdrawer;

public class ModelNavDrawerData {
    private String navTitle;
    //pub{ENTER}ModelNav{ENTER}{(Str{ENTER} argNavTitle{END}} {{}{ENTER}
    //th{ENTER}.n{ENTER} = ar{ENTER};
    public ModelNavDrawerData(String argNavTitle) {
        this.navTitle = argNavTitle;
    }

    public String getNavTitle() {
        return this.navTitle;
    }

    public void setNavTitle(String argNavTitle) {
        this.navTitle = argNavTitle;
    }
}
