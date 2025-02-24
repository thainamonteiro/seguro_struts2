package br.com.phellipe.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.phellipe.entity.Seguro;

public class SeguroDao extends Dao implements IDao<Seguro> {

	@Override
	public void create(Seguro obj) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("insert into seguros values (null, ?, ?)");
			stmt.setString(1, obj.getNome());
			stmt.setDouble(2, obj.getValor());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	@Override
	public Seguro findById(Long id) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("select * from seguros where id_seguro = ?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			Seguro seg = null;
			if (rs.next()) {
				seg = new Seguro();
				seg.setId(rs.getLong(1));
				seg.setNome(rs.getString(2));
				seg.setValor(rs.getDouble(3));
			}
			return seg;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}
	}

	@Override
	public List<Seguro> findAll()  {
		try {
			open();
			List<Seguro> seguros = new ArrayList<Seguro>();
			stmt = con.prepareStatement("select * from seguros");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Seguro seg = new Seguro();
				seg.setId(rs.getLong(1));
				seg.setNome(rs.getString(2));
				seg.setValor(rs.getDouble(3));
				seguros.add(seg);
			}
			return seguros;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Seguro obj) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("update seguros set nomeSeguro=?, valorSeguro=? where id_seguro=?");
			stmt.setString(1, obj.getNome());
			stmt.setDouble(2, obj.getValor());
			stmt.setLong(3, obj.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	@Override
	public void delete(Long id) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("delete from seguros where id_seguro=?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
