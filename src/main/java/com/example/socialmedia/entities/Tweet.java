package com.example.socialmedia.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tweets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id")
	private int tweet_id;
    @Column(name = "tweet_user_name")
	private String tweet_user_name;
    @Column(name = "tweet_text")
    private String tweet_text;
    @Column(name = "tweet_date")
    private String tweet_date;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
   
  
}
