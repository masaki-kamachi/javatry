package org.docksidestage.javatry.basic.st6.dbms;

/**
 * @author masaki.kamachi
 */
public abstract class AbstractSt6Sql {

    public String buildPagingQuery(int pageSize, int pageNumber) {
        int offset = pageSize * (pageNumber - 1);
        return buildLimitOffsetQuery(offset, pageSize);
    }

    protected abstract String buildLimitOffsetQuery(int offset, int pageSize);
}
