package ir.javapro.session3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
public class ShoppingCard extends BaseEntity {

    private int count;

    @ManyToOne
    private Factor factor;

    @ManyToOne
    private Book book;
}
