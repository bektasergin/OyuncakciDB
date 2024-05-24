package tr.edu.medipol.ilerijavafinal.ilerijavafinal.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.DTO.OyuncakDTO;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.Entity.Oyuncak;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.Service.OyuncakService;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OyuncakController {
    @Autowired
    OyuncakService oyuncakService;

    @PostMapping("/ekle")
    public String oyuncakEkle(@RequestBody OyuncakDTO oyuncakDTO) {
        log.info("ekle servisi çağrıldı. Parametreler: " + oyuncakDTO);

        try {
            if (oyuncakDTO.getAd() == null || oyuncakDTO.getAd().isEmpty()
                    || oyuncakDTO.getTur() == null || oyuncakDTO.getTur().isEmpty()
            ) {
                log.error("ekle servisi: Zorunlu alanlardan biri veya birkaçı boş.");
                return "Değer girmediniz. Lütfen zorunlu alanları doldurun.";
            }

            Oyuncak oyuncak = new Oyuncak();
            log.debug("ekle servisi: oyuncak nesnesi oluşturuldu.");

            oyuncak.setAlisTarihi(oyuncakDTO.getAlisTarihi());
            oyuncak.setAlisFiyati(oyuncakDTO.getAlisFiyati());
            oyuncak.setAd(oyuncakDTO.getAd());
            oyuncak.setTur(oyuncakDTO.getTur());
            oyuncak.setDesi(oyuncakDTO.getDesi());
            oyuncak.setNotlar(oyuncakDTO.getNotlar());
            log.debug("ekle servisi: oyuncak nesnesi değerleri atandı.");

            Oyuncak kaydedilmisOyuncak = oyuncakService.oyuncagiEkle(oyuncak);
            log.debug("ekle servisi: oyuncak servisi çağırıldı.");
            log.info("ekle servisi: API servisi 'ekle' çağrıldı. İstek zamanı: " + java.time.LocalDateTime.now());

            return kaydedilmisOyuncak.getAd() + " ismiyle yeni bir oyuncak oluşturuldu!";
        } catch (Exception e) {
            log.error("ekle servisi çalışırken hata aldı."
                    + "Parametreler: " + oyuncakDTO
                    + "Hata: " + e.getMessage());
        }

        return null;
    }

    @GetMapping("/getir")
    public OyuncakDTO oyuncagiGetir(Long id) {
        log.info("getir servisi çağrıldı. Parametreler: " + id);

        try {
            Oyuncak oyuncak = oyuncakService.oyuncagiGetir(id);
            log.debug("getir servisi: belirli bir kimlik numarasına sahip oyuncak nesnesi alındı.");

            if (oyuncak != null) {
                OyuncakDTO oyuncakDTO = new OyuncakDTO(oyuncak.getId(), oyuncak.getAlisTarihi(), oyuncak.getAlisFiyati(), oyuncak.getAd(), oyuncak.getTur(), oyuncak.getDesi(), oyuncak.getNotlar());
                log.debug("getir servisi: Alınan oyuncak nesnesinin özellikleri kullanılarak 'oyuncakDTO' oluşturuldu.");
                log.info("getir servisi: API servisi 'getir' çağrıldı. İstek zamanı: " + java.time.LocalDateTime.now());
                return oyuncakDTO;
            } else {
                log.error("getir servisi: Belirtilen ID'ye sahip oyuncak bulunamadı.");
                return null;
            }
        } catch (Exception e) {
            log.error("getir servisi çalışırken hata aldı."
                    + "Parametreler: " + id
                    + "Hata: " + e.getMessage());
        }
        return null;
    }


    @DeleteMapping("/sil")
    public String oyuncagiSil(Long id) {
        log.info("sil servisi çağrıldı. Parametreler: " + id);

        if (id == null) {
            return "Gerekli Alanları Doldurun";  // Return the warning message if id is not provided
        }

        if (id < 1) {
            return "ID bilgisi 0 veya negatif değer olamaz";
        }

        try {
            oyuncakService.oyuncagiSil(id);
            log.debug("sil servisi: belirli bir kimlik numarasına sahip oyuncak nesnesi silindi.");
            log.info("sil servisi: API servisi 'sil' çağrıldı. İstek zamanı: " + java.time.LocalDateTime.now());
            return id + " id nolu oyuncak kayıtlardan silindi!!";
        } catch (Exception e) {
            log.error("sil servisi çalışırken hata aldı."
                    + "Parametreler: " + id
                    + "Hata: " + e.getMessage());
        }

        return null;
    }


    @PutMapping("/guncelle/{id}")
    public String oyuncagiGuncelle(@PathVariable Long id, @RequestBody OyuncakDTO oyuncakDTO) {
        log.info("guncelle servisi çağrıldı. Parametreler: " + id + oyuncakDTO);
        try {
            Oyuncak oyuncak = oyuncakService.oyuncagiGetir(id);
            log.debug("guncelle servisi: belirli bir kimlik numarasına sahip oyuncak nesnesi alındı.");
            oyuncak.setAlisTarihi(oyuncakDTO.getAlisTarihi());
            oyuncak.setAlisFiyati(oyuncakDTO.getAlisFiyati());
            oyuncak.setAd(oyuncakDTO.getAd());
            oyuncak.setTur(oyuncakDTO.getTur());
            oyuncak.setDesi(oyuncakDTO.getDesi());
            oyuncak.setNotlar(oyuncakDTO.getNotlar());
            oyuncakService.oyuncagiEkle(oyuncak);
            log.debug("guncelle servisi: Alınan oyuncak nesnesinin özellikleri güncellenerek oyuncak nesnesine atandı.");
            log.info("guncelle servisi: API servisi 'guncelle' çağrıldı. İstek zamanı: " + java.time.LocalDateTime.now());
            return "Oyuncak güncellendi! Yeni Bilgileri: " + new OyuncakDTO(oyuncak.getId(), oyuncak.getAlisTarihi(), oyuncak.getAlisFiyati(), oyuncak.getAd(), oyuncak.getTur(), oyuncak.getDesi(), oyuncak.getNotlar());
        } catch (Exception e) {
            log.error("guncelle servisi çalışırken hata aldı."
                    + "Parametreler: " + id + oyuncakDTO
                    + "Hata: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/listele")
    public List<OyuncakDTO> tumOyuncaklariListele() {
        log.info("listele servisi çağrıldı.");
        try {
            List<Oyuncak> oyuncakListesi = oyuncakService.oyuncaklariListele();
            List<OyuncakDTO> tumOyuncaklar = new ArrayList<>();
            log.debug("listele servisi: Tüm oyuncakları  içeren liste oluşturuldu.");
            for (Oyuncak o : oyuncakListesi) {
                OyuncakDTO oDTO = new OyuncakDTO(o.getId(), o.getAlisTarihi(), o.getAlisFiyati(), o.getAd(), o.getTur(), o.getDesi(), o.getNotlar());
                tumOyuncaklar.add(oDTO);
            }
            log.debug("listele servisi: Döngü ile liste gezildi, her oyuncak nesnesi kullanılarak yeni bir 'OyuncakDTO' oluşturuldu ve " +
                    "oluşturulan 'OyuncakDTO' ları içeren yeni bir liste oluşturulup bu DTOlar eklendi.");
            log.info("listele servisi: API servisi 'listele' çağrıldı. İstek zamanı: " + java.time.LocalDateTime.now());
            return tumOyuncaklar;
        } catch (Exception e) {
            log.error("listele servisi çalışırken hata aldı."
                    + "Hata: " + e.getMessage());
        }
        return null;
    }

}

