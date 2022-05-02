package com.example.product.repository;

import com.example.product.Service.CardsService;
import com.example.product.Service.SequenceGeneratorService;
import com.example.product.entity.AccountType;
import com.example.product.entity.CardResponse;
import com.example.product.entity.Product;
import com.example.product.entity.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import retrofit2.Call;

import java.io.IOException;
import java.util.Objects;
@Repository
public class Validator {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    CardsService cardsService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public Product accountvalidator(Product product, AccountType accountType) throws IOException {

        if (accountType.getMinimumbalance() < product.getBalance() && accountType.isCreditcardrequired()) {

            Call<CardResponse> call3 = cardsService.cardrequest(product.getIdclient());
            CardResponse cardResponse = new CardResponse();
            cardResponse = call3.execute().body();

            //Product product1 = productRepository.findByIdclient(product.getIdclient());

            //Valida que el cliente tenga una Tarjeta de Credito
            if (Objects.equals(cardResponse.getCardtype(), "Credit")) {

                return product;

            } else return null;

        } else if (accountType.getMinimumbalance() < product.getBalance())

            return product;

        else return null;
    }
    public Product productvalidator(ProductRequest productRequest) throws IOException {

        AccountType accountType = accountTypeRepository.findByAccounttypeAndClienttype(productRequest.getAccounttype(), productRequest.getClienttype());

        Product product1 = productRepository.findByIdclient(productRequest.getIdclient());

        //Valida que no se creen cuentas de tipos no permitidos
        if (accountType == null) {
            return null;
        }
        //Valida que no se cree una segunda cuenta con el mismo DNI en los casos que no aplica
        else if (product1 != null && !Objects.equals(productRequest.getAccounttype(),"VIP") && Objects.equals(productRequest.getClienttype(),"Personal")) {
            return null;
        } else {

            Product product = new Product();
            product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
            product.setIdaccount(productRequest.getIdaccount());
            product.setAccounttype(productRequest.getAccounttype());
            product.setBalance(productRequest.getBalance());
            product.setIdclient(productRequest.getIdclient());
            product.setCurrency(productRequest.getCurrency());
            product.setComission(productRequest.getComission());
            product.setMovementlimit(productRequest.getMovementlimit());
            product.setUniquedayofmovement(productRequest.getUniquedayofmovement());

            return accountvalidator(product, accountType);

        }
    }
}