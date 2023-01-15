package online.javafun.onetomanyhibernate;

import org.springframework.data.repository.CrudRepository;

public interface ClientOrderRepository extends CrudRepository<ClientOrder, Long> {
}
