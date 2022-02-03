package io.helidon.example.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Access(value = AccessType.FIELD)
@Entity(name = "Department")
@Table(name = "DEPARTMENTS")
public class Department {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEPARTMENT_ID")
    private int departmentID;

    @Column(name="DEPARTMENT_NAME")
    private String departmentName;

    @Column(name="MANAGER_ID")
    private int managerID;

    @Column(name="LOCATION_ID")
    private int locationID;

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentID == that.departmentID && departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentID, departmentName);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", managerID=" + managerID +
                ", locationID=" + locationID +
                '}';
    }
}
