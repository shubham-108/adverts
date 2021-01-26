package com.quinbay.adverts.dataModels;

import java.util.Map;

public class StandardResponse {
    private boolean success;
    private String error;
    private Map<String, Object> data;

    public StandardResponse(boolean success, String error, Map<String, Object> data) {
        this.success = success;
        this.error = error;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
