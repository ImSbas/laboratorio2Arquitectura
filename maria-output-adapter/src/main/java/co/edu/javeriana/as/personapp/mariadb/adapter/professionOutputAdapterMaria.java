package co.edu.javeriana.as.personapp.mariadb.adapter;

import co.edu.javeriana.as.personapp.application.port.out.ProfessionOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.domain.Profession;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Adapter("professionOutputAdapterMaria")
public class professionOutputAdapterMaria implements ProfessionOutputPort {
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
