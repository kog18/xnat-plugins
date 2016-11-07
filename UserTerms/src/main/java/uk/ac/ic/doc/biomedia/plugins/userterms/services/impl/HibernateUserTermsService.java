package uk.ac.ic.doc.biomedia.plugins.userterms.services.impl;

import org.nrg.framework.orm.hibernate.AbstractHibernateEntity;
import org.nrg.framework.orm.hibernate.AbstractHibernateEntityService;
import uk.ac.ic.doc.biomedia.plugins.userterms.entities.UserTerms;
import uk.ac.ic.doc.biomedia.plugins.userterms.repositories.UserTermsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.ic.doc.biomedia.plugins.userterms.services.UserTermsService;

import javax.inject.Inject;
import java.util.List;

@Service
public class HibernateUserTermsService extends AbstractHibernateEntityService<UserTerms, UserTermsRepository> implements UserTermsService {
    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public UserTerms findBySubjectId(final String subjectId) {
        return getDao().findByUniqueProperty("subjectId", subjectId);
    }


    public void setHasAcceptedTerms(final Boolean hasAcceptedTerms) {
        //getDao().create()
    }

    public UserTerms getAttributesForUser(String user) {
        UserTerms example = new UserTerms();
        example.setAuthUser(user);
        List<UserTerms> attributes = _dao.findByExample(example, AbstractHibernateEntity.getExcludedProperties("verified", "failedLoginAttempts"));
        if (attributes == null || attributes.size() == 0) { return null; }
        return attributes.get(0);
    }

    @Inject
    private UserTermsRepository _dao;
}
