package co.edu.javeriana.as.personapp.application.usecase;

import co.edu.javeriana.as.personapp.application.port.in.PhoneInputPort;
import co.edu.javeriana.as.personapp.application.port.out.PersonOutputPort;
import co.edu.javeriana.as.personapp.application.port.out.PhoneOutputPort;
import co.edu.javeriana.as.personapp.common.exceptions.NoExistException;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.domain.Study;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class PhoneUseCase implements PhoneInputPort {

    private PhoneOutputPort phonePersintence;

    public PhoneUseCase(@Qualifier("personOutputAdapterMaria") PhoneOutputPort phoneOutputPort) {
        this.phonePersintence=phonePersintence;
    }

    @Override
    public void setPersintence(PhoneOutputPort phonePersistance) {
        this.phonePersintence=phonePersintence;
    }

    @Override
    public Phone create(Phone phone) {
        return null;
    }

    @Override
    public Phone edit(Integer number, Phone phone) throws NoExistException {
        return null;
    }

    @Override
    public Boolean drop(Integer number) throws NoExistException {
        return null;
    }

    @Override
    public List<Phone> findAll() {
        return null;
    }

    @Override
    public Phone findOne(Integer number) throws NoExistException {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }
}
