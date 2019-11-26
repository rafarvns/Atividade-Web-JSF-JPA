package atividadewebjsf.domain.notation;

import atividadewebjsf.abstraction.QueryDslAndJPASupport;
import atividadewebjsf.domain.notation.QNotation;

import java.util.List;

public class NotationCtrl extends QueryDslAndJPASupport {

    Notation notation;

    public NotationCtrl(Notation entity) {
        super(entity);
        this.notation = entity;
    }

    public Notation getOne(Long id) {
        QNotation notation = QNotation.notation;
        return (Notation) getQueryDSL()
                .select(notation)
                .from(notation)
                .on(notation.id.eq(id))
                .fetchOne();

    }

    public List<Notation> getAll() {
        QNotation notation = QNotation.notation;
        return (List<Notation>) getQueryDSL().select(notation)
                .from(notation)
                .fetch();
    }

}
