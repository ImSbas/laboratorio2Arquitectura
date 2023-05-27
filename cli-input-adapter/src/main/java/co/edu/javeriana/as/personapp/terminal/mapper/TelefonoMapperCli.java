package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.terminal.model.TelefonoModelCli;

@Mapper
public class TelefonoMapperCli {

    public TelefonoModelCli fromDomainToAdapterCli(Phone phone) {
        TelefonoModelCli phoneModelCli = new TelefonoModelCli();
        phoneModelCli.setNumber(phone.getNumber());
        phoneModelCli.setOwner((phone.getOwner()));
        phoneModelCli.setCompany((phone.getCompany()));
        return phoneModelCli;
    }

}
