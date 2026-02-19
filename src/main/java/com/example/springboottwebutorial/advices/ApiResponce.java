package com.example.springboottwebutorial.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponce<T>{
    private LocalDateTime timeStamp;

    private T data;

    private ApiError apiError;


    public ApiResponce() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponce(T data) {
        this();
        this.data = data;
    }

    public ApiResponce(ApiError apiError) {
        this();
        this.apiError = apiError;
    }
}
