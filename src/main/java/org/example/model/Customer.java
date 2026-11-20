package org.example.model;
public class Customer  implements Cloneable{

    private Long id;
    private String nom;
    private String email;

    // Constructeur vide
    public Customer() {
    }

    // Constructeur avec tous les attributs
    public Customer(Long id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }
}