package pe.edu.upeu.clase02.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import pe.edu.upeu.clase02.dao.Todo;
import pe.edu.upeu.clase02.entity.Prestamo;

@Component
public class PrestamoDaolMpl implements Todo<Prestamo> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Prestamo t) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, idempleado, idalumno) VALUES (?,?,?,?)",
				new Object[] { t.getFecha_prestamo(), t.getFecha_devolucion(), t.getIdempleado(), t.getIdalumno() });
	}

	@Override
	public int update(Prestamo t, int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"UPDATE prestamo SET fecha_prestamo=?, fecha_devolucion=?, idempleado=?,idalumno=? where idprestamo=?;",
				new Object[] { t.getFecha_prestamo(), t.getFecha_devolucion(), t.getIdempleado(), t.getIdalumno(), id});
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM prestamo WHERE idprestamo=?", id);
	}

	@Override
	public Prestamo read(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM PRESTAMO WHERE idprestamo=?",
				new BeanPropertyRowMapper<Prestamo>(Prestamo.class), id);
	}

	@Override
	public List<Prestamo> readAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM PRESTAMO", new BeanPropertyRowMapper<Prestamo>(Prestamo.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
