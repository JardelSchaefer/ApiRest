// Acaba coma a necessidade de 	DAOS
package com.gProdutos.apiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gProdutos.apiRest.models.Produto;

public interface repositoryProduto extends JpaRepository< Produto, Long> {

}
