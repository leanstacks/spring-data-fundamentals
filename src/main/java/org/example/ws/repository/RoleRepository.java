package org.example.ws.repository;

import java.util.Collection;
import java.util.Date;

import org.example.ws.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * The RoleRepository interface is a Spring Data JPA data repository for Role
 * entities. The RoleRepository provides all the data access behaviors exposed
 * by <code>JpaRepository</code> and additional custom behaviors may be defined
 * in this interface.
 * 
 * @author Matt Warman
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Query for a collection of Role entities by the effectiveAt and expiresAt
     * attribute values. Order the collection by the value of the ordinal
     * attribute.
     * 
     * Uses the Query Method approach to search the database.
     * 
     * @param effectiveAt A Date effectiveAt attribute value.
     * @param expiresAt A Date expiresAt attribute value.
     * @return A Collection of Role entity model classes.
     */
    Collection<Role> findByEffectiveAtBeforeAndExpiresAtAfterOrExpiresAtNullOrderByOrdinalAsc(
            Date effectiveAt, Date expiresAt);

    /**
     * Query for a collection of Role entities by the effectiveAt and expiresAt
     * attribute values. Order the collection by the value of the ordinal
     * attribute.
     * 
     * Uses a Query annotated JPQL statement to search the database.
     *
     * @param effectiveAt A Date effectiveAt attribute value.
     * @return A Collection of Role entity model classes.
     */
    @Query("SELECT r FROM Role r WHERE r.effectiveAt <= :effectiveAt AND (r.expiresAt IS NULL OR r.expiresAt > :effectiveAt) ORDER BY r.ordinal ASC")
    Collection<Role> findAllEffective(@Param("effectiveAt") Date effectiveAt);

    /**
     * Query for a single Role entity by the code, effectiveAt, and expiresAt
     * attribute values.
     * 
     * Uses the Query Method approach to search the database.
     * 
     * @param code A String code attribute value.
     * @param effectiveAt A Date effectiveAt attribute value.
     * @param expiresAt A Date expiresAt attribute value.
     * @return A Role object or <code>null</code> if not found.
     */
    Role findByCodeAndEffectiveAtBeforeAndExpiresAtAfterOrExpiresAtNull(
            String code, Date effectiveAt, Date expiresAt);

    /**
     * Query for a single Role entity by the code, effectiveAt, and expiresAt
     * attribute values.
     * 
     * Uses a Query annotated JPQL statement to search the database.
     * 
     * @param code A String code attribute value.
     * @param effectiveAt A Date effectiveAt attribute value.
     * @return A Role object or <code>null</code> if not found.
     */
    @Query("SELECT r FROM Role r WHERE r.code = :code AND r.effectiveAt <= :effectiveAt AND (r.expiresAt IS NULL OR r.expiresAt > :effectiveAt)")
    Role findByCodeAndEffective(@Param("code") String code,
            @Param("effectiveAt") Date effectiveAt);

}
