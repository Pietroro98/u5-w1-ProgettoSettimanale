package PietroRomano.u5d5;

import PietroRomano.u5d5.Enum.TipoPostazione;
import PietroRomano.u5d5.Service.EdificioService;
import PietroRomano.u5d5.Service.PostazioneService;
import PietroRomano.u5d5.Service.PrenotazioneService;
import PietroRomano.u5d5.Service.UtenteService;

import PietroRomano.u5d5.entites.Edificio;
import PietroRomano.u5d5.entites.Postazione;

import PietroRomano.u5d5.entites.Prenotazione;
import PietroRomano.u5d5.entites.Utente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;


    @Override
    public void run(String... args) throws Exception {

        // ------------EDIFICIO-------------------------
//        Edificio edificio = new Edificio();  //nel db ci sono 2 edifici..
//        edificio.setNome("Mediolanum Forum");
//        edificio.setIndirizzo("G. di vittorio");
//        edificio.setCitta("Assago");

//        Edificio savedEdificio = edificioService.save(edificio);

                // -----------UTENTE----------------------
//        Utente utente = new Utente();
//        utente.setUsername("MrDoris");
//        utente.setNomeCompleto("Ennio Doris");
//        utente.setEmail("ennio.doris@example.com");
//        utenteService.save(utente);


//        // Postazione Openspace
//        Postazione postazione = new Postazione();
//        postazione.setCodiceUnivoco("PST234-567");   // PST, PSP ecc del codice univoco sarebbero l'abbreviazione del tipo postazione... XD
//        postazione.setDescrizione("Postazione vicino alla finestra");
//        postazione.setTipoPostazione(TipoPostazione.OPENSPACE);
//        postazione.setNumeroMassimoOccupanti(4);
//        postazione.setEdificio(edificio);
//        postazioneService.save(postazione);
//
//        // Postazione Privata
//
//        Postazione postazionePrivata = new Postazione();
//        postazionePrivata.setCodiceUnivoco("PSP999-000");
//        postazionePrivata.setDescrizione("Postazione in ufficio privato");
//        postazionePrivata.setTipoPostazione(TipoPostazione.PRIVATO);
//        postazionePrivata.setNumeroMassimoOccupanti(1);
//        postazionePrivata.setEdificio(savedEdificio);
//        postazioneService.save(postazionePrivata);

//        postazioneService.save(postazionePrivata);

//
//        // Postazione sala riunioni
//        Postazione postazioneSalaRiunioni = new Postazione();
//        postazioneSalaRiunioni.setCodiceUnivoco("PSSR333-444");
//        postazioneSalaRiunioni.setDescrizione("Postazione in sala riunioni");
//        postazioneSalaRiunioni.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
//        postazioneSalaRiunioni.setNumeroMassimoOccupanti(15);
//        postazioneSalaRiunioni.setEdificio(edificio);
//        postazioneService.save(postazioneSalaRiunioni);


        // Recupero info dal db per le Verifiche

        System.out.println("\n==== UTENTI ===");

        Utente utente = utenteService.findByUsername("MrDoris");
        System.out.println("Utente trovato con nome: " + utente);

        Utente utente2 = utenteService.findByUsername("PietroRo");
        System.out.println("Utente trovato con nome: " + utente2);


        System.out.println("\n==== POSTAZIONE (private) ===");


        List<Postazione> postazioniPrivate = postazioneService.findByTipoAndCitta(TipoPostazione.PRIVATO, "Assago");
        if (postazioniPrivate.isEmpty()) {
            System.out.println("Nessuna postazione trovata per il tipo privato ad Assago.");
        } else {
            postazioniPrivate.forEach(postazione -> {
                System.out.println("Postazione con Cod.Univoco : " + postazione.getCodiceUnivoco() +
                        "| Descrizione: " + postazione.getDescrizione() +
                        "| Numero massimo occupanti: " + postazione.getNumeroMassimoOccupanti());
            });
        }



        System.out.println("\n==== PRENOTAZIONE 1  ===");

        Postazione postazionePrivata = postazioniPrivate.get(0);
        System.out.println("Postazione trovata con Cod.Univoco: " + postazionePrivata.getCodiceUnivoco());

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setUtente(utente2);
        prenotazione1.setPostazione(postazionePrivata);
        prenotazione1.setDataPrenotazione(LocalDate.now());
        prenotazione1.setPrenotazioneLibera(true);
        try {
            prenotazioneService.save(prenotazione1);
            System.out.println("Prenotazione salvata correttamente per l'utente: " + utente2.getUsername());
        } catch (IllegalStateException e) {
            System.out.println("Errore durante il salvataggio della prenotazione: " + e.getMessage());
        }

        // Seconda prenotazione nello stesso giorno per lo stesso utente per verificare il controllo

        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setUtente(utente2);
        prenotazione2.setPostazione(postazionePrivata);
        prenotazione2.setDataPrenotazione(LocalDate.now());
        prenotazione2.setPrenotazioneLibera(true);

        try {
            prenotazioneService.save(prenotazione2);
            System.out.println("Prenotazione salvata correttamente per l'utente: " + utente2.getUsername());
        } catch (IllegalStateException e) {
            System.out.println("Errore durante il salvataggio della seconda prenotazione: " + e.getMessage() + " da parte dell'utente: " + utente2.getUsername());
        }

    }
}
