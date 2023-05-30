package co.edu.javeriana.as.personapp.application.usecase;

import co.edu.javeriana.as.personapp.application.port.in.StudyInputPort;
import co.edu.javeriana.as.personapp.application.port.out.PersonOutputPort;
import co.edu.javeriana.as.personapp.application.port.out.PhoneOutputPort;
import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.UseCase;
import co.edu.javeriana.as.personapp.common.exceptions.NoExistException;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.domain.Study;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
@Slf4j
@UseCase
public class StudyUserCase implements StudyInputPort {


    StudyOutputPort studyOutputPort;


    public StudyUserCase(@Qualifier("StudyOutputAdapterMaria") StudyOutputPort studyOutputPort) {
        this.studyOutputPort = studyOutputPort;
    }

    @Override
    public void setPersintence(StudyOutputPort studyOutputPort) {
        this.studyOutputPort=studyOutputPort;
    }

    @Override
    public Person create(Study study) {
        return null;
    }
}

