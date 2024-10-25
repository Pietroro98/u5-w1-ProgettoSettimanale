package PietroRomano.u5d5.Service;

import PietroRomano.u5d5.Repository.UtenteRepository;
import PietroRomano.u5d5.entites.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente save(Utente utente){
        return utenteRepository.save(utente);
    }
}
