package systems.ab4.workshop.spots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.DateFormatter;

import java.util.*;

@SpringBootApplication
public class SpotsApplication {
	private static final Logger log= LoggerFactory.getLogger(SpotsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpotsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LocationRepository locationRepository, SpotRepository spotRepository) {
		return (args) -> {
			Location romania = new Location("Romania ", null, LocationType.COUNTRY);
			Location ilfov = new Location("Ilfov", romania, LocationType.REGION);
			Location brasov = new Location("Brasov", romania, LocationType.REGION);
			Location constanta = new Location("Constanta", romania, LocationType.REGION);


			//ilfov

			Location bucuresti = new Location("Bucuresti", ilfov, LocationType.TOWN);
			//brasov

			Location predeal = new Location("Predeal", brasov, LocationType.TOWN);
			Location sinaia = new Location("Sinaia", brasov, LocationType.TOWN);


			List<Location> locations = Arrays.asList(romania, brasov, constanta, ilfov, bucuresti, predeal, sinaia);

			locationRepository.save(locations);

			log.info("Locations found with findAll()");
			log.info("------------------------------");
			for (Location location : locationRepository.findAll()) {

				log.info(location.toString());
			}
			log.info("");


			Location firstEverLocation = locationRepository.findOne(1L);
			log.info("Location found with findONE(1L):");
			log.info("--------------------------------");
			log.info(firstEverLocation.toString());
			log.info("");


			log.info("Location found with findByLastName('Constanta'):");
			log.info("------------------------------------------------");
			for (Location location : locationRepository.findByName("Constanta")) {
				log.info(location.toString());
			}

			DateFormatter df = new DateFormatter("dd/MM/yyyy");
			Locale ro = Locale.forLanguageTag("ro");

			Spot predealClimbing = new Spot("Predeal Climbing School" , df.parse("15/06/2017" ,ro) ,
					df.parse("15/10/2017" ,ro),29.90 , predeal , new HashSet<>(Arrays.asList(Activity.CLIMBING,Activity.KITESURFING)));


			List<Spot> spots= Arrays.asList(predealClimbing);
			spotRepository.save(spots);

			log.info("Location found with findOne(1L):");
			log.info("--------------------------------");
			log.info(spotRepository.findOne(1L).toString());
		};
	}



}
