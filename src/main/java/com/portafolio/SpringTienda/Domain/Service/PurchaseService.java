package com.portafolio.SpringTienda.Domain.Service;

import com.portafolio.SpringTienda.Domain.Persistence.CompraRepository;
import com.portafolio.SpringTienda.Domain.Product;
import com.portafolio.SpringTienda.Domain.Purchase;
import com.portafolio.SpringTienda.Domain.Repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByPurchase(String purchase){
        return purchaseRepository.getByClient((purchase));
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

}
