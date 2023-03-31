package edu.poly.TrainingApplication.custommodel;

import edu.poly.TrainingApplication.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductCustom {

//    private Long id;
    private Long idSubCate;
    private String productName;
    private String color;

    private Long quantity;
    private double sellPrice;
    private double originPrice;

    private String description;
    private Long idStatus;

    private Brand brand;

}
