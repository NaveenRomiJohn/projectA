package com.chainsys.springproject.beans;

public class Movie {
	public String title;
	public String director;
	public Movie(String filmTitle, String filmDirector) {
		title=filmTitle; //this.title=filmTitle
		director=filmDirector; //this.director=filmDirector
		System.out.println("Movie Name     :"+title);
		System.out.println("Movie Director :"+director);
	}
}
