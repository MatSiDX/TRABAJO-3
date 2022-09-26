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

import pe.edu.upeu.clase02.entity.Detalle;
import pe.edu.upeu.clase02.service.DetalleService;

@RestController
@RequestMapping("/api/detalle")
public class DetalleController {
	
	@Autowired
	private DetalleService detalleservice;
	
	@GetMapping("/all")
	public List<Detalle> readAll(){		
		return detalleservice.readAll();
	}
	@GetMapping("/{id}")
	public Detalle read(@PathVariable int id){		
		return detalleservice.read(id);
	}
	
	@PostMapping("/save")
	public int save(@RequestBody Detalle detalle){		
		return detalleservice.create(detalle);
	}
	
	@PutMapping("/update/{id}")
    public String update(@RequestBody Detalle detalle, @PathVariable int id) {
        return detalleservice.update(detalle, id) + "SE HA REALIZADO LA MODIFICACIÓN CON ÉXITO";
    }
	
	@DeleteMapping("/del/{id}")
	public int save(@PathVariable int id){		
		return detalleservice.delete(id);
	}

}
