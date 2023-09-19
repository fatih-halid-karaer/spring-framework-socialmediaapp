package com.example.socialmedia.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
		private int user_id;
	    @Column(name = "user_name")
		private String user_name;
	    @Column(name = "user_bio")
	    private String user_bio;
	    @Column(name = "user_followers")
	    private int user_followers;
	    @Column(name = "user_follows")
	    private int user_follows;
	    @Column(name = "user_mail")
	    private String user_mail;
	    
	    @OneToMany(mappedBy = "user")
	    private List<Tweet> tweets;
	    @ManyToOne
	    @JoinColumn(name = "admin_id")
	    private Admin admin;
}
