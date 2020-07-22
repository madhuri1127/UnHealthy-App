package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SalesDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public SalesDAO(JdbcTemplate jdbcTemplate2) 
	{
		this.jdbcTemplate= jdbcTemplate2;
		
	}

	public List<Sale> list() {
		String sql = "SELECT * FROM SALES";

		List<Sale> listSale = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(Sale.class));

		return listSale;
	}
	
public List<Sale> search(String item) {
		List<Sale> listSale = null;
			String sql = "SELECT * FROM SALES where item LIKE '%"+ item + "%'";
			System.out.print(sql);
			listSale = jdbcTemplate.query(sql, 
					BeanPropertyRowMapper.newInstance(Sale.class));
			return listSale;
	}
	
	public void save(Sale sale) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("sales").usingColumns("item", "quantity", "amount");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		
		insertActor.execute(param);		
	}
	
	public Sale get(int id) {
		String sql = "SELECT * FROM SALES WHERE id ="+id;
		Object[] args = {id};
		Sale sale = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Sale.class));
		return sale;
	}
	
	public void update(Sale sale) {
		String sql = "UPDATE SALES SET item=:item, quantity=:quantity, amount=:amount WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM SALES WHERE id ="+id;
		jdbcTemplate.update(sql);
	}
}
