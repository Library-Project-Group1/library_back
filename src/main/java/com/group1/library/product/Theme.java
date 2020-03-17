package com.group1.library.product;

<<<<<<< HEAD

import javax.persistence.*;
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
>>>>>>> 5f257d040080ce2dc1c8867dbb1baee88b3e0239
import java.io.Serializable;

@Entity
@Table(name = "themes")
public class Theme implements Serializable {


<<<<<<< HEAD
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
>>>>>>> 5f257d040080ce2dc1c8867dbb1baee88b3e0239
    private String name;

    public Theme() {
    }


    public Theme(String name) {
        this.name=name;
    }
    @Override
    public String toString(){
        return ("Theme :"+this.id+"°) "+this.name);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

