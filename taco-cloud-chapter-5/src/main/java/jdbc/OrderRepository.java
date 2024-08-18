package jdbc;

import domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}