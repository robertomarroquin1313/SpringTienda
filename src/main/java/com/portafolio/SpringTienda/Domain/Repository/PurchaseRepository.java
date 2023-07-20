package com.portafolio.SpringTienda.Domain.Repository;

import com.portafolio.SpringTienda.Domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);

}
