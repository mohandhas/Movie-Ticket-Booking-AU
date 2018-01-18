package com.mtr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtr.customizedexceptions.CustomizedNotFoundException;
import com.mtr.dao.AdminDAO;
import com.mtr.pojo.GetMoviesInTheatre;
import com.mtr.pojo.Movie;
import com.mtr.pojo.MoviesListInTheatre;
import com.mtr.pojo.Theatre;
import com.mtr.pojo.TheatreMovie;

@RestController
public class AdminController {
	
	@Autowired
	AdminDAO adminDAO;
	
	@RequestMapping(value= "adminLogin", method=RequestMethod.POST)
	public void validateAdmin(@RequestParam("id") String id,@RequestParam("password") String password)
	{		
			if(adminDAO.login(id, password))
			{
				System.out.println("YES"); 
			}
			else
			{
				System.out.println("NO");

			}
	}
	
	@RequestMapping(value= "addTheatre", method=RequestMethod.POST)
	public void addTheatre(@RequestBody Theatre theatre) 
	{
		if(!adminDAO.addTheatre(theatre))
		{
			throw new CustomizedNotFoundException("Check your details");
		}
	}
	
	@RequestMapping(value= "addMovie", method=RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie)
	{
		adminDAO.addMovie(movie);
	}
	
	@RequestMapping(value= "listTheatres", method=RequestMethod.GET)
	public List<Theatre> listTheatres()
	{
		return adminDAO.getAllTheatres();
	}
	
	@RequestMapping(value= "listMovies", method=RequestMethod.GET)
	public List<Movie> listMovies()
	{
		return adminDAO.getAllMovies();
	}
	
	@RequestMapping(value= "addMovieInTheatre", method=RequestMethod.POST)
	public void addMovieInTheatre(@RequestBody TheatreMovie theatreMovie)
	{
		 adminDAO.addMovieInTheatre(theatreMovie);
	}
	
	@RequestMapping(value= "getMovieInTheatre", method=RequestMethod.POST)
	public List<MoviesListInTheatre> listMoviesInTheatre(@RequestBody GetMoviesInTheatre getMoviesInTheatre)
	{
		 return adminDAO.listMoviesInTheatre(getMoviesInTheatre);
	}
	
	@RequestMapping(value= "editMovieInTheatre", method=RequestMethod.POST)
	public void editMovieInTheatre(@RequestBody TheatreMovie theatreMovie)
	{
		 adminDAO.editMovieInTheatre(theatreMovie);
	}
}


