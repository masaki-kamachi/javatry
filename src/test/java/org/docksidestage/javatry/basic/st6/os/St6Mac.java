package org.docksidestage.javatry.basic.st6.os;

public class St6Mac extends St6OperationSystem{

    public St6Mac(String loginId) {
        super(loginId);
    }

    protected String getFileSeparator() {
        return "/";
    }

    protected String getUserDirectory() {
        return "/Users/" + loginId;
    }
}
