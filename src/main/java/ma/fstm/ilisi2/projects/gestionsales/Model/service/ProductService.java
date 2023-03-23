package ma.fstm.ilisi2.projects.gestionsales.Model.service;

import ma.fstm.ilisi2.projects.gestionsales.Model.bo.Product;
import ma.fstm.ilisi2.projects.gestionsales.Model.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Primary
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(){
        return repo.findAll();
    }
    public void save(Product product) {
        repo.save(product);
    }
    public void delete(long id) {
        repo.deleteById(id);
    }
    public Optional<Product> get(Long id) {
        return repo.findById(id);
    }
}

