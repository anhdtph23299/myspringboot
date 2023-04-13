package edu.poly.TrainingApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "product",uniqueConstraints={@UniqueConstraint(columnNames={"product_name"})})
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
    @NotNull(message = "Subcategory không được null")
    private SubCategory subCategory;
    @Column(name = "product_name",unique = true)
    @NotBlank(message = "Tên Product không đưc trống")
    @NotNull
    private String productName;
    @NotBlank(message = "Tên color không đưc trống")
    @NotNull(message = "Màu sắc không được null")
    private String color;
    @Min(value = 0,message = "Số lượng phải không âm")
    private Long quantity;
    @Column(name = "sell_price")
    @Min(value = 1,message = "Giá phải lớn hơn 0")
    private Double sellPrice;
    @Column(name = "origin_price")
    @Min(value = 1,message = "Giá phải lớn hơn 0")
    private Double originPrice;

    @NotBlank(message = "Mô tả không được để trống")
    private String description;
    @ManyToOne
    @JsonIgnore
    @NotNull(message = "Status không được trống")
    private Status status;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
//    @OnDelete(action = OnDeleteAction.CASCADE)
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Brand getBrand() {
        if (listProductBrand.isEmpty()) {
            return null;
        }
        return listProductBrand.get(0).getBrand();
    }

}
