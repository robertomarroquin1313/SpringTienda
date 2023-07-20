package com.portafolio.SpringTienda.Domain.Persistence;

import com.portafolio.SpringTienda.Domain.Persistence.CRUD.CompraCrudRepository;
import com.portafolio.SpringTienda.Domain.Persistence.Entity.Compra;
import com.portafolio.SpringTienda.Domain.Repository.Mapper.PurchaseMapper;
import com.portafolio.SpringTienda.Domain.Purchase;
import com.portafolio.SpringTienda.Domain.Repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;


    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProducto().forEach(producto -> producto.setCompra(compra));

        return purchaseMapper.toPurchase(compraCrudRepository.save(compra)) ;
    }


}
