package com.jeevankumar.spring_boot_validations.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResourceAlreadyExistException extends RuntimeException{
    private String resourceName;
    private String resourceId;

    public ResourceAlreadyExistException(String resourceName,Integer resourceId){
        this(resourceName,resourceId.toString());
    }

    public String getMessage(){
        if (resourceName == null || resourceId == null){
            return null;
        }
        return String.format("Resource '%s' already registered with id '%s'",resourceName,resourceId);
    }
}
