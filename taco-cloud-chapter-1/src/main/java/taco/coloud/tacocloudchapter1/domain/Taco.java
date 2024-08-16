package taco.coloud.tacocloudchapter1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "名字必须5个字符长度")
    private String name;

    @NotNull
    @Size(min = 1, message = "墨西哥卷必须有一份配料")
    @ManyToMany
    private List<Ingredient> ingredients;
    //private List<IngredientRef> ingredients;

}