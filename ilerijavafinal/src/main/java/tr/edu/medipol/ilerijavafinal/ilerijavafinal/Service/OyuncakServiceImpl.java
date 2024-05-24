package tr.edu.medipol.ilerijavafinal.ilerijavafinal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.Entity.Oyuncak;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.Repo.OyuncakRepository;

import java.util.List;

@Component
public class OyuncakServiceImpl implements OyuncakService{
    @Autowired
    OyuncakRepository oyuncakRepo;

    @Override
    public Oyuncak oyuncagiEkle(Oyuncak oyuncak) {return oyuncakRepo.save(oyuncak);}

    @Override
    public Oyuncak oyuncagiGetir(Long id) {return oyuncakRepo.getReferenceById(id);}

    @Override
    public void oyuncagiSil(Long id) {oyuncakRepo.deleteById(id);}

    @Override
    public Oyuncak oyuncagiGuncelle(Oyuncak oyuncak) {return oyuncakRepo.save(oyuncak);}

    @Override
    public List<Oyuncak> oyuncaklariListele() {return oyuncakRepo.findAll();}
}
