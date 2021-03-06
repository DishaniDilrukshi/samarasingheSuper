package lk.samarasingherSuper.asset.item.category.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.samarasingherSuper.asset.item.entity.Enum.MainCategory;
import lk.samarasingherSuper.asset.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Category" )
public class Category {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Enumerated(EnumType.STRING)
    private MainCategory mainCategory;

    @Size( min = 3, message = "Your name cannot be accepted" )
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items;
}
