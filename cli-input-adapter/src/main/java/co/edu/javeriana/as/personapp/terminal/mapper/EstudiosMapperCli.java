package co.edu.javeriana.as.personapp.terminal.mapper;


import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.mariadb.entity.EstudiosEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

@Mapper
public class EstudiosMapperCli {


    @Autowired
    private final PersonaMapperCli personaMapperCli;

    public EstudiosMapperCli(PersonaMapperCli personaMapperCli) {
        this.personaMapperCli = personaMapperCli;
    }

    public EstudiosEntity fromDomainToEntity(Study study) {
        EstudiosEntity entity = new EstudiosEntity();
        entity.setFecha( new Date(study.getGraduationDate().getYear(),study.getGraduationDate().getMonthValue(),study.getGraduationDate().getDayOfMonth()));
        entity.setPersona(personaMapperCli.personaMapperMaria.fromDomainToAdapter(study.getPerson()));
        entity.setUniver(study.getUniversityName());
        return entity;
    }
}
