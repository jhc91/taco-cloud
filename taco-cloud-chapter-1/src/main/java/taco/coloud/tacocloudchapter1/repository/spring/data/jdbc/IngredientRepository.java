package taco.coloud.tacocloudchapter1.repository.spring.data.jdbc;

import org.springframework.data.repository.CrudRepository;
import taco.coloud.tacocloudchapter1.domain.Ingredient;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}