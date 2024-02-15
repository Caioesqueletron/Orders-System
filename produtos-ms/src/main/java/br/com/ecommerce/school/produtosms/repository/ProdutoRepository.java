package br.com.ecommerce.school.produtosms.repository;

import br.com.ecommerce.school.produtosms.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
