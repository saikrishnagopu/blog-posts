package com.blog.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceResponse {

    private String statusCode;

    private String statusMessage;

    private Object payload;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
