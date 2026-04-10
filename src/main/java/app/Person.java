package app;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;

    private String nationalId;

    public Person(String name,  String nationalId){
        this.name = name.toUpperCase();
        this.nationalId = nationalId.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
