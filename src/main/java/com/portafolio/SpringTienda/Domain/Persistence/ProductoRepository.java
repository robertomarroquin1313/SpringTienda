package com.portafolio.SpringTienda.Domain.Persistence;

import com.portafolio.SpringTienda.Domain.Persistence.CRUD.ProductoCrudRepository;
import com.portafolio.SpringTienda.Domain.Persistence.Entity.Producto;
import com.portafolio.SpringTienda.Domain.Repository.Mapper.ProductMapper;
import com.portafolio.SpringTienda.Domain.Product;
import com.portafolio.SpringTienda.Domain.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper  productMapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos =  productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado( quantity, true);
        return productos.map(prds ->productMapper.toProducts (prds));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRepository.findById(productId).map(gtP-> productMapper.toProduct(gtP));
    }

    @Override
    public Product save(Product product) {
        Producto producto= productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }


    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
