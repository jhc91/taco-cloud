package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taco {

    /**
     * 分区key
     */
    private Long id;

    /**
     * 聚类key
     */
    private Date createdAt;

    private String name;

    private List<IngredientUDT> ingredients = new ArrayList<>();

}