package com.hanen.site.de.vente.priv.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.ToString;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@ToString
public class Client {
	
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)  

	private long clt_id;

	@NotEmpty(message = "Required!")
    @Column(name="nom")
	private String nom;
    @NotEmpty(message = "Required!")
    @Column(name="prenom")
    
    @NotEmpty(message = "Required!")
	private String prenom;
    @NotEmpty(message = "Required!")
	private String email;
    @NotEmpty(message = "Required!")
	private long telephone ;
    
    @NotEmpty(message = "Required!")
	private String mdp;
        private String role;
    

    public Client() {
    }
    
    public Client(@NotEmpty(message = "Required!") String nom,
			@NotEmpty(message = "Required!") @NotEmpty(message = "Required!") String prenom,
			@NotEmpty(message = "Required!") String email, @NotEmpty(message = "Required!") long telephone,
			@NotEmpty(message = "Required!") String mdp, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.mdp = mdp;
		this.role = role;
	}
	
    
    
	public long getClt_id() {
		return clt_id;
	}
	public void setClt_id(long clt_id) {
		this.clt_id = clt_id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	 

}
