package pe.edu.upeu.clase02.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import pe.edu.upeu.clase02.dao.Todo;
import pe.edu.upeu.clase02.entity.Empleado;

@Component
public class EmpleadoDaolMpl implements Todo<Empleado> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Empleado t) {
		String SQL = "INSERT INTO empleado(usuario, clave, estado) VALUES(?,?,?))";
		return jdbcTemplate.update(SQL, t.getUsuario(), t.getClave(), t.getEstado());
	}

	@Override
	public int update(Empleado t, int id) {
		String SQL = "UPDATE empleado(usuario, clave, estado) where idempleado=?";
		return jdbcTemplate.update(SQL, t.getUsuario(), t.getClave(), t.getEstado());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM empleado WHERE idempleado=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Empleado read(int id) {
		// TODO Auto-generated method stub
				try {
					Empleado e = jdbcTemplate.queryForObject("SELECT * FROM empleadoWHERE idempleado=?",
							BeanPropertyRowMapper.newInstance(Empleado.class), id);
					return e;
				} catch (IncorrectResultSizeDataAccessException e) {
					return null;
				}
	}

	@Override
	public List<Empleado> readAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from empleado", BeanPropertyRowMapper.newInstance(Empleado.class)) ;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	

}
