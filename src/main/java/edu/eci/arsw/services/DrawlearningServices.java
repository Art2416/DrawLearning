package edu.eci.arsw.services;

import edu.eci.arsw.model.Clue;
import edu.eci.arsw.model.Point;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.DrawLearningPersistence;
import edu.eci.arsw.persistence.DrawLearningPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class DrawLearningServices {

    @Autowired
    DrawLearningPersistence dip = null;

    public void addNewUser(User user){
        dip.saveUser(user);
    }

    public Set<User> getAllUsers(){
        return dip.getAllUsers();
    }

    public User getUser(String name) throws DrawLearningPersistenceException {
        return dip.getUser(name);
    }

    public ArrayList<Point> getPointsByUser(String name){
        return dip.getPointsByUser(name);
    }

    public void addPointToUser(User user){
        dip.addPointToUser(user);
    }

    public void delteAllPointsUser(String name){
        dip.delteAllPointsUser(name);
    }

    public User getOrganizerName(){
        return dip.getOrganizerName();
    }

    public User getWinner(){
        return dip.getWinner();
    }

    public void setWinner(String name){
        dip.setWinner(name);
    }

    public void deleteParticipantes(){dip.deleteParticipantes();}

    public void addNewClue(Clue clue) throws DrawLearningPersistenceException {
        dip.saveClue(clue);
    }

    public String TakeClue(){
        return dip.TakeClue();
    }

}