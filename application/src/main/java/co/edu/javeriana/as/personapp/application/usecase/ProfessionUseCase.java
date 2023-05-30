package co.edu.javeriana.as.personapp.application.usecase;

import co.edu.javeriana.as.personapp.application.port.in.ProfessionInputPort;
import co.edu.javeriana.as.personapp.application.port.out.PersonOutputPort;
import co.edu.javeriana.as.personapp.application.port.out.ProfessionOutputPort;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProfessionUseCase implements ProfessionInputPort {

    ProfessionOutputPort professionPersistance;
    public ProfessionUseCase(@Qualifier("professionOutputAdapterMaria") ProfessionOutputPort professionOutputPort) {
        this.professionPersistance = professionOutputPort;
    }

    @Override
    public void setPersintence(ProfessionOutputPort professionOutputPort) {

    }
}
