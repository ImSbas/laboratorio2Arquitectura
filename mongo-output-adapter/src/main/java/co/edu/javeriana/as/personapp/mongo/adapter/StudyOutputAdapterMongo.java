package co.edu.javeriana.as.personapp.mongo.adapter;

import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Study;

import java.util.List;

@Adapter("StudyOutputAdapterMongo")
public class StudyOutputAdapterMongo implements StudyOutputPort {
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
