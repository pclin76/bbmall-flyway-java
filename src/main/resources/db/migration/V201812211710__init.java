package db.migration;

import javax.sql.DataSource;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class V201812211710__init implements SpringJdbcMigration{
	/**
	 * 使用 JdbCTemplate 以 coding 方式更改資料庫狀態(結構、資料)
	 * @param jdbcTemplate
	 * @throws Exception 
	 */
	@Override
	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {

		jdbcTemplate.setDataSource(this.dataSource());
		jdbcTemplate.execute("CREATE TABLE test.friend1( "
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
