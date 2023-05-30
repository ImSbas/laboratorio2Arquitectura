package co.edu.javeriana.as.personapp.terminal.adapter;

import co.edu.javeriana.as.personapp.application.port.in.StudyInputPort;
import co.edu.javeriana.as.personapp.application.port.out.PersonOutputPort;
import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.application.usecase.PersonUseCase;
import co.edu.javeriana.as.personapp.application.usecase.PhoneUseCase;
import co.edu.javeriana.as.personapp.application.usecase.StudyUserCase;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.common.exceptions.InvalidOptionException;
import co.edu.javeriana.as.personapp.common.setup.DatabaseOption;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.mariadb.entity.EstudiosEntity;
import co.edu.javeriana.as.personapp.mariadb.entity.PersonaEntity;
import co.edu.javeriana.as.personapp.mariadb.repository.EstudiosRepository;
import co.edu.javeriana.as.personapp.mariadb.repository.PersonaRepositoryMaria;
import co.edu.javeriana.as.personapp.terminal.mapper.EstudiosMapperCli;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

@Slf4j
@Adapter
public class EstudiosInputAdapterCli {

    @Autowired
    EstudiosRepository estudiosRepository;

    @Autowired
    PersonaRepositoryMaria personaRepositoryMaria;

    @Autowired
    @Qualifier("StudyOutputAdapterMaria")
    private StudyOutputPort studyOutputPortMaria;

    @Autowired
    @Qualifier("StudyOutputAdapterMongo")
    private StudyOutputPort studyOutputPortMongo;


    @Autowired
    private EstudiosMapperCli estudiosMapperCli;

    StudyInputPort studyInputPort;

    public void setEstudiosOutputPortInjection(String dbOption) throws InvalidOptionException {
        if (dbOption.equalsIgnoreCase(DatabaseOption.MARIA.toString())) {
            studyInputPort = new StudyUserCase(studyOutputPortMaria);
        } else if (dbOption.equalsIgnoreCase(DatabaseOption.MONGO.toString())) {
            studyInputPort = new StudyUserCase(studyOutputPortMongo);
        } else {
            throw new InvalidOptionException("Invalid database option: " + dbOption);
        }
    }
    public void historial() {
        log.info("Into estudios entity");
        estudiosRepository.findAll().forEach(System.out::println);
    }

    public boolean crear(Study study) {
        log.info(("Into estudios entity"));
        EstudiosEntity estudio = estudiosMapperCli.fromDomainToEntity(study);
        estudiosRepository.save(estudio);
        return true;
    }

    public Study inputStudy(Scanner keyboard) {
        System.out.printf("ingrese el id del estudio ");
        String id = keyboard.next();
        System.out.printf("ingrese la cedula de la persona asociada ");
        String cc = keyboard.next();
        System.out.printf("ingrese la fecha de graduación separado por \"/\" dd/mm/yyyy");
        String []dateNotSplited = keyboard.next().split("/");
        Date date = new Date(Integer.parseInt(dateNotSplited[0]),Integer.parseInt(dateNotSplited[1]),Integer.parseInt(dateNotSplited[2]));
        System.out.printf("ingrese la univerisidad");
        String uni = keyboard.next();
        Study study = new Study();
        study.setGraduationDate(LocalDate.of(date.getYear(),date.getMonth(),date.getDay()));
        Optional<PersonaEntity> person = personaRepositoryMaria.findById(Integer.parseInt((cc)));
        System.out.printf("person => ", person);
        return null;
    }
}
