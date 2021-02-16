package org.iesvalleinclan.storeorder.config;


import org.apache.commons.lang3.RandomStringUtils;
import org.iesvalleinclan.storeorder.model.*;
import org.iesvalleinclan.storeorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class LoadBBDD {

    @Autowired
    private OrderRepository repository;

    @PostConstruct
    public void loadProducts(){
        repository.insert( createOrder( true, "User1", null ) );
        repository.insert( createOrder( false, "User2", "Surname2" ) );
        repository.insert( createOrder( true, "User3", "Surname3" ) );
        repository.insert( createOrder( false, "User2", "Surname2" ) );
        repository.insert( createOrder( true, "User1", null ) );
        repository.insert( createOrder( true, "User3", "Surname3" ) );
        repository.insert( createOrder( false, "User2", "Surname2" ) );
        repository.insert( createOrder( false, "User2", "Surname2" ) );
        repository.insert( createOrder( true, "User3", "Surname3" ) );
        repository.insert( createOrder( false, "User1", null ) );
    }

    private OrderVO createOrder(final boolean confirmed, final String name, final String surname ){
        return OrderVO.builder()
                .date( new Date(  ) )
                .reference( RandomStringUtils.randomAlphanumeric(8) )
                .products( Stream.of( createProduct(), createProduct() ).collect( Collectors.toList()) )
                .shippingAddress( AddressVO.builder()
                        .address( "Calle" )
                        .city( "Sevilla" )
                        .id( RandomStringUtils.randomAlphanumeric(2) )
                        .zipCode( "41020" )
                        .build() )
                .status( confirmed ? OrderStatusVO.CONFIRMED : OrderStatusVO.CANCELLED )
                .totalPrice( 20D )
                .user( UserVO.builder()
                        .email( "email" )
                        .name( name )
                        .phone( 666666666 )
                        .surname( surname )
                        .build() )
                .build();
    }

    private OrderedProductVO createProduct(){
        return OrderedProductVO.builder()
                .price( 10D )
                .quantity( 1 )
                .reference( RandomStringUtils.randomAlphanumeric(8) )
                .build();
    }
}

