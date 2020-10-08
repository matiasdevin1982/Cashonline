package com.init.matiasdevin.demo.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.init.matiasdevin.demo.entidades.Loans;
import com.init.matiasdevin.demo.entidades.Usuarios;
import com.init.matiasdevin.demo.repositorio.Servicioloans;
import com.init.matiasdevin.demo.repositorio.Serviciousuarios;
import com.init.matiasdevin.demo.response.ResponseLoans;

@RestController
public class ServiciosRest {

	@Autowired
	private Serviciousuarios serviciousuarios;

	@Autowired
	private Servicioloans servicioloans;

	// Creamos el medoto usuarios via GET todos
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public ResponseEntity<List<Usuarios>> getUsuarios() {
		List<Usuarios> usuarios = serviciousuarios.findAll();
		return ResponseEntity.ok(usuarios);
	}

	// Creamos el medoto usuarios via GET
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuarios> getUsuariosById(@PathVariable("id") Integer id) {
		Optional<Usuarios> optionalusuario = serviciousuarios.findById(id);
		if (optionalusuario.isPresent()) {
			return ResponseEntity.ok(optionalusuario.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// Creamos el medoto agregar usuario (POST)
	@RequestMapping(value = "users", method = RequestMethod.POST)
	public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuarios) {
		Usuarios newUsuario = serviciousuarios.save(usuarios);
		return ResponseEntity.ok(newUsuario);
	}

	// Creamos el medoto borrar usuario (DELETE)
	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> borrarUsuario(@PathVariable("id") Integer id) {
		serviciousuarios.deleteById(id);
		return ResponseEntity.ok(id + " Borrado");
	}

	
	// Creamos el medoto borrar credito (DELETE)
	@RequestMapping(value = "loans/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> borrarCredito(@PathVariable("id") Integer id) {
		servicioloans.deleteById(id);
		return ResponseEntity.ok(id + " Credito Borrado");
	}

	@RequestMapping(value = "loans", method = RequestMethod.GET)
	public ResponseLoans getLoans(@RequestParam(value = "size", required = true) Integer size,
			@RequestParam(value = "page", required = true) Integer pagination,
			@RequestParam(value = "user_id", required = false) Integer userId) {

		ResponseLoans lresult = new ResponseLoans();

		int offset = (pagination - 1) * size;
		List<Loans> listado;

		if (userId == null) {
			listado = getLoans(size, offset);
			lresult.paging.total = countLoans();

		} else {
			listado = getLoansWUserId(size, offset, userId);
			lresult.paging.total = countLoansByUserId(userId);
		}

		lresult.items = listado;
		lresult.paging.page = pagination;
		lresult.paging.size = size;

		return lresult;

	}


	public long countLoans() {
		return servicioloans.count();
	}

	public long countLoansByUserId(Integer userId) {
		return servicioloans.countLoansByUserId(userId);
	}

	public List<Loans> getLoans(int size, int offset) {
		return servicioloans.findLoans(offset, size);
	}

	public List<Loans> getLoansWUserId(int size, int offset, int userId) {
		return servicioloans.findLoansByUserId(userId, offset, size);
	}



	public Usuarios getById(int id) {
		Optional<Usuarios> user = serviciousuarios.findById(id);

		if (user.isPresent())
			return user.get();

		return null;
	}
}
