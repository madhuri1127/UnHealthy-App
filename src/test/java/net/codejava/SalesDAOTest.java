package net.codejava;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

class SalesDAOTest {

	private SalesDAO dao;
	@BeforeEach
	void setUp() throws Exception 
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		   datasource.setUrl("jdbc:oracle:thin:@cust-test11-ora1.vmware.com:1521:CUSTST11");
		   datasource.setUsername("XXVMSDP");
		   datasource.setPassword("hthns9nsg8");
		   datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		   
		   dao = new SalesDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Sale> listsale = dao.list();
		assertFalse(listsale.isEmpty());
	}

	@Test
	void testSearch() {
		String item = "Pen";
		List<Sale> listSale=dao.search(item);
		assertFalse(listSale.isEmpty());
	}

	@Test
	void testSave() {
		Sale sale = new Sale("Cooler Fan",1,49.99f);
		dao.save(sale);
	}

	@Test
	void testGet() {
		int id= 2;
		Sale sale = dao.get(id);
		assertNotNull(sale);

	}

	@Test
	void testUpdate() {
		Sale sale =  new Sale();
		sale.setId(41);
		sale.setItem("Notes");
		sale.setQuantity(4);
		sale.setAmount(20);
		dao.update(sale);
	}

	@Test
	void testDelete() {
		int id =5;
		dao.delete(41);
	}

}
