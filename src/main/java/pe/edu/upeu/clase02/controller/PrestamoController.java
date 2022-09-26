package pe.edu.upeu.clase02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.clase02.entity.Prestamo;
import pe.edu.upeu.clase02.service.PrestamoService;

@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController {
	@Autowired
	private PrestamoService prestamoservice;
	
	@GetMapping("/all")
	public List<Prestamo> readAll(){		
		return prestamoservice.readAll();
	}
	@GetMapping("/{id}")
	public Prestamo read(@PathVariable int id){		
		return prestamoservice.read(id);
	}
	
	@PostMapping("/save")
	public int save(@RequestBody Prestamo prestamo){		
		return prestamoservice.create(prestamo);
	}
	
	@PutMapping("/update")
	public int update(@PathVariable int id, @RequestBody Prestamo prestamo){	
		Prestamo p = prestamoservice.read(id);
		p.setFecha_prestamo("2022-09-15");
		p.setFecha_devolucion("2022-09-15");
		return prestamoservice.update(p, id);
	}
	
	@DeleteMapping("/del/{id}")
	public int save(@PathVariable int id){		
		return prestamoservice.delete(id);
	}
	

}
