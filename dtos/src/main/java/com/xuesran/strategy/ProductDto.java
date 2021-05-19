package com.xuesran.strategy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * The type Product dto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    private Integer id;
    private String range_age;
    private String detail;
    private String type;
    private String title;
    private String brand;
    private String size;
}
