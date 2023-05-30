package co.edu.javeriana.as.personapp.mongo.adapter;

import co.edu.javeriana.as.personapp.application.port.out.ProfessionOutputPort;
import co.edu.javeriana.as.personapp.domain.Profession;

import java.util.List;

public class ProfessionOutputAdapterMongo implements ProfessionOutputPort {
    @Override
    public Profession save(Profession profession) {
        return null;
    }

    @Override
    public Boolean delete(Integer identification) {
        return null;
    }

    @Override
    public List<Profession> find() {
        return null;
    }

    @Override
    public Profession findById(Integer identification) {
        return null;
    }
}
