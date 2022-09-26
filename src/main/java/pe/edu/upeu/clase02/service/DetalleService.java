package pe.edu.upeu.clase02.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.clase02.dao.Todo;
import pe.edu.upeu.clase02.daoImpl.DetalleDaoIMpl;
import pe.edu.upeu.clase02.entity.Detalle;

@Service
public class DetalleService implements Todo<Detalle> {

	@Autowired
	private DetalleDaoIMpl daoIMpl;

	@Override
	public  int create(Detalle t) {
		// TODO Auto-generated method stub
		return daoIMpl.create(t);
	}

	@Override
	public int update(Detalle t, int id) {
		// TODO Auto-generated method stub
		return daoIMpl.update(t, id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return daoIMpl.delete(id);
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		return daoIMpl.read(id);
	}

	@Override
	public List<Detalle> readAll() {
		// TODO Auto-generated method stub
		return daoIMpl.readAll();
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return daoIMpl.readAll2();
	}

}

