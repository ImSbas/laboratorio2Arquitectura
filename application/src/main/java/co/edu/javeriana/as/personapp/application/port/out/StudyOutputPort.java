package co.edu.javeriana.as.personapp.application.port.out;

import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Study;

import java.util.List;

public interface StudyOutputPort {
    public Study save(Study person);
    public Boolean delete(Integer identification);
    public List<Person> find();
    public Study findById(Integer identification);
}
