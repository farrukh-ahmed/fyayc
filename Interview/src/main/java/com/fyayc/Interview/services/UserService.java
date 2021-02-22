package com.fyayc.Interview.services;

import com.fyayc.Interview.dto.PurchaseOrTradeDto;
import com.fyayc.Interview.entities.ProductEntity;
import com.fyayc.Interview.entities.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity addUser(UserEntity user);
    UserEntity updateUser(UserEntity user);
    List<UserEntity> getAllUsers();
    UserEntity addProductsToCart(UserEntity user);
    List<UserEntity> purchaseOrTrade(PurchaseOrTradeDto purchaseOrTradeDto);
    List<UserEntity> updateUsers(List<UserEntity> users);
    UserEntity findUserById(Integer id);
    List<ProductEntity> getUserProducts(Integer id);
    List<ProductEntity> getUserProductsByPrice(Integer userId, Integer startPrice, Integer endPrice);

}
