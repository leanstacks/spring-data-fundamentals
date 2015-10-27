package org.example.ws.repository;

import java.util.Collection;

import org.example.ws.AbstractTest;
import org.example.ws.model.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Unit tests for the AccountRepository interface.
 * 
 * @author Matt Warman
 *
 */
@Transactional
public class AccountRepositoryTests extends AbstractTest {

    @Autowired
    private AccountRepository repository;

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testFindByUsername() {

        String username = "user";

        Account entity = repository.findByUsername(username);

        Assert.assertNotNull("failure - expected entity not null", entity);
        Assert.assertEquals("failure - expected username attribute match",
                username, entity.getUsername());

    }

    @Test
    public void testFindByUsernameLike() {

        String username = "er";

        Collection<Account> list = repository
                .findByUsernameContainingIgnoreCaseAndEnabledTrueOrderByUsernameAsc(
                        username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 2, list.size());

    }

    @Test
    public void testFindByUsernameLikeMixedCase() {

        String username = "eR";

        Collection<Account> list = repository
                .findByUsernameContainingIgnoreCaseAndEnabledTrueOrderByUsernameAsc(
                        username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 2, list.size());

    }

    @Test
    public void testFindByUsernameLikeMixedCaseSingleResult() {

        String username = "UsEr";

        Collection<Account> list = repository
                .findByUsernameContainingIgnoreCaseAndEnabledTrueOrderByUsernameAsc(
                        username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 1, list.size());

    }

    @Test
    public void testFindByUsernameNamedQuery() {

        String username = "user";

        Account entity = repository.findByUsernameNamedQuery(username);

        Assert.assertNotNull("failure - expected entity not null", entity);
        Assert.assertEquals("failure - expected username attribute match",
                username, entity.getUsername());

    }

    @Test
    public void testFindAllEnabledLikeUsernameNamedQuery() {

        String username = "%er%";

        Collection<Account> list = repository
                .findAllEnabledLikeUsernameNamedQuery(username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 2, list.size());

    }

    @Test
    public void testFindAllEnabledLikeUsernameNamedQueryMixedCase() {

        String username = "%eR%";

        Collection<Account> list = repository
                .findAllEnabledLikeUsernameNamedQuery(username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 2, list.size());

    }

    @Test
    public void testFindAllEnabledLikeUsernameNamedQueryMixedCaseSingleResult() {

        String username = "%UsEr%";

        Collection<Account> list = repository
                .findAllEnabledLikeUsernameNamedQuery(username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 1, list.size());

    }

    @Test
    public void testFindByUsernameQuery() {

        String username = "user";

        Account entity = repository.findByUsernameQuery(username);

        Assert.assertNotNull("failure - expected entity not null", entity);
        Assert.assertEquals("failure - expected username attribute match",
                username, entity.getUsername());

    }

    @Test
    public void testFindAllEnabledLikeUsernameQuery() {

        String username = "%er%";

        Collection<Account> list = repository
                .findAllEnabledLikeUsernameQuery(username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 2, list.size());

    }

    @Test
    public void testFindAllEnabledLikeUsernameQueryMixedCase() {

        String username = "%eR%";

        Collection<Account> list = repository
                .findAllEnabledLikeUsernameQuery(username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 2, list.size());

    }

    @Test
    public void testFindAllEnabledLikeUsernameQueryMixedCaseSingleResult() {

        String username = "%UsEr%";

        Collection<Account> list = repository
                .findAllEnabledLikeUsernameQuery(username);

        Assert.assertNotNull("failure - expected list not null", list);
        Assert.assertEquals("failure - expected list size", 1, list.size());

    }

}
