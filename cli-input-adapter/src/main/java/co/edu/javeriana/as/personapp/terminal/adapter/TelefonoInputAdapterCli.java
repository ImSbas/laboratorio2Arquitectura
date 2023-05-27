package co.edu.javeriana.as.personapp.terminal.adapter;

import co.edu.javeriana.as.personapp.application.port.in.PersonInputPort;
import co.edu.javeriana.as.personapp.application.port.in.PhoneInputPort;
import co.edu.javeriana.as.personapp.application.port.out.PersonOutputPort;
import co.edu.javeriana.as.personapp.application.port.out.PhoneOutputPort;
import co.edu.javeriana.as.personapp.application.usecase.PersonUseCase;
import co.edu.javeriana.as.personapp.application.usecase.PhoneUseCase;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.common.exceptions.InvalidOptionException;
import co.edu.javeriana.as.personapp.common.setup.DatabaseOption;
import co.edu.javeriana.as.personapp.mariadb.repository.TelefonoRepositoryMaria;
import co.edu.javeriana.as.personapp.terminal.mapper.PersonaMapperCli;
import co.edu.javeriana.as.personapp.terminal.mapper.TelefonoMapperCli;
import co.edu.javeriana.as.personapp.terminal.model.PersonaModelCli;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Adapter
public class TelefonoInputAdapterCli {
    @Autowired
    @Qualifier("phoneOutputAdapterMaria")
    private PhoneOutputPort phoneOutputPort;

    @Autowired
    @Qualifier("personOutputAdapterMongo")
    private PersonOutputPort personOutputPortMongo;

    @Autowired
    private TelefonoMapperCli telefonoMapperCli;

    @Autowired
    TelefonoRepositoryMaria telefonoRepositoryMaria;

    PhoneInputPort phoneInputPort;

    public void setPhoneOutputPortInjection(String dbOption) throws InvalidOptionException {
        if (dbOption.equalsIgnoreCase(DatabaseOption.MARIA.toString())) {
            phoneInputPort = new PhoneUseCase(phoneOutputPort);
        } else if (dbOption.equalsIgnoreCase(DatabaseOption.MONGO.toString())) {
            //phoneInputPort = new PersonUseCase(personOutputPortMongo);
        } else {
            throw new InvalidOptionException("Invalid database option: " + dbOption);
        }
    }

    public void historial() {
        log.info("Into historial PersonaEntity in Input Adapter");
        //phoneInputPort.findAll()
                //.map(telefonoMapperCli::fromDomainToAdapterCli)
          //     .forEach(System.out::println);
       //telefonoRepositoryMaria.findAll().forEach(System.out::println)
        ;
    }

}
