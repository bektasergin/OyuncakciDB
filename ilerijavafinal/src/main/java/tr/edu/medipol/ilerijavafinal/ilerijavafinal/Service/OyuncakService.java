package tr.edu.medipol.ilerijavafinal.ilerijavafinal.Service;

import org.springframework.stereotype.Service;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.Entity.Oyuncak;

import java.util.List;

@Service
public interface OyuncakService {
    Oyuncak oyuncagiEkle(Oyuncak oyuncak);
    Oyuncak oyuncagiGetir(Long id);
    void oyuncagiSil(Long id);
    Oyuncak oyuncagiGuncelle(Oyuncak oyuncak);
    List<Oyuncak> oyuncaklariListele();
}
