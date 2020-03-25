package com.group1.library.entity;
import com.group1.library.entity.Transaction;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;


    //CONSTRUCTOR
    public User(){
    }

    public User(String email,String password){
        this.email=email;
        this.password=password;
    }

   public User(Long id,String email,String password){
        this.id=id;
        this.email=email;
        this.password=password;
    }

    //METHODS
    @Override
    public String toString(){
        return (this.id+"°) "+" USER : "+this.email);
    }

    //GETTER & SETTER
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
