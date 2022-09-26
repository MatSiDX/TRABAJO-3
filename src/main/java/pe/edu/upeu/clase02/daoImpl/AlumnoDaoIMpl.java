package pe.edu.upeu.clase02.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import pe.edu.upeu.clase02.dao.Todo;
import pe.edu.upeu.clase02.entity.Alumno;

@Component
public class AlumnoDaoIMpl implements Todo<Alumno> {
	
	@AutoConfigureOrder
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Alumno t) {
		String SQL = "INSERT INTO alumno(codigo, nombre, apellido_pat, apellido_mat) VALUES(?, ?, ?))";
		return jdbcTemplate.update(SQL, t.getCodigo(), t.getNombre(), t.getApellido_pat(), t.getApellido_mat());
	}

	@Override
	public int update(Alumno t, int id) {
		String SQL = "UPDATE alumno(codigo, nombre, apellido_pat, apellido_mat) where idalumno=?)";
		return jdbcTemplate.update(SQL,id,  t.getCodigo(), t.getNombre(), t.getApellido_pat(), t.getApellido_mat());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM alumno WHERE idalumno=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Alumno read(int id) {
		// TODO Auto-generated method stub
				try {
					Alumno a = jdbcTemplate.queryForObject("SELECT * FROM alumno WHERE idalumno=?",
							BeanPropertyRowMapper.newInstance(Alumno.class), id);
					return a;
				} catch (IncorrectResultSizeDataAccessException e) {
					return null;
				}
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from Alumno", BeanPropertyRowMapper.newInstance(Alumno.class)) ;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
	

	

}

