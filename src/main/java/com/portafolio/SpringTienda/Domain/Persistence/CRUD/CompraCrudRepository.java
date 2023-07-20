package com.portafolio.SpringTienda.Domain.Persistence.CRUD;

import com.portafolio.SpringTienda.Domain.Persistence.Entity.Compra;
import com.portafolio.SpringTienda.Domain.Persistence.Entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra,Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);

}
