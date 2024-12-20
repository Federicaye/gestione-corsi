package view;

import model.Docente;
import model.Discente;
import model.Corso;
import service.DocenteService;
import service.DiscenteService;
import service.CorsoService;
import service.CorsoDiscenteService;
import java.time.LocalDate;
import java.util.*;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choiceEntity;
        System.out.println("1. Per gestire i docenti");
        System.out.println("2. Per gestire i discenti");
        System.out.println("3. Per gestire i corsi");
        System.out.println("4. Per gestire gli iscritti ai corsi ");
        choiceEntity = scanner.nextInt();

        switch (choiceEntity){
            case 1:
                gestisciDocenti();
                break;
            case 2:
                gestisciDiscenti();
                break;
            case 3:
                gestisciCorso();
                break;
            case 4:
                gestisciCorsoDiscente();
                break;

        }

    }
    private static void gestisciDiscenti(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe discente");

            System.out.println("***Menu***");
            System.out.println("1. Crea un nuovo discente");
            System.out.println("2. Aggiorna un discente");
            System.out.println("3. Visualizza la lista di discenti");
            System.out.println("4. Elimina un discente");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");
            //System.out.print("test commit push");
            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createDiscente();
                    break;
                case 2:
                    updateDiscente();
                    break;
                case 3:
                    readDiscenti();
                    break;
                case 4:
                    deleteDiscente();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciDocenti(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe docente");

            System.out.println("***Menu***");
            System.out.println("1. Crea un nuovo docente");
            System.out.println("2. Aggiorna un docente");
            System.out.println("3. Visualizza la lista di docenti");
            System.out.println("4. Elimina un docente");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    read();
                    break;
                case 4:
                    delete();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciCorso(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe corso");

            System.out.println("***Menu***");
            System.out.println("1. Crea un nuovo corso");
            System.out.println("2. Aggiorna un corso");
            System.out.println("3. Visualizza la lista dei corsi");
            System.out.println("4. Elimina un corso");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createCorso();
                    break;
                case 2:

                    updateCorso();

                    break;
                case 3:
                    readCorsi();
                    break;
                case 4:
                    deleteCorso();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciCorsoDiscente(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe CorsoDiscente");

            System.out.println("***Menu***");
            System.out.println("1. Iscrivi uno studente a un corso");
            System.out.println("2. Disiscrivi uno studente da un corso");
            System.out.println("3. Visualizza la lista degli studenti di un corso");
            System.out.println("4. Visualizza la lista dei corsi di uno studente");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createCorsoDiscente();
                    break;
                case 2:
                    deleteCorsoDiscente();

                    break;
                case 3:
                     readDiscentiDiUnCorsoScegliCorso();
                    break;
                case 4:
                    readCorsiSeguitiScegliStudente();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();
    }

    private static void read() {
        System.out.println("ecco la lista dei docenti: ");
        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti= oDocenteService.readDocente();
        int i = 0;
        while(i<listaDocenti.size()){
            System.out.println(listaDocenti.get(i).getid()+" "+listaDocenti.get(i).getCognome()+" "+listaDocenti.get(i).getNome());
            i++;}

    }

    private static void readDiscenti() {
        System.out.println("ecco la lista dei discenti: ");
        DiscenteService oDiscenteService = new DiscenteService();
        List<Discente> listaDiscenti= oDiscenteService.readDiscente();
        int i = 0;
        while(i<listaDiscenti.size()){
            System.out.println(listaDiscenti.get(i).getid()+" "+ listaDiscenti.get(i).getCognome()+" "+listaDiscenti.get(i).getNome());
            i++;}

    }

    private static void readCorsi() {
        System.out.println("ecco la lista dei corsi: ");
        CorsoService oCorsoService = new CorsoService();
        List<Corso> listaCorsi= oCorsoService.readCorso();
        int i = 0;
        while(i<listaCorsi.size()){
            System.out.println(listaCorsi.get(i).getId()+" "+listaCorsi.get(i).getNomeCorso()+" "+ listaCorsi.get(i).getDataInizio()+" "+listaCorsi.get(i).getDurata()+" "+listaCorsi.get(i).getDocenteNome()+" "+listaCorsi.get(i).getDocenteCognome());
            i++;}

    }

    private static void readCorsiSeguiti(int id){
        DiscenteService oDiscenteService = new DiscenteService();
       HashMap<Integer, Corso> corsiSeguiti = oDiscenteService.readCorsiSeguiti(id);
        for (Corso c : corsiSeguiti.values()) {
            System.out.println(c.getId()+ " "+ c.getNomeCorso());
        }
    }

    private static void readCorsiSeguitiScegliStudente(){

        readDiscenti();
        System.out.println("Scegli studente");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        readCorsiSeguiti(id);
    }

    private static void readDiscentiDiUnCorsoScegliCorso(){

        readCorsi();
        System.out.println("Scegli un corso");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        readDiscentiDiUnCorso(id);
    }

    private static void readDiscentiDiUnCorso(int id){
        CorsoService oCorsoService = new CorsoService();
        HashMap<Integer, Discente> discentiDiUnCorso = oCorsoService.readDiscentiDiUnCorso(id);
        for (Discente d : discentiDiUnCorso.values()) {
            System.out.println(d.getid()+ " "+ d.getNome()+ " "+ d.getCognome());
        }
    }

    private static void create () {
            System.out.println("inserisci nome: ");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.next();
            System.out.println("inserisci cognome: ");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.create(nome, cognome);

        }

    private static void createDiscente () {
        System.out.println("inserisci nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.next();
        System.out.println("inserisci cognome: ");
        String cognome = scanner.next();
        System.out.println("Inserisci la matricola: ");
        String matricola = scanner.next();
        System.out.println("Inserisci il giorno di nascita: ");
        int giorno = scanner.nextInt();
        System.out.println("Inserisci il mese di nascita: ");
        int mese = scanner.nextInt();
        System.out.println("Inserisci l'anno di nascita: ");
        int anno = scanner.nextInt();
        LocalDate dataDiNascita = LocalDate.of(anno, mese, giorno);
        DiscenteService oDiscenteService = new DiscenteService();
        oDiscenteService.create(nome, cognome, matricola, dataDiNascita);

    }

    private static void createCorso () {
        System.out.println("inserisci nome corso: ");
        Scanner scanner = new Scanner(System.in);
        String nomeCorso = scanner.next();
        System.out.println("Inserisci il giorno di inizio: ");
        int giorno = scanner.nextInt();
        System.out.println("Inserisci il mese di inizio: ");
        int mese = scanner.nextInt();
        System.out.println("Inserisci l'anno di inizio: ");
        int anno = scanner.nextInt();
        read();
        System.out.println("Inserisci l'id del docente: ");
        int docenteId = scanner.nextInt();
        System.out.println("Inserisci durata: ");
        String durata = scanner.next();
        LocalDate dataInizio = LocalDate.of(anno, mese, giorno);
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.create(nomeCorso, durata, dataInizio, docenteId);

    }

    private static void createCorsoDiscente(){
        readDiscenti();
        System.out.println("inserisci id studente: ");
        Scanner scanner = new Scanner(System.in);
        int idStudente = scanner.nextInt();
        readCorsi();
        System.out.println("inserisci id corso: ");
        int idCorso = scanner.nextInt();
        CorsoDiscenteService oCorsoDiscenteService = new CorsoDiscenteService();
        oCorsoDiscenteService.create(idStudente, idCorso);
    }

    private static void delete () {
            read();
            System.out.println("Elimina il docente con id: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.delete(id);

        }

    private static void deleteDiscente () {
        readDiscenti();
        System.out.println("Elimina il discente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DiscenteService oDiscenteService = new DiscenteService();
        oDiscenteService.delete(id);

    }

    private static void deleteCorso () {
        readCorsi();
        System.out.println("Elimina il corso con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.delete(id);

    }

    private static void deleteCorsoDiscente(){
        readDiscenti();
        System.out.println("inserisci id studente che vuoi disiscrivere: ");
        Scanner scanner = new Scanner(System.in);
        int idStudente = scanner.nextInt();
        readCorsiSeguiti(idStudente);
        System.out.println("inserisci id corso: ");
        int idCorso = scanner.nextInt();
        CorsoDiscenteService oCorsoDiscenteService = new CorsoDiscenteService();
        oCorsoDiscenteService.delete(idStudente, idCorso);
    }

    private static void update () {
            read();
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserisci l'id del docente da modificare:");
            int id = scanner.nextInt();
            System.out.println("inserisci il nuovo nome:");
            String nome = scanner.next();
            System.out.println("inserisci il nuovo cognome:");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.update(id, nome, cognome);

        }

    private static void updateDiscente () {
        readDiscenti();
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id del discente da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci il nuovo nome:");
        String nome = scanner.next();
        System.out.println("inserisci il nuovo cognome:");
        String cognome = scanner.next();
        System.out.println("Inserisci la matricola: ");
        String matricola = scanner.next();
        System.out.println("Inserisci il nuovo giorno di nascita: ");
        int giorno = scanner.nextInt();
        System.out.println("Inserisci il nuovo mese di nascita: ");
        int mese = scanner.nextInt();
        System.out.println("Inserisci il nuovo anno di nascita: ");
        int anno = scanner.nextInt();
        LocalDate dataDiNascita = LocalDate.of(anno, mese, giorno);
        DiscenteService oDiscenteService = new DiscenteService();
        oDiscenteService.update(id, nome, cognome, matricola, dataDiNascita);

    }

    private static void updateCorso () {
        Scanner scanner = new Scanner(System.in);
        readCorsi();
        System.out.println("inserisci l'id del corso da modificare:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("inserisci il nuovo nome del corso:");
        String nome = scanner.next();
        System.out.println("inserisci la nuova durata del corso:");
        String durata = scanner.next();
        System.out.println("Inserisci il nuovo giorno di inizio del corso: ");
        int giorno = scanner.nextInt();
        System.out.println("Inserisci il nuovo mese di inizio del corso: ");
        int mese = scanner.nextInt();
        System.out.println("Inserisci il nuovo anno di inizio del corso: ");
        int anno = scanner.nextInt();
        read();
        System.out.println("Inserisci l'id del nuovo docente: ");
        int docenteId= scanner.nextInt();
        LocalDate dataDiInizio = LocalDate.of(anno, mese, giorno);
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.update(id, nome, dataDiInizio, docenteId, durata);

    }



}
