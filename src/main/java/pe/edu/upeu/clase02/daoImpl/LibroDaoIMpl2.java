package pe.edu.upeu.clase02.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import pe.edu.upeu.clase02.dao.Todo;
import pe.edu.upeu.clase02.entity.Libro;

@Component
public class LibroDaoIMpl2 implements Todo<Libro> {
	
	@AutoConfigureOrder
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Libro t) {
		String SQL = "INSERT INTO alumno(nombre_libro, autor, editorial) VALUES(?, ?,?))";
		return jdbcTemplate.update(SQL, t.getNombre_libro(), t.getAutor(), t.getEditorial());
	}

	@Override
	public int update(Libro t, int id) {
		String SQL = "UPDATE alumno(nombre_libro, autor, editorial) where idlibro=?)";
		return jdbcTemplate.update(SQL, t.getNombre_libro(), t.getAutor(), t.getEditorial());
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM libro WHERE idlibro=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Libro read(int id) {
		// TODO Auto-generated method stub
				try {
					Libro l = jdbcTemplate.queryForObject("SELECT * FROM libro WHERE idlibro=?",
							BeanPropertyRowMapper.newInstance(Libro.class), id);
					return l;
				} catch (IncorrectResultSizeDataAccessException e) {
					return null;
				}
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from Libro", BeanPropertyRowMapper.newInstance(Libro.class)) ;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}	

	

}

