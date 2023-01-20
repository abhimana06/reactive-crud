package com.abhicodes.reactivecrud.util;

import com.abhicodes.reactivecrud.dto.ProductDto;
import com.abhicodes.reactivecrud.model.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static ProductDto entityToDTO(Product product){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
