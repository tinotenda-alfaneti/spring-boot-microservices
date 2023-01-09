package com.atarist.productservice.dto; //dto - data transfer object


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//lombok annotations to help with creating constructors and getter methods
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private String descriptions;
    private BigDecimal price;
}
