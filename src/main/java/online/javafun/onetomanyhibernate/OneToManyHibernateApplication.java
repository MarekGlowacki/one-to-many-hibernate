package online.javafun.onetomanyhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OneToManyHibernateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OneToManyHibernateApplication.class, args);
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        ClientOrderRepository clientOrderRepository = context.getBean(ClientOrderRepository.class);

        ClientOrder order1 = new ClientOrder("Szafa modułowa", "Szafa modułowa BigBox z drzwiami przesuwnymi, 160x240cm", 1900.0);
        ClientOrder order2 = new ClientOrder("Łóżko", "Łóżko 160x200 z podnoszonym stelażem i skrzynią", 3200.0);

        clientOrderRepository.save(order1);
        clientOrderRepository.save(order2);
        Client client = new Client("Jan", "Kowalski", "Wysoka 40, 12-345 Chałupkowo");
        client.addOrder(order1);
        client.addOrder(order2);
        clientRepository.save(client);

        clientRepository.findById(1L).ifPresent(System.out::println);


    }

}
