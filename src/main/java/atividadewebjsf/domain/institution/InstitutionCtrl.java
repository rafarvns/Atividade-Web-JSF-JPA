package atividadewebjsf.domain.institution;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import java.util.List;

public class InstitutionCtrl extends QueryDslAndJPASupport {

    Institution institution;

    public InstitutionCtrl(Institution entity) {
        super(entity);
        this.institution = entity;
    }

    public Institution getOne(Long id) {
        QInstitution institution = QInstitution.institution;
        return (Institution) getQueryDSL()
                .select(institution)
                .from(institution)
                .on(institution.id.eq(id))
                .fetchOne();

    }

    public List<Institution> getAll() {
        QInstitution institution = QInstitution.institution;
        return (List<Institution>) getQueryDSL().select(institution)
                .from(institution)
                .fetch();
    }

}
