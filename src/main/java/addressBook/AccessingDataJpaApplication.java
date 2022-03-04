package addressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    public AccessingDataJpaApplication(){

    }

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo2(AddressBookRepository addressBookRepository){
        return (args) -> {
            // save a few address books
            AddressBook addressBook1 = new AddressBook();
            addressBook1.addBuddy(new BuddyInfo("johnny"));
            AddressBook addressBook2 = new AddressBook();
            addressBook2.addBuddy(new BuddyInfo("timmy"));
            addressBookRepository.save(addressBook1);
            addressBookRepository.save(addressBook2);
            // fetch all address books
            log.info("AddressBooks found with findAll():");
            log.info("-------------------------------");
            for (AddressBook addressBook : addressBookRepository.findAll()) {
                log.info(addressBook.toString());
            }
            log.info("");

            // fetch an individual address book by ID
            AddressBook addressBook = addressBookRepository.findById(1L);
            log.info("AddressBook found with findById(1L):");
            log.info("--------------------------------");
            log.info(addressBook.toString());
            log.info("");
        };
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few buddies
            repository.save(new BuddyInfo("Justin Trudeau"));
            repository.save(new BuddyInfo("Boris Johnson"));
            repository.save(new BuddyInfo("Joe Biden"));
            repository.save(new BuddyInfo("David"));
            repository.save(new BuddyInfo("Michelle"));

            // fetch all buddies
            log.info("BuddyInfos found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch buddies by name
            log.info("BuddyInfos found with findByName('David'):");
            log.info("--------------------------------------------");
            repository.findByName("David").forEach(david -> {
                log.info(david.toString());
            });
            log.info("");
        };
    }
}