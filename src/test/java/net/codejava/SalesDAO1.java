package net.codejava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class SalesDAO1 {

	@Autowired
	private SalesDAO dao;
	@BeforeEach
	public void setUp() throws Exception 
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		   datasource.setUrl("jdbc:oracle:thin:@cust-test11-ora1.vmware.com:1521:CUSTST11");
		   datasource.setUsername("XXVMSDP");
		   datasource.setPassword("hthns9nsg8");
		   datasource.setDriverClassName("oracle.jdbc.OracleDriver");		   
		   dao = new SalesDAO(new JdbcTemplate(datasource));
	}

	@Test
	public void testList() {
		List<Sale> listsale = dao.list();
		assertFalse(listsale.isEmpty());
	}

	@Test
	public void testSearch() {
		//String item = "Pen";
		List<Sale> listSale=dao.search("Pen");
		assertFalse(listSale.isEmpty());
	}

	@Test
	public void testSave() {
		Sale sale = new Sale("Cooler Fan",1,49.99f);
		dao.save(sale);
	}

	@Test
	public void testGet() {
		int id= 2;
		Sale sale = dao.get(id);
		assertNotNull(sale);

	}

	@Test
	public void testUpdate() {
		Sale sale =  new Sale();
		sale.setId(2);
		sale.setItem("Pen");
		sale.setQuantity(100);
		sale.setAmount(100);
		dao.update(sale);
	}

	@Test
	public void testDelete() {
		int id =17;
		dao.delete(id);
	}

}
