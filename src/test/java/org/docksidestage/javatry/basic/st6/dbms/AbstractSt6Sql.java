package org.docksidestage.javatry.basic.st6.dbms;

/**
 * @author masaki.kamachi
 */
public abstract class AbstractSt6Sql {

    public String buildPagingQuery(int pageSize, int pageNumber) {
        int offset = pageSize * (pageNumber - 1);
        return doBuildLimitOffsetQuery(offset, pageSize);
    }

    // TODO chikama [tips]メソッド名のテクニックとして、publicとは似た名前にしないというのがあります by jflute (2019/10/06)
    // クラス内でメソッド補完したときに、publicのbuild...とprotectedのbuild...が混じって見づらかったり間違えて呼んでしまったり...
    // 別の動詞が使えるのであれば簡単だけど、意味が同じでbuildというワードをどちらでも使いたいというような場合は...
    // doBuildLimitOffsetQuery() とか internalBuildLimitOffsetQuery() とか、ちょっと形を変えてあげることがある。
    // (自分はprotectedの方に前者をよく使ってるね。publicの入り口メソッドに対してprotectedの「実際の処理」ってニュアンス)
    //
    // メソッド名デザインなので正解はないけど、こういう視点でメソッド名を調整したりするってことは学びになるんじゃないかと。
    // オープンソースのコードを読むときも解釈しやすくなるかもね。
    //
    // DONE 今までこの点意識したことなかったかつ、おっしゃる通りのミスをよくしそうになっていたので勉強になります..!ありがとうございます。
    protected abstract String doBuildLimitOffsetQuery(int offset, int pageSize);
}
