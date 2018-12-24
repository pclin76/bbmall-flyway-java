package db.migration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

public class V201812211700__init implements JdbcMigration {

	/**
	 * 更改資料庫結構
	 *
	 * @param connection
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("ConvertToTryWithResources")
	public void migrate(Connection connection) throws Exception {
		final PreparedStatement preparedStatement = connection.prepareStatement(
			"CREATE TABLE table1("
			+ "\"id\" INTEGER PRIMARY KEY,"
			+ "\"name\" VARCHAR NOT NULL"
			+ ");"
		);

		try {
			preparedStatement.execute();
		} finally {
			preparedStatement.close();
		}
	}
}
