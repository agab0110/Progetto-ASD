package it.unimol.ui;

import java.io.IOException;
import java.util.Scanner;

import it.unimol.app.Player;
import it.unimol.app.SquadManager;

public class MainTerminal {
    private SquadManager squadManager;

    public MainTerminal() {
        squadManager = new SquadManager();
        squadManager.constructor();

        try {
            if(SquadManager.searchSquadManager() == true) {
                squadManager = SquadManager.loadSquadManager();
            }
        } catch (IOException e) {
            System.out.println("Errore caricamento menager: " + e.getMessage());
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int scelta = -1;
        
        while (scelta != 0) {
            System.out.println("1. Inserire giocatore");
            System.out.println("2. Rimuovi giocarore");
            System.out.println("3. Visualizza squadra e punteggi");
            System.out.println("0. Esci");
            System.out.println("Insrire la scelta");
            
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    insertPlayer();
                    break;
                case 2:
                    removePlayer();
                    break;
                case 3:
                    saveSquadManager();
                    showSquad();
                    break;
                case 0:
                    System.out.println("Uscita programma...");
                    break;
                default:
                    System.out.println("Scelta errata");
                    break;
            }
        }
    }

    private void insertPlayer() {
        String name;
        String surname;
        int dtn;
        String nationlity;
        int number;
        int attack;
        int defence;
        int speed;
        int strenght;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire il nome: ");
        name = scanner.nextLine();
        System.out.println("Inserire il cognome: ");
        surname = scanner.nextLine();
        System.out.println("Inserire la nazionalità: ");
        nationlity = scanner.nextLine();
        System.out.println("Inserire l'anno di nascita: ");
        dtn = scanner.nextInt();
        System.out.println("Inserire il numero di maglia: ");
        number = scanner.nextInt();
        System.out.println("Inserire l'attacco (1-10): ");
        attack = scanner.nextInt();
        System.out.println("Inserire la difesa (1-10): ");
        defence = scanner.nextInt();
        System.out.println("Inserire la velocitò (1-10): ");
        speed = scanner.nextInt();
        System.out.println("Inserire la forza (1-10): ");
        strenght = scanner.nextInt();

        Player player = new Player(name, surname, dtn, nationlity, number, attack, defence, speed, strenght);

        try {
            this.squadManager.insertPlayer(player);
            System.out.println("Giocatore inserito con successo");
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
    
    private void removePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire il numero di maglia del giocatore: ");
        int number = scanner.nextInt();

        squadManager.removePlayer(number);
    }

    private void showSquad() {
        for (Player player : squadManager.getPlayers()) {
            System.out.println("> " + player.getNumber() + ". " + player.getName() + " " + player.getSurname() + "(" + player.getPoints() + ")");
        }
    }

    private void saveSquadManager(){
        try {
            squadManager.saveSquadManager();
        } catch (IOException e) {
            System.out.println("Errore salvataggio: " + e.getMessage());
        }
    }
}
