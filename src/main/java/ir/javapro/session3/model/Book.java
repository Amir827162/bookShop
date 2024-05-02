package ir.javapro.session3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted is null")
@SQLDelete(sql = "update shop.book set deleted = now() where id = ?")
public class Book extends BaseEntity {

    private String name;
    private long price;
}
