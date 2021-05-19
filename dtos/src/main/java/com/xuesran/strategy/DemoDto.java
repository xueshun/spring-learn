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
public class DemoDto implements Serializable {
    private Integer if_weight;
    private String storehouse_spu_id;
    private String if_fresh;
    private String sale_name;
    private String spu_id;
    private String storehouse_code;
    private String middle_type_code;
}
