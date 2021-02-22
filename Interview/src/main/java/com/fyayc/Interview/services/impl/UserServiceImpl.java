package com.fyayc.Interview.services.impl;

import com.fyayc.Interview.dto.PurchaseOrTradeDto;
import com.fyayc.Interview.dto.UserDto;
import com.fyayc.Interview.entities.ProductEntity;
import com.fyayc.Interview.entities.UserEntity;
import com.fyayc.Interview.exceptions.InvalidUserIdException;
import com.fyayc.Interview.mapping.MappingContext;
import com.fyayc.Interview.mapping.UserMapper;
import com.fyayc.Interview.repositories.UserRepository;
import com.fyayc.Interview.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    MappingContext mappingContext;


    @Override
    public UserEntity addUser(UserEntity user) {

        user.setUserId(UUID.randomUUID());
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        if (user.getUserId() == null|| user.getId() == null) throw new InvalidUserIdException();
        else return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public UserEntity addProductsToCart(UserEntity user) {

        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> purchaseOrTrade(PurchaseOrTradeDto purchaseOrTradeDto) {
        List<UserEntity> users = userRepository.findUserEntitiesByIdIn(
                Arrays.asList(purchaseOrTradeDto.getPrimaryUserId(),purchaseOrTradeDto.getSecondaryUserId()));

        UserEntity primaryUser = users
                .stream()
                .filter(u->u.getId() == purchaseOrTradeDto.getPrimaryUserId())
                .findFirst().get();

        UserEntity secondaryUser = users
                .stream()
                .filter(u->u.getId() == purchaseOrTradeDto.getSecondaryUserId()).findFirst().get();
        ProductEntity secondaryProduct = secondaryUser.getProducts()
                .stream()
                .filter(p->p.getId()==purchaseOrTradeDto.getSecondaryProductId())
                .findFirst().get();

        if(purchaseOrTradeDto.getPurchased()){

            secondaryUser.getProducts().remove(secondaryProduct);
            primaryUser.getProducts().add(secondaryProduct);


        }else{
            ProductEntity primaryProduct = secondaryUser.getProducts()
                    .stream()
                    .filter(p->p.getId()==purchaseOrTradeDto.getPrimaryProductId())
                    .findFirst().get();
            primaryUser.getProducts().remove(primaryProduct);
            primaryUser.getProducts().add(secondaryProduct);
            secondaryUser.getProducts().remove(secondaryProduct);
            secondaryUser.getProducts().add(primaryProduct);

        }
        return updateUsers(Arrays.asList(primaryUser,secondaryUser));
    }

    @Override
    public List<UserEntity> updateUsers(List<UserEntity> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public UserEntity findUserById(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.get() !=null? userEntity.get() : throw new InvalidUserIdException();
    }
}
