package io.helidon.example.jpa.dao;

import io.helidon.example.jpa.model.Department;
import io.helidon.example.jpa.util.DBProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class DepartmentDAO {

    private EntityManager em;

    @Inject
    public DepartmentDAO(DBProvider dbProvider) {
        em = dbProvider.getEntityManager();
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = em.createNativeQuery("SELECT * FROM DEPARTMENTS").getResultList();
        return departments;
    }

    public Department getDepartmentById(int id) {
        Department department = (Department) em.createNativeQuery("SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?", Department.class)
                .setParameter(1, id).getSingleResult();
        return department;
    }

    public Department getDepartmentByName(String name) {
        Department department = (Department) em.createNativeQuery("SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_NAME = ?", Department.class)
                .setParameter(1, name).getSingleResult();
        return department;
    }

    public List<Department> getDepartmentsByLocation(int locationId) {
        List<Department> departments = em.createNativeQuery("SELECT * FROM DEPARTMENTS WHERE LOCATION_ID = ?").setParameter(1, locationId).getResultList();
        return departments;
    }
}
