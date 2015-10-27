package org.example.ws.web.api;

import java.util.Collection;
import java.util.Date;

import org.example.ws.model.Role;
import org.example.ws.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The RoleController class is a RESTful web service controller. The
 * <code>@RestController</code> annotation informs Spring that each
 * <code>@RequestMapping</code> method returns a <code>@ResponseBody</code>.
 * 
 * Note: This controller class was created for demonstration and testing
 * purposes. Typically, a Repository is not wired directly into a Controller,
 * but rather into a Service component which encapsulates the Repository
 * behaviors.
 * 
 * @author Matt Warman
 */
@RestController
public class RoleController extends BaseController {

    /**
     * The Spring Data JPA Repository for the Role entity model class.
     */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Web service endpoint to fetch all Role entities. The service returns the
     * collection of entities as JSON.
     * 
     * @return A ResponseEntity containing a collection of Role objects.
     */
    @RequestMapping(
            value = "/api/roles",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Role>> getRoles() {

        Collection<Role> roles = roleRepository.findAllEffective(new Date());

        return new ResponseEntity<Collection<Role>>(roles, HttpStatus.OK);
    }

}
