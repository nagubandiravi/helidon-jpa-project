package io.helidon.example.jpa.resource;

import io.helidon.example.jpa.dao.DepartmentDAO;
import io.helidon.example.jpa.model.Department;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/department")
public class DepartmentResource {

    @Inject
    DepartmentDAO departmentDAO;

    @GET
    @Path("/all")
    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @GET
    @Path("/id/{id}")
    public Department getDepartmentById(@PathParam("id") int id) {
        return departmentDAO.getDepartmentById(id);
    }

    @GET
    @Path("/name/{name}")
    public Department getDepartmentByName(@PathParam("name") String name) {
        return departmentDAO.getDepartmentByName(name);
    }

    @GET
    @Path("/locationid/{locationid}")
    public List<Department> getDepartmentsByLocation(@PathParam("locationid") int locationId) {
        return departmentDAO.getDepartmentsByLocation(locationId);
    }
}
