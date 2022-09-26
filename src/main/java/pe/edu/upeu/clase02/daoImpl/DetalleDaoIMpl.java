package pe.edu.upeu.clase02.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import pe.edu.upeu.clase02.dao.Todo;
import pe.edu.upeu.clase02.entity.Detalle;

@Component
public class DetalleDaoIMpl implements Todo<Detalle> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Detalle t) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("INSERT INTO detalle (idlibro, idprestamo) VALUES(?,?)",
				new Object[] { t.getIdlibro(), t.getIdprestamo() });
	}

	@Override
	public int update(Detalle t, int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE detalle SET idlibro=?, idprestamo=? where idprestamo=?"
	            , new Object[] {id, t.getIdlibro(), t.getIdprestamo()});
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM detalle WHERE iddetalle=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		try {
            Detalle d = jdbcTemplate.queryForObject("SELECT * FROM detalle WHERE iddetalle=?",
                    BeanPropertyRowMapper.newInstance(Detalle.class), id);
            return d;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
	}

	@Override
	public List<Detalle> readAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM detalle", BeanPropertyRowMapper.newInstance(Detalle.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
