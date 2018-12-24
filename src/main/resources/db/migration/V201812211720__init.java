package db.migration;

import javax.sql.DataSource;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class V201812211720__init implements SpringJdbcMigration{
	/**
	 * 使用JdbCTemplate以編程方式更改數據庫狀態
	 * @param jdbcTemplate
	 * @throws Exception 
	 */
	@Override
	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {

		jdbcTemplate.setDataSource(this.dataSource());
		jdbcTemplate.execute("CREATE TABLE test.friend2( "
			+ "id integer PRIMARY KEY, "
			+ "name VARCHAR NOT NULL"
			+ ") WITH ( OIDS=FALSE );");
//		jdbcTemplate.execute("INSERT INTO test.department (id, name) VALUES (3, 'gigi');");
	}

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().url("jdbc:postgresql://localhost:5432/school")
			.driverClassName("org.postgresql.Driver")
			.username("test")
			.password("+++").build();
	}
}
