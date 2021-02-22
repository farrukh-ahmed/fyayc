package com.fyayc.Interview.common;

public class Response<T> {

    private T data;
    private Meta meta;



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
    public Response(T data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }
}
