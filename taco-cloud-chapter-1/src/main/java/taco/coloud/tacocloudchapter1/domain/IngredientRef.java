package taco.coloud.tacocloudchapter1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Data
public class IngredientRef {

    private final String ingredient;

}