package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Gender;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.mariadb.entity.PersonaEntity;
import co.edu.javeriana.as.personapp.mariadb.mapper.PersonaMapperMaria;
import co.edu.javeriana.as.personapp.terminal.model.PersonaModelCli;
import org.springframework.beans.factory.annotation.Autowired;

;
@Mapper
public class PersonaMapperCli {

	@Autowired
	PersonaMapperMaria personaMapperMaria;

	public PersonaModelCli fromDomainToAdapterCli(Person person) {
		PersonaModelCli personaModelCli = new PersonaModelCli();
		personaModelCli.setCc(person.getIdentification());
		personaModelCli.setNombre(person.getFirstName());
		personaModelCli.setApellido(person.getLastName());
		personaModelCli.setGenero(person.getGender().toString());
		personaModelCli.setEdad(person.getAge());
		return personaModelCli;
	}

	public Person fromClitoDomain(PersonaEntity persona) {
		Person personaD = new Person();
		personaD.setFirstName(persona.getApellido());
		personaD.setLastName(persona.getApellido());
		personaD.setAge(persona.getEdad());
		personaD.setStudies(this.personaMapperMaria.validateStudies(persona.getEstudios()));
		personaD.setGender(this.personaMapperMaria.validateGender(persona.getGenero()));
		return personaD;

	}
}
