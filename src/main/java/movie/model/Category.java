package movie.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
