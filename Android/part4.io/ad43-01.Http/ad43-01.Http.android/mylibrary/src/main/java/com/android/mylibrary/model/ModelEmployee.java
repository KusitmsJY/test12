package com.android.mylibrary.model;

import java.util.Date;
import java.util.List;



public class ModelEmployee {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<String> roles;
    private ModelDepartment department; // ModelDepartment reference

    public Integer getId()
    {
       return id;
    }
    public void setId(Integer id)
    {
       this.id = id;
    }
    public String getFirstName()
    {
       return firstName;
    }
    public void setFirstName(String firstName)
    {
       this.firstName = firstName;
    }
    public String getLastName()
    {
       return lastName;
    }
    public void setLastName(String lastName)
    {
       this.lastName = lastName;
    }
    public List<String> getRoles()
    {
       return roles;
    }
    public void setRoles(List<String> roles)
    {
       this.roles = roles;
    }
     
    @Override
    public String toString() {

       return "ModelEmployee [id=" + id + ", firstName=" + firstName + ", " +
             "lastName=" + lastName + ", roles=" + roles + "]";
    }

    public ModelEmployee(){
    }

    public ModelEmployee(Integer id, String firstName, String lastName, Date birthDate){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}