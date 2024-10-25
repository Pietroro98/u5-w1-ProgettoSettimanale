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
        Edificio edificio = new Edificio();  //nel db ci sono 2 edifici..
        edificio.setNome("Mediolanum Forum");
        edificio.setIndirizzo("G. di vittorio");
        edificio.setCitta("Assago");

        Edificio savedEdificio = edificioService.save(edificio);

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
//        postazionePrivata.setCodiceUnivoco("PSP111-222");
//        postazionePrivata.setDescrizione("Postazione in ufficio privato");
//        postazionePrivata.setTipoPostazione(TipoPostazione.PRIVATO);
//        postazionePrivata.setNumeroMassimoOccupanti(1);
//        postazionePrivata.setEdificio(savedEdificio);
//        postazioneService.save(postazionePrivata);
//
//        Postazione savedPostazione1 = postazioneService.save(postazionePrivata);
//
//        if (savedPostazione1 != null) {
//            System.out.println("Nuova postazione salvata correttamente: " +
//                    savedPostazione.getCodiceUnivoco());
//        }
//
//        // Postazione sala riunioni
//        Postazione postazioneSalaRiunioni = new Postazione();
//        postazioneSalaRiunioni.setCodiceUnivoco("PSSR333-444");
//        postazioneSalaRiunioni.setDescrizione("Postazione in sala riunioni");
//        postazioneSalaRiunioni.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
//        postazioneSalaRiunioni.setNumeroMassimoOccupanti(15);
//        postazioneSalaRiunioni.setEdificio(edificio);
//        postazioneService.save(postazioneSalaRiunioni);


//        // -----------UTENTE----------------------
//        Utente utente = new Utente();
//        utente.setUsername("MrDoris");
//        utente.setNomeCompleto("Ennio Doris");
//        utente.setEmail("ennio.doris@example.com");
//        utenteService.save(utente);
        // ho creato anche il mio utente Pietro



        System.out.println("\n==== UTENTI ===");

        Utente utente1 = utenteService.findByUsername("MrDoris");
        System.out.println("Utente trovato con nome: " + utente1);

        Utente utente2 = utenteService.findByUsername("PietroRo");
        System.out.println("Utente trovato con nome: " + utente2);


        System.out.println("\n==== POSTAZIONE ===");


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

    }
}
