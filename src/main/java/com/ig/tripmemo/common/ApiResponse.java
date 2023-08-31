package com.ig.tripmemo.common;

public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> setSuccessOkResponse(T data) {
        return new ApiResponse<>(200, "OK", data);
    }

    public static <T> ApiResponse<T> setSuccessCreatedResponse(T data) {
        return new ApiResponse<>(201, "Created", data);
    }

    public static <T> ApiResponse<T> setNotFoundResponse() {
        return new ApiResponse<>(404, "Not Found", null);
    }

    public static <T> ApiResponse<T> setBadRequestResponse(String message) {
        return new ApiResponse<>(400, message, null);
    }

    // getters and setters
}