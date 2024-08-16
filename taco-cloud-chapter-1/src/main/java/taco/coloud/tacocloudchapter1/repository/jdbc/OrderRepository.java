package taco.coloud.tacocloudchapter1.repository.jdbc;

import taco.coloud.tacocloudchapter1.domain.TacoOrder;


public interface OrderRepository {

    TacoOrder save(TacoOrder order);

}