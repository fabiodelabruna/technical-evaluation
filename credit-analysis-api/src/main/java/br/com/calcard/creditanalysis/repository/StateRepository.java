package br.com.calcard.creditanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.calcard.creditanalysis.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
