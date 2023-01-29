package it.unimol;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.unimol.app.Player;
import it.unimol.app.PlayerException;
import it.unimol.app.SquadManager;

public class TestSquadManager {
    @Test
    public void testContructor() {
        Player player = new Player("Nome", "Cognome", 2001, "Nat", 1, 5, 5, 5, 5);

        assertEquals("Nome", player.getName());
        assertEquals("Cognome", player.getSurname());
        assertEquals(2001, player.getDtn());
        assertEquals("Nat", player.getNationlity());
        assertEquals(1, player.getNumber());
        assertEquals(5, player.getAttack());
        assertEquals(5, player.getDefence());
        assertEquals(5, player.getSpeed());
        assertEquals(5, player.getStrenght());
    }

    @Test
    public void testInsertPlayer() {
        Player player = new Player("Nome", "Cognome", 2001, "Nat", 1, 5, 5, 5, 5);
        SquadManager squadMenager = new SquadManager();
        squadMenager.constructor();
        try {
            squadMenager.insertPlayer(player);
            assertEquals(1, squadMenager.getPlayers().size());
        } catch (PlayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testRemovePlayer() {
        SquadManager squadMenager = new SquadManager();
        Player player = new Player("Nome", "Cognome", 2001, "Nat", 1, 5, 5, 5, 5);
        
        squadMenager.constructor();
        try {
            squadMenager.insertPlayer(player);
        } catch (PlayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        squadMenager.removePlayer(1);
        assertEquals(0, squadMenager.getPlayers().size());
    }
}
