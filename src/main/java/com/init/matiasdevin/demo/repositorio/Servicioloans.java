package com.init.matiasdevin.demo.repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.init.matiasdevin.demo.entidades.Loans;

public interface Servicioloans extends JpaRepository<Loans, Integer>  {
	
    Optional<Loans> findById(Integer id);
    // contamos creditos
    @Query(value = "SELECT count(*) FROM db_loans WHERE user_id = ? ", nativeQuery = true)
    int countLoansByUserId(int userId);
    
    // limites segun user
    @Query(value = "SELECT * FROM db_loans WHERE user_id = ? LIMIT ?,?", nativeQuery = true)
    List<Loans> findLoansByUserId(int userId, int offset, int size);
    
    // paginacion pag - size
     @Query(value ="SELECT * FROM db_loans LIMIT ?,?", nativeQuery = true)
    List<Loans> findLoans(int offset, int size);
}
