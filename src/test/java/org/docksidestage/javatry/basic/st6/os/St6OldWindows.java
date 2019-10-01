package org.docksidestage.javatry.basic.st6.os;

public class St6OldWindows extends St6OperationSystem {

    public St6OldWindows(String loginId) {
        super(loginId);
    }

    protected String getFileSeparator() {
        return "\\";
    }

    protected String getUserDirectory() {
        return "/Documents and Settigs/" + loginId;
    }

}
