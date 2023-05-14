package edu.eci.arsw.services;

import edu.eci.arsw.model.Clue;
import edu.eci.arsw.model.Point;
import edu.eci.arsw.model.User;
import edu.eci.arsw.persistence.DrawLearningPersistenceException;
import edu.eci.arsw.persistence.impl.InMemoryDrawLearningPersistence;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.*;

public class DrawLearningServicesTest {
    InMemoryDrawLearningPersistence dp;
    User david, stefania, ivan, result;

    @Before
    public void before(){
        dp = new InMemoryDrawLearningPersistence();
    }

    @Test
    public void newMaster(){
        ArrayList<Point> testPoints  = new ArrayList();
        david = new User("testUserOrganizer", testPoints);
        dp.saveUser(david);
        assertEquals(david, dp.getOrganizerName());
    }

    @Test
    public void noSaveMaster(){
        ArrayList<Point> testPoints  = new ArrayList();
        david = new User("testUser", testPoints);
        dp.saveUser(david);
        assertEquals(null, dp.getOrganizerName());
    }

    @Test
    public void saveUser() throws DrawLearningPersistenceException {
        ArrayList<Point> testPoints  = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        testPoints.add(p1);
        testPoints.add(p2);
        testPoints.add(p3);
        david = new User("testUser", testPoints);
        dp.saveUser(david);
        result = dp.getUser("testUser");
        assertEquals(david, result);
    }

    @Test
    public void saveAllUser(){
        ArrayList<Point> testPoints  = new ArrayList();
        david = new User("testUser1", testPoints);
        stefania = new User("testUser2", testPoints);
        ivan = new User("testUser3", testPoints);
        dp.saveUser(david);
        dp.saveUser(stefania);
        dp.saveUser(ivan);
        Set<User> usuarios = dp.getAllUsers();
        assertEquals(usuarios.size(), 3);
    }

    @Test
    public void deleteUser(){
        ArrayList<Point> testPoints  = new ArrayList();
        david = new User("testUser1", testPoints);
        stefania = new User("testUser2", testPoints);
        ivan = new User("testUser3", testPoints);
        dp.saveUser(david);
        dp.saveUser(stefania);
        dp.saveUser(ivan);
        dp.deleteParticipantes();
        assertEquals(0, dp.getAllUsers().size());
    }

    @Test
    public void noSaveUserTwice() throws DrawLearningPersistenceException {
        ArrayList<Point> testPoints1  = new ArrayList();
        Point p1 = new Point(1, 2);
        ArrayList<Point> testPoints2  = new ArrayList();
        Point p2 = new Point(3, 4);
        testPoints1.add(p1);
        testPoints2.add(p2);
        david = new User("testUser", testPoints1);
        stefania = new User("testUser", testPoints2);
        dp.saveUser(david);
        dp.saveUser(stefania);
        result = dp.getUser("testUser");
        assertNotEquals(stefania, result);
    }

    @Test
    public void getPoints() throws DrawLearningPersistenceException {
        ArrayList<Point> testPoints  = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        testPoints.add(p1);
        testPoints.add(p2);
        testPoints.add(p3);
        david = new User("testUser", testPoints);
        dp.saveUser(david);
        result = dp.getUser("testUser");
        assertEquals(testPoints, result.getPoints());
    }

    @Test
    public void getUserPoints(){
        ArrayList<Point> testPoints1  = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        testPoints1.add(p1);
        testPoints1.add(p2);
        ArrayList<Point> testPoints2  = new ArrayList();
        Point p3 = new Point(5, 6);
        Point p4 = new Point(7, 8);
        testPoints2.add(p3);
        testPoints2.add(p4);
        david = new User("testUser1", testPoints1);
        stefania = new User("testUser2", testPoints2);
        dp.saveUser(david);
        dp.saveUser(stefania);
        assertEquals(testPoints2, dp.getPointsByUser("testUser2"));
    }

    @Test
    public void savePoint(){
        ArrayList<Point> testPoints  = new ArrayList();
        david = new User("testUser", testPoints);
        dp.saveUser(david);
        Point p1 = new Point(1, 2);
        testPoints.add(p1);
        david = new User("testUser", testPoints);
        dp.addPointToUser(david);
        assertEquals(testPoints, dp.getPointsByUser("testUser"));
    }

    @Test
    public void deleteAllPoints() throws DrawLearningPersistenceException {
        ArrayList<Point> testPoints  = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        testPoints.add(p1);
        testPoints.add(p2);
        testPoints.add(p3);
        david = new User("testUser", testPoints);
        dp.saveUser(david);
        dp.delteAllPointsUser("testUser");
        assertEquals(0, dp.getUser("testUser").getPoints().size());
    }

    @Test
    public void returnWinner(){
        ArrayList<Point> testPoints  = new ArrayList();
        david = new User("testUser", testPoints);
        dp.saveUser(david);
        dp.setWinner("testUser");
        assertEquals(david, dp.getWinner());
    }

    @Test
    public void newClue() throws DrawLearningPersistenceException {
        Clue pist = new Clue("good game", false);
        dp.saveClue(pist);
        assertEquals("good game", pist.getContenido());
    }

    @Test
    public void takeClue() throws DrawLearningPersistenceException {
        Clue pist = new Clue("good game", false);
        dp.saveClue(pist);
        assertEquals("good game", dp.TakeClue());
    }

    @Test
    public void onlyOneWinner(){
        ArrayList<Point> testPoints  = new ArrayList();
        david = new User("testUser1", testPoints);
        dp.saveUser(david);
        dp.setWinner("testUser1");
        stefania = new User("testUser2", testPoints);
        dp.saveUser(stefania);
        dp.setWinner("testUser2");
        assertNotEquals(stefania, dp.getWinner());
    }

    @Test
    public void changeClue() throws DrawLearningPersistenceException {
        Clue pist1 = new Clue("good game", false);
        dp.saveClue(pist1);
        Clue pist2 = new Clue("bad game", false);
        dp.saveClue(pist2);
        assertEquals("bad game", dp.TakeClue());
    }
}