package jdbc.service_db;

import jdbc.prefs.Prefs;
import jdbc.read_file.ReadFile;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        DatabasePopulateService.populateDb(database);
    }

    public static void populateDb(Database database) {
        String populateDbFileName = new Prefs().getString(Prefs.POPULATE_DB_SQL_FILE_PATH);

        ReadFile readFile = new ReadFile();
        readFile.setSql(populateDbFileName);

        for (String sql: readFile.getSql()) {
            database.executeUpdate(sql + ";");
        }
    }
}
