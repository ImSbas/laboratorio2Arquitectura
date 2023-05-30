package co.edu.javeriana.as.personapp.mongo.adapter;

import co.edu.javeriana.as.personapp.application.port.out.PhoneOutputPort;
import co.edu.javeriana.as.personapp.domain.Phone;

import java.util.List;

public class PhoneOutputAdapterMongo implements PhoneOutputPort {
    @Override
    public Phone save(Phone phone) {
        return null;
    }

    @Override
    public Boolean delete(Integer number) {
        return null;
    }

    @Override
    public List<Phone> find() {
        return null;
    }
}
