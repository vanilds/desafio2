package com.example.angular.springbootcrudapi.repository;

import com.example.angular.springbootcrudapi.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento,Integer> {
}
