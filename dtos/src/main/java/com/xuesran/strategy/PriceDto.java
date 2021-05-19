package com.xuesran.strategy;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto implements Serializable {

    private Integer pid;
    private Double discount_price;
    private Double sale_price;
    private Double act_price;

}
