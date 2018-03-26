package com.globomart.service;

import com.globomart.dto.ProductDto;

import java.util.List;


public interface IPricingService {

    String getPrice(List<ProductDto> productVos);
}
