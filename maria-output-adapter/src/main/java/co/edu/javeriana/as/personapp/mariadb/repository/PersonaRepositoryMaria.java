package co.edu.javeriana.as.personapp.mariadb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.as.personapp.mariadb.entity.PersonaEntity;

public interface PersonaRepositoryMaria extends JpaRepository<PersonaEntity, Integer>{

    @Query(nativeQuery = true,value = "select * from persona_db.persona where cc=?1")
    PersonaEntity findByCc(String document);
}
