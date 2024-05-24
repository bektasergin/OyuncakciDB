package tr.edu.medipol.ilerijavafinal.ilerijavafinal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Oyuncak {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date alisTarihi;
    private Double alisFiyati;
    private String ad;
    private String tur;
    private Integer desi;
    private String notlar;
}
