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
    User usuario1, usuario2, usuario3, resultado;

    @Before
    public void before(){
        dp = new InMemoryDrawLearningPersistence();
    }

    @Test
    public void deberiaGuardarUsuario() throws DrawLearningPersistenceException {
        ArrayList<Point> puntosPrueba  = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        puntosPrueba.add(p1);
        puntosPrueba.add(p2);
        puntosPrueba.add(p3);
        usuario1 = new User("UsuarioPrueba", puntosPrueba);
        dp.saveUser(usuario1);
        resultado = dp.getUser("UsuarioPrueba");
        assertEquals(usuario1, resultado);
    }

    @Test
    public void deberiaGuargarTodosUsuarios(){
        ArrayList<Point> puntosPrueba  = new ArrayList();
        usuario1 = new User("UsuarioPrueba1", puntosPrueba);
        usuario2 = new User("UsuarioPrueba2", puntosPrueba);
        usuario3 = new User("UsuarioPrueba3", puntosPrueba);
        dp.saveUser(usuario1);
        dp.saveUser(usuario2);
        dp.saveUser(usuario3);
        Set<User> usuarios = dp.getAllUsers();
        assertEquals(usuarios.size(), 3);
    }

    @Test
    public void deberiaObtenerPuntosCorrectamente() throws DrawLearningPersistenceException {
        ArrayList<Point> puntosPrueba  = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        puntosPrueba.add(p1);
        puntosPrueba.add(p2);
        puntosPrueba.add(p3);
        usuario1 = new User("UsuarioPrueba", puntosPrueba);
        dp.saveUser(usuario1);
        resultado = dp.getUser("UsuarioPrueba");
        assertEquals(puntosPrueba, resultado.getPoints());
    }

    @Test
    public void deberiaObtenerPuntosUsuarioCorrecto(){
        ArrayList<Point> puntosPrueba1  = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        puntosPrueba1.add(p1);
        puntosPrueba1.add(p2);
        ArrayList<Point> puntosPrueba2  = new ArrayList();
        Point p3 = new Point(5, 6);
        Point p4 = new Point(7, 8);
        puntosPrueba2.add(p3);
        puntosPrueba2.add(p4);
        usuario1 = new User("UsuarioPrueba1", puntosPrueba1);
        usuario2 = new User("UsuarioPrueba2", puntosPrueba2);
        dp.saveUser(usuario1);
        dp.saveUser(usuario2);
        assertEquals(puntosPrueba2, dp.getPointsByUser("UsuarioPrueba2"));
    }

    @Test
    public void deberiaAgregarPuntoCorrectamente(){
        ArrayList<Point> puntosPrueba  = new ArrayList();
        usuario1 = new User("UsuarioPrueba", puntosPrueba);
        dp.saveUser(usuario1);
        Point p1 = new Point(1, 2);
        puntosPrueba.add(p1);
        usuario1 = new User("UsuarioPrueba", puntosPrueba);
        dp.addPointToUser(usuario1);
        assertEquals(puntosPrueba, dp.getPointsByUser("UsuarioPrueba"));
    }

    @Test
    public void deberiaBorrarTodosPuntos() throws DrawLearningPersistenceException {
        ArrayList<Point> puntosPrueba  = new ArrayList();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        puntosPrueba.add(p1);
        puntosPrueba.add(p2);
        puntosPrueba.add(p3);
        usuario1 = new User("UsuarioPrueba", puntosPrueba);
        dp.saveUser(usuario1);
        dp.delteAllPointsUser("UsuarioPrueba");
        assertEquals(0, dp.getUser("UsuarioPrueba").getPoints().size());
    }

    @Test
    public void deberiaRetornarUsuarioGanador(){
        ArrayList<Point> puntosPrueba  = new ArrayList();
        usuario1 = new User("UsuarioPrueba", puntosPrueba);
        dp.saveUser(usuario1);
        dp.setWinner("UsuarioPrueba");
        assertEquals(usuario1, dp.getWinner());
    }

    @Test
    public void deberiaEliminarParticipante(){
        ArrayList<Point> puntosPrueba  = new ArrayList();
        usuario1 = new User("UsuarioPrueba1", puntosPrueba);
        usuario2 = new User("UsuarioPrueba2", puntosPrueba);
        usuario3 = new User("UsuarioPrueba3", puntosPrueba);
        dp.saveUser(usuario1);
        dp.saveUser(usuario2);
        dp.saveUser(usuario3);
        dp.deleteParticipantes();
        assertEquals(0, dp.getAllUsers().size());
    }

    @Test
    public void deberiaCrearPista() throws DrawLearningPersistenceException {
        Clue pist = new Clue("Buen juego", false);
        dp.saveClue(pist);
        assertEquals("Buen juego", pist.getContenido());
    }

    @Test
    public void deberiaTomarPista() throws DrawLearningPersistenceException {
        Clue pist = new Clue("Buen juego", false);
        dp.saveClue(pist);
        assertEquals("Buen juego", dp.TakeClue());
    }

    @Test
    public void noDeberiaSeleccionarOtroGanadorMismaPartida(){
        ArrayList<Point> puntosPrueba  = new ArrayList();
        usuario1 = new User("UsuarioPrueba1", puntosPrueba);
        dp.saveUser(usuario1);
        dp.setWinner("UsuarioPrueba1");
        usuario2 = new User("UsuarioPrueba2", puntosPrueba);
        dp.saveUser(usuario2);
        dp.setWinner("UsuarioPrueba2");
        assertNotEquals(usuario2, dp.getWinner());
    }

    @Test
    public void nodeberiaGuadarUsuarioDosVeces() throws DrawLearningPersistenceException {
        ArrayList<Point> puntosPrueba1  = new ArrayList();
        Point p1 = new Point(1, 2);
        ArrayList<Point> puntosPrueba2  = new ArrayList();
        Point p2 = new Point(3, 4);
        puntosPrueba1.add(p1);
        puntosPrueba2.add(p2);
        usuario1 = new User("UsuarioPrueba", puntosPrueba1);
        usuario2 = new User("UsuarioPrueba", puntosPrueba2);
        dp.saveUser(usuario1);
        dp.saveUser(usuario2);
        resultado = dp.getUser("UsuarioPrueba");
        assertNotEquals(usuario2, resultado);
    }

    @Test
    public void deberiaCambiarPista() throws DrawLearningPersistenceException {
        Clue pist1 = new Clue("Buen juego", false);
        dp.saveClue(pist1);
        Clue pist2 = new Clue("Mal juego", false);
        dp.saveClue(pist2);
        assertEquals("Mal juego", dp.TakeClue());
    }

    @Test
    public void deberiaAgregarMaster(){
        ArrayList<Point> puntosPrueba  = new ArrayList();
        usuario1 = new User("UsuarioPruebaOrganizer", puntosPrueba);
        dp.saveUser(usuario1);
        assertEquals(usuario1, dp.getOrganizerName());
    }

    @Test
    public void noDeberiaSerMaster(){
        ArrayList<Point> puntosPrueba  = new ArrayList();
        usuario1 = new User("UsuarioPrueba", puntosPrueba);
        dp.saveUser(usuario1);
        assertEquals(null, dp.getOrganizerName());
    }
}