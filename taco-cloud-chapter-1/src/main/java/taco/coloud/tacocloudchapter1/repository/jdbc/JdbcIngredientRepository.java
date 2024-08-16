package taco.coloud.tacocloudchapter1.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import taco.coloud.tacocloudchapter1.domain.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * 这个注解是 Spring 定义的少数几个原型注解之一，包括 @Controller 和 @Component
 *
 * @Repository 注解告诉 Spring 这个类是一个仓库，是一个 Spring Data 仓库
 */
@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
                "select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,
                id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum)
            throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }
}