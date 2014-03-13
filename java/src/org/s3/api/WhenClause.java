package org.s3.api;

public interface WhenClause<T> {

    T when(String condition);
}
