package com.mtr.controllers;

/*
 * 
 * 
 */

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtr.customizedexceptions.CustomizedBadRequestException;
import com.mtr.customizedexceptions.CustomizedNotFoundException;
import com.mtr.dao.AdminDAO;
import com.mtr.pojo.Addons;
import com.mtr.pojo.BookedTicketsForParticularShow;
import com.mtr.pojo.GetMovieInTheatre;
import com.mtr.pojo.Movie;
import com.mtr.pojo.MoviesListInTheatre;
import com.mtr.pojo.Theatre;
import com.mtr.pojo.MovieInTheatre;

@RestController
public class AdminController {

	@Autowired
	AdminDAO adminDAO;

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "adminLogin", method = RequestMethod.POST)
	public void validateAdmin(@RequestParam("id") String id, @RequestParam("password") String password) {
		if (!adminDAO.login(id, password)) {
			throw new CustomizedBadRequestException("USER NAME OR PASSWORD INVALID");
		}
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "addTheatre", method = RequestMethod.POST)
	public void addTheatre(@RequestBody Theatre theatre) {
		if (!adminDAO.addTheatre(theatre)) {
			throw new CustomizedBadRequestException("DETAILS ENTERED IS INVALID");
		}
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "addMovie", method = RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie) {
		if (!adminDAO.addMovie(movie)) {
			throw new CustomizedBadRequestException("DETAILS ENTERED IS INVALID");
		}
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "addAddons", method = RequestMethod.POST)
	public void addAddons(@RequestBody Addons addon) {
		if (!adminDAO.addAddon(addon)) {
			throw new CustomizedBadRequestException("DETAILS ENTERED IS INVALID!");
		}
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "addMovieInTheatre", method = RequestMethod.POST)
	public void addMovieInTheatre(@RequestBody MovieInTheatre theatreMovie) {
		if (!adminDAO.addMovieInTheatre(theatreMovie)) {
			throw new CustomizedBadRequestException("DETAILS ENTERED IS INVALID!");
		}
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "listTheatres", method = RequestMethod.GET)
	public List<Theatre> listTheatres() {
		List<Theatre> list = adminDAO.getAllTheatres();
			if (list == null) {
				throw new CustomizedNotFoundException("No theatres found");
			}
			return list;
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "listMovies", method = RequestMethod.GET)
	public List<Movie> listMovies() {
		List<Movie> list = adminDAO.getAllMovies();
			if (list == null) {
				throw new CustomizedNotFoundException("No movies found");
			}
			return list;
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "listAddons", method = RequestMethod.GET)
	public List<Addons> listAddons() {
		List<Addons> list = adminDAO.getAllAddons();
			if (list == null) {
				throw new CustomizedNotFoundException("No Addons found");
			}
			return list;
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "getMovieInTheatre", method = RequestMethod.POST)
	public List<MoviesListInTheatre> listMoviesInTheatre(@RequestBody GetMovieInTheatre getMoviesInTheatre) {
		List<MoviesListInTheatre> list = adminDAO.listMoviesInTheatre(getMoviesInTheatre);
			if (list == null) {
				throw new CustomizedNotFoundException("No movies found");
			}
			return list;
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "editMovieInTheatre", method = RequestMethod.POST)
	public void editMovieInTheatre(@RequestBody MovieInTheatre theatreMovie) {
			if(!adminDAO.editMovieInTheatre(theatreMovie))
			{
				throw new CustomizedBadRequestException("Cannnot Edit!");
			}
	}
	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "editAddon", method = RequestMethod.PUT)
	public void editAddonCost(@RequestBody Addons addon) {
			adminDAO.editAddonCost(addon);
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping(value = "getTicketCount", method = RequestMethod.POST)
	public int getTicketCount(@RequestBody BookedTicketsForParticularShow bookedTicketsForParticularShow) {
			int checker = adminDAO.getTicketCountInAParticularShow(bookedTicketsForParticularShow);
			return checker;
		}
	
	@RequestMapping(value = "editMovie", method = RequestMethod.PUT)
	public void editMovie(@RequestBody Movie movie) {
			if(!adminDAO.editMovie(movie))
			{
				throw new CustomizedBadRequestException("Cannnot Edit!");
			}
	}
	
	@RequestMapping(value = "deleteMovie/{id}", method = RequestMethod.DELETE)
	public void deleteMovie(@PathVariable  int id) {
			System.out.println(id);
			if(!adminDAO.deleteMovie(id))
			{
				throw new CustomizedBadRequestException("Cannnot delete!");
			}
	}
}
