package addressBook;

import static org.assertj.core.api.Assertions.assertThat;

import addressBook.AddressBookController;
import addressBook.AddressBookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(classes = {AddressBookController.class, AddressBookRepository.class})
public class SmokeTest {

    @MockBean
    AddressBookRepository repository;

    @Autowired
    AddressBookController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
