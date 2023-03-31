package edu.poly.TrainingApplication.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    public Product(Long id, SubCategory subCategory, String productName, String color, Long quantity, double sellPrice, double originPrice, String description, Status status) {
        this.id = id;
        this.subCategory = subCategory;
        this.productName = productName;
        this.color = color;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.description = description;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "subcate_id")
    private SubCategory subCategory;
    @Column(name = "product_name")
    private String productName;
    private String color;

    private Long quantity;
    @Column(name = "sell_price")
    private double sellPrice;
    @Column(name = "origin_price")
    private double originPrice;

    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Status status;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductBrand> listProductBrand;

    @JsonProperty("status")
    public Status getStatusName() {
        return status;
    }

    @JsonProperty("subCategory")
    public SubCategory getSubCategoryName() {
        return subCategory;
    }

    @JsonProperty("brand")
    public Brand getBrand() {
        if (listProductBrand.isEmpty()) {
            return null;
        }
        return listProductBrand.get(0).getBrand();
    }

}
