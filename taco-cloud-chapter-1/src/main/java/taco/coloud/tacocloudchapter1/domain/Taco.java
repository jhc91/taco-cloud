package taco.coloud.tacocloudchapter1.domain;

import java.util.List;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Taco {

    @NotNull
    @Size(min = 5, message = "名字必须5个字符长度")
    private String name;

    @NotNull
    @Size(min = 1, message = "墨西哥卷必须有一份配料")
    private List<Ingredient> ingredients;

}