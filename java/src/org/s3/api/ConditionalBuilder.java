package org.s3.api;

public interface ConditionalBuilder<T> {

    T when(String condition);
}
