package com.space.exceptions;
// Chained exceptions
public class MissionDataException extends Exception{
public MissionDataException(String message, Throwable cause){
    super(message,cause);

}
}
