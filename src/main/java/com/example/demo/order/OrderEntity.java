package com.example.demo.order;

import com.example.demo.BaseEntity;
import com.example.demo.product.ProductEntity;
import com.example.demo.user.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class OrderEntity extends BaseEntity {

    @Column
    private double totalPrice;

    @Column
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderEntity that = (OrderEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
