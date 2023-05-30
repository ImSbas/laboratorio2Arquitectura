package co.edu.javeriana.as.personapp.mariadb.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.javeriana.as.personapp.mariadb.adapter.PersonOutputAdapterMaria;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Gender;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.mariadb.entity.EstudiosEntity;
import co.edu.javeriana.as.personapp.mariadb.entity.PersonaEntity;
import co.edu.javeriana.as.personapp.mariadb.entity.TelefonoEntity;
import lombok.NonNull;

@Mapper
public class PersonaMapperMaria {

	@Autowired
	private EstudiosMapperMaria estudiosMapperMaria;

	@Autowired
	private TelefonoMapperMaria telefonoMapperMaria;

	public PersonaEntity fromDomainToAdapter(Person person) {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setCc(person.getIdentification());
		personaEntity.setNombre(person.getFirstName());
		personaEntity.setApellido(person.getLastName());
		personaEntity.setGenero(validateGenero(person.getGender()));
		personaEntity.setEdad(validateEdad(person.getAge()));
		personaEntity.setEstudios(validateEstudios(person.getStudies()));
		personaEntity.setTelefonos(validateTelefonos(person.getPhoneNumbers()));
		return personaEntity;
	}

	private Character validateGenero(@NonNull Gender gender) {
		return gender == Gender.FEMALE ? 'F' : gender == Gender.MALE ? 'M' : ' ';
	}

	private Integer validateEdad(Integer age) {
		return age != null && age >= 0 ? age : null;
	}

	public List<EstudiosEntity> validateEstudios(List<Study> studies) {
		return studies != null && !studies.isEmpty()
				? studies.stream().map(study -> estudiosMapperMaria.fromDomainToAdapter(study)).collect(Collectors.toList())
				: new ArrayList<EstudiosEntity>();
	}

	private List<TelefonoEntity> validateTelefonos(List<Phone> phoneNumbers) {
		return phoneNumbers != null && !phoneNumbers.isEmpty() ? phoneNumbers.stream()
				.map(phone -> telefonoMapperMaria.fromDomainToAdapter(phone)).collect(Collectors.toList())
				: new ArrayList<TelefonoEntity>();
	}



	public @NonNull Gender validateGender(Character genero) {
		return genero == 'F' ? Gender.FEMALE : genero == 'M' ? Gender.MALE : Gender.OTHER;
	}

	private Integer validateAge(Integer edad) {
		return edad != null && edad >= 0 ? edad : null;
	}

	public List<Study> validateStudies(List<EstudiosEntity> estudiosEntity) {
		return estudiosEntity != null && !estudiosEntity.isEmpty() ? estudiosEntity.stream()
				.map(estudio -> estudiosMapperMaria.fromAdapterToDomain(estudio)).collect(Collectors.toList())
				: new ArrayList<Study>();
	}

	private List<Phone> validatePhones(List<TelefonoEntity> telefonoEntities) {
		return telefonoEntities != null && !telefonoEntities.isEmpty() ? telefonoEntities.stream()
				.map(telefono -> telefonoMapperMaria.fromAdapterToDomain(telefono)).collect(Collectors.toList())
				: new ArrayList<Phone>();
	}

	public Person fromAdapterToDomain(PersonaEntity persistedPersona) {
		Person person = new Person();
		person.setGender(this.validateGender(persistedPersona.getGenero()));
		person.setAge(persistedPersona.getEdad());
		person.setFirstName(persistedPersona.getNombre());
		person.setStudies(this.validateStudies(persistedPersona.getEstudios()));
		person.setLastName(persistedPersona.getApellido());
		person.setIdentification(persistedPersona.getCc());
		return person;
	}
}