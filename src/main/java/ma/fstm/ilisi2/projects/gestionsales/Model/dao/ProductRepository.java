package ma.fstm.ilisi2.projects.gestionsales.Model.dao;


import ma.fstm.ilisi2.projects.gestionsales.Model.bo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface ProductRepository extends JpaRepository<Product,Long> {
}
