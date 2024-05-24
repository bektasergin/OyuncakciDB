package tr.edu.medipol.ilerijavafinal.ilerijavafinal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.sql.Date;

@Data
@AllArgsConstructor
@ToString
public class OyuncakDTO {

    private Long id;
    private Date alisTarihi;
    private Double alisFiyati;
    private String ad;
    private String tur;
    private Integer desi;
    private String notlar;
}
