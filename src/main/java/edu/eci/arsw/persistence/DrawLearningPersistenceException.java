package edu.eci.arsw.persistence;

public class DrawLearningPersistenceException extends Exception{

    public static final String NO_USER = "No se ha encontrado el usuario dentro de la partida";

    public DrawLearningPersistenceException(String message){
        super(message);
    }

    public DrawLearningPersistenceException(String message, Throwable cause){
        super(message,cause);
    }
}
