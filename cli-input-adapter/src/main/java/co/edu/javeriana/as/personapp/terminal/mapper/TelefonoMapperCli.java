package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.mariadb.entity.TelefonoEntity;
import co.edu.javeriana.as.personapp.mariadb.mapper.PersonaMapperMaria;
import co.edu.javeriana.as.personapp.terminal.model.TelefonoModelCli;
import org.springframework.beans.factory.annotation.Autowired;



@Mapper
public class TelefonoMapperCli {

    @Autowired
    private final PersonaMapperMaria personaMapperMaria;

    public TelefonoMapperCli(PersonaMapperMaria personaMapperMaria) {
        this.personaMapperMaria = personaMapperMaria;
    }

    public TelefonoModelCli fromDomainToAdapterCli(Phone phone) {
        TelefonoModelCli phoneModelCli = new TelefonoModelCli();
        phoneModelCli.setNumber(phone.getNumber());
        phoneModelCli.setOwner((phone.getOwner()));
        phoneModelCli.setCompany((phone.getCompany()));
        return phoneModelCli;
    }

    public TelefonoEntity fromDomainToEntity(Phone phone) {
        TelefonoEntity telefono = new TelefonoEntity();
        telefono.setDuenio(personaMapperMaria.fromDomainToAdapter(phone.getOwner()));
        telefono.setNum(phone.getNumber());
        telefono.setOper(phone.getCompany());
        return telefono;
    }


}
