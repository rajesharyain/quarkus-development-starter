package org.codekafe.model;


import io.quarkus.arc.All;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderEntity")
public class Order {
    @Id
    @SequenceGenerator(name = "orderSequence", sequenceName = "order_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "orderSequence")
    private Long id;

    private Long userId;
    private Long productId;

}
