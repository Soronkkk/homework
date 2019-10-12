package com.simbirsoft.homework.data;

public class Response<T> {
    private String status;
    private T data;

    public Response(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public Response() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ServiceResponce{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
