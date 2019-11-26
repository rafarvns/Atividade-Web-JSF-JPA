package atividadewebjsf.domain.registration;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.registration.QRegistration;

import java.util.List;

public class RegistrationCtrl extends QueryDslAndJPASupport {

    Registration registration;

    public RegistrationCtrl(Registration entity) {
        super(entity);
        this.registration = entity;
    }

    public Registration getOne(Long id) {
        QRegistration registration = QRegistration.registration;
        return (Registration) getQueryDSL()
                .select(registration)
                .from(registration)
                .on(registration.id.eq(id))
                .fetchOne();

    }

    public List<Registration> getAll() {
        QRegistration registration = QRegistration.registration;
        return (List<Registration>) getQueryDSL().select(registration)
                .from(registration)
                .fetch();
    }

}
