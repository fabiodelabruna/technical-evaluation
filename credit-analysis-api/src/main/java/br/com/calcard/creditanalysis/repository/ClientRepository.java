package br.com.calcard.creditanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calcard.creditanalysis.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
