package PietroRomano.u5d5.entites;

import PietroRomano.u5d5.Enum.TipoPostazione;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String codiceUnivoco;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;


    public Postazione(long id, String codiceUnivoco, String descrizione, TipoPostazione tipoPostazione) {
        this.id = id;
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                '}';
    }
}
