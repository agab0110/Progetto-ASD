package it.unimol.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Alessandro Gabriele
 */
public class SquadManager implements Serializable {
    private ArrayList<Player> players;

    public SquadManager() {
    }

    public void constructor() {
        players = new ArrayList<>();
    }

    /**
     * funzione per il caricamento dello squad menager
     * @return lo squad menager salvato
     * @throws IOException se non viene trovato squadmenager.sr
     */
    public static SquadManager loadSquadManager() throws IOException {
        try (
            FileInputStream fileInputStream = new FileInputStream("squadmanager.sr");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Object o = objectInputStream.readObject();
            return (SquadManager) o;
        } catch (FileNotFoundException e) {
            return null;
        } catch (ClassNotFoundException ignore) {
            return null;
        }
    }

    /**
     * funzione per il salvataggio dello squad menager in un file .sr
     * @throws IOException se ci sono problemi in fase di scrittura
     */
    public void saveSquadManager() throws IOException {
        try (
            FileOutputStream fileOutputStream = new FileOutputStream("squadmenager.sr");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(this);
        }
    }

    /**
     * funzione per cercare se c'è uno squad menager salvato
     * @return true se il file squadmenager.sr viene trovato, false altrimenti
     * @throws IOException e gestisce FileNotFoundException 
     */
    public static boolean searchSquadManager() throws IOException {
        try (
            FileInputStream fileInputStream = new FileInputStream("squadmenager.sr");
        ) {
            return true;      
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    /**
     * funzione per l'inserimento di un nuovo giocatore
     * @param p il giocatore da inserire
     * @throws PlayerException se il numero di maglia è duplicato
     */
    public void insertPlayer(Player p) throws PlayerException {
        for (Player player : players) {
            if (p.getNumber() == player.getNumber()) {
                throw new PlayerException("Numero già esistente");
            }
        }
        
        players.add(p);
    }

    /**
     * funzione per la rimozione di un giocatore dalla lista
     * @param number il numero di maglia del giocatore da eliminare
     */
    public void removePlayer(int number) {
        Player removedPlayer = new Player(null, null, number, null, 0, 0, 0, 0, 0);
        for (Player player : players) {
            if(player.getNumber() == number)
            removedPlayer = player;
        }
        players.remove(removedPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}
