package tr.edu.medipol.ilerijavafinal.ilerijavafinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.Entity.Oyuncak;
import tr.edu.medipol.ilerijavafinal.ilerijavafinal.Repo.OyuncakRepository;

@SpringBootApplication
public class IlerijavafinalApplication implements CommandLineRunner {

	@Autowired
	OyuncakRepository oyuncakRepository;

	public static void main(String[] args) {
		SpringApplication.run(IlerijavafinalApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Oyuncak oyuncak = new Oyuncak();
		oyuncak.setAlisTarihi(null);
		oyuncak.setAlisFiyati(1599.9);
		oyuncak.setAd("TabuXL");
		oyuncak.setTur("Kutu oyunu");
		oyuncak.setDesi(20);
		oyuncak.setNotlar("+13 yaş için kutu oyunu");
		oyuncakRepository.save(oyuncak);

		Oyuncak oyuncak2 = new Oyuncak();
		oyuncak2.setAlisTarihi(null);
		oyuncak2.setAlisFiyati(689.99);
		oyuncak2.setAd("Prenses Bebek Karlar Kraliçesi");
		oyuncak2.setTur("Oyuncak bebel");
		oyuncak2.setDesi(5);
		oyuncak2.setNotlar("Küçük çocuklar için oyuncak bebek.");
		oyuncakRepository.save(oyuncak2);
	}
}
