package co.edu.javeriana.as.personapp.mariadb.adapter;

import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.mariadb.repository.EstudiosRepository;
import co.edu.javeriana.as.personapp.mariadb.repository.PersonaRepositoryMaria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@Adapter("StudyOutputAdapterMaria")
public class StudyOutputAdapterMaria implements StudyOutputPort {

    @Autowired
    private EstudiosRepository estudiosRepository;

    @Override
    public Study save(Study person) {
        return null;
    }

    @Override
    public Boolean delete(Integer identification) {
        return null;
    }

    @Override
    public List<Person> find() {
        return null;
    }

    @Override
    public Study findById(Integer identification) {
        return null;
    }
}
