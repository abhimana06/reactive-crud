package com.abhicodes.reactivecrud.services;

import com.abhicodes.reactivecrud.dto.ProductDto;
import com.abhicodes.reactivecrud.model.Product;
import com.abhicodes.reactivecrud.repository.ProductRepository;
import com.abhicodes.reactivecrud.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.invoke.VolatileCallSite;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Flux<ProductDto> getAllProducts() {
        return productRepository.findAll().map(AppUtils::entityToDTO);
    }

    public Mono<ProductDto> getProduct(String productId) {
        return productRepository.findById(productId).map(AppUtils::entityToDTO);
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {
        return productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(productRepository::insert)
                .map(AppUtils::entityToDTO);
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, String id) {
        return productRepository.findById(id)
                .flatMap(p -> productDtoMono.map(AppUtils::dtoToEntity))
                .doOnNext(e -> e.setProdId(id))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDTO);
    }


    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }


}
