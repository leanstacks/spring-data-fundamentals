package org.example.ws.repository;

import java.util.Collection;

import org.example.ws.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * The AccountRepository interface is a Spring Data JPA data repository for
 * Account entities. The AccountRepository provides all the data access
 * behaviors exposed by <code>JpaRepository</code> and additional custom
 * behaviors may be defined in this interface.
 * 
 * @author Matt Warman
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Query for a single Account entity by username. This method illustrates
     * the Query Method approach for query definition.
     * 
     * <pre>
     * SELECT a FROM Account a WHERE a.username = ?1
     * </pre>
     * 
     * @param username A String username value to query the repository.
     * @return An Account or <code>null</code> if none found.
     */
    Account findByUsername(String username);

    /**
     * Query for a Collection of Account entities by username. This method
     * illustrates the Query Method approach for query definition.
     * 
     * <pre>
     * SELECT a
     *   FROM Account a
     *   WHERE UPPER(a.username) like UPPER('%' + ?1 + '%')
     *     AND a.enabled = true
     *   ORDER BY A.username ASC
     * </pre>
     * 
     * @param username A String username value.
     * @return A Collection of Account entities.
     */
    Collection<Account> findByUsernameContainingIgnoreCaseAndEnabledTrueOrderByUsernameAsc(
            String username);

    /**
     * Query for a single Account entity by username. This method is associated
     * with a NamedQuery annotated on the Account entity class.
     * 
     * @param username A String username value to query the repository.
     * @return An Account or <code>null</code> if none found.
     */
    Account findByUsernameNamedQuery(String username);

    /**
     * Query for a Collection of Account entities by username. This method is
     * associated with a NamedQuery annotated on the Account entity class.
     * 
     * @param username A String username value.
     * @return A Collection of Account entities.
     */
    Collection<Account> findAllEnabledLikeUsernameNamedQuery(String username);

    /**
     * Query for a single Account entity by username. This method illustrates
     * the Query annotation approach for query definition.
     * 
     * @param username A String username value.
     * @return An Account or <code>null</code> if none found.
     */
    @Query("SELECT a FROM Account a WHERE a.username = :username")
    Account findByUsernameQuery(@Param("username") String username);

    /**
     * Query for a Collection of Account entities by username. This method
     * illustrates the Query annotation approach for query definition.
     * 
     * @param username A String username value.
     * @return A Collection of Account entities.
     */
    @Query("SELECT a FROM Account a WHERE a.enabled = true AND UPPER(a.username) like UPPER(:username) ORDER BY a.username ASC")
    Collection<Account> findAllEnabledLikeUsernameQuery(
            @Param("username") String username);

}
