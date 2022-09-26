package pe.edu.upeu.clase02.dao;

import java.util.List;
import java.util.Map;

public interface Todo<T> {
  int create (T t);
  int update (T t, int id);
  int delete(int id);
  T read(int id);
  List<T> readAll();
  List<Map<String,Object>> readAll2();
}
