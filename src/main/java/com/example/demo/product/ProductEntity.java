package com.example.demo.product;

import com.example.demo.BaseEntity;
import com.example.demo.order.OrderEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ProductEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private String description;

    @Column
    private String photoPath;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    @ToString.Exclude
    private List<OrderEntity> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
