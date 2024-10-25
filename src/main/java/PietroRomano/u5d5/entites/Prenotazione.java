package PietroRomano.u5d5.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPrenotazione;

    @Column(nullable = false)
    private boolean prenotazioneLibera;

    public Prenotazione(Long id, LocalDate dataPrenotazione, boolean prenotazioneLibera) {
        this.id = id;
        this.dataPrenotazione = dataPrenotazione;
        this.prenotazioneLibera = prenotazioneLibera;
    }
    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataPrenotazione=" + dataPrenotazione +
                ", prenotazioneLibera=" + prenotazioneLibera +
                '}';
    }
}
