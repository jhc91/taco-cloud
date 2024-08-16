package taco.coloud.tacocloudchapter1.framework.convert;

import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import taco.coloud.tacocloudchapter1.domain.Ingredient;
import taco.coloud.tacocloudchapter1.repository.jdbc.IngredientRepository;

/**
 * 组件扫描 -> 自动装配
 */
@Data
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepo;

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}