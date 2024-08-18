package framework.convert;

import domain.Ingredient;
import jdbc.IngredientRepository;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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