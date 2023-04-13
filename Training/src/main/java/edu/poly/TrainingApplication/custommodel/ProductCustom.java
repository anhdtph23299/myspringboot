package edu.poly.TrainingApplication.custommodel;

import edu.poly.TrainingApplication.entity.Brand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductCustom {
    private Long id;
    @NotNull
    private Long idSubCate;
    @NotBlank
    private String productName;
    @NotBlank
    private String color;

    private Long quantity;
    @Min(value = 0)
    private double sellPrice;
    @Min(value = 0)
    private double originPrice;
    @NotBlank
    private String description;
    @NotNull
    private Long idStatus;
    @NotNull
    private Brand brand;

    public ProductCustom(Long idSubCate, String productName, String color, Long quantity, double sellPrice, double originPrice, String description, Long idStatus) {
        this.idSubCate = idSubCate;
        this.productName = productName;
        this.color = color;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.description = description;
        this.idStatus = idStatus;
    }
    public ProductCustom(Long idSubCate, String productName, String color, Long quantity, double sellPrice, double originPrice, String description, Long idStatus,Brand brand) {
        this.idSubCate = idSubCate;
        this.productName = productName;
        this.color = color;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.description = description;
        this.idStatus = idStatus;
        this.brand = brand;
    }
}
