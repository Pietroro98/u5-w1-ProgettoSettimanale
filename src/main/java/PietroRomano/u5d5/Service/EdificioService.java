package PietroRomano.u5d5.Service;

import PietroRomano.u5d5.Repository.EdificioRepository;
import PietroRomano.u5d5.entites.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio save(Edificio edificio){
        return edificioRepository.save(edificio);
    }
}
