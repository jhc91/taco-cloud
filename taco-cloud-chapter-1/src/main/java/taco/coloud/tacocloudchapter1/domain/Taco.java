package taco.coloud.tacocloudchapter1.domain;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("tacos")
public class Taco {

    /**
     * 分区key
     */
    @PrimaryKeyColumn(type= PrimaryKeyType.PARTITIONED)
    private UUID id = Uuids.timeBased();

    /**
     * 聚类key
     */
    @PrimaryKeyColumn(type=PrimaryKeyType.CLUSTERED,
            ordering= Ordering.DESCENDING)
    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "名字必须5个字符长度")
    private String name;

    @Size(min=1, message="You must choose at least 1 ingredient")
    @Column("ingredients")
    private List<IngredientUDT> ingredients = new ArrayList<>();

}