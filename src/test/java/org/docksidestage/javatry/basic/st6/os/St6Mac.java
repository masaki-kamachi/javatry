package org.docksidestage.javatry.basic.st6.os;

// TODO chikama 細かいけど、新卒研修を想定しているので...St6OperationSystemの直後に空白 (しっかり体裁の統一感を) by jflute (2019/10/06)
// こういう考え方がベースのレビューです: https://twitter.com/jflute/status/1164429226822385664
// DONE Twitterのリンクありがとうございます！
/**
 * @author masaki.kamachi
 */
public class St6Mac extends St6OperationSystem {

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
