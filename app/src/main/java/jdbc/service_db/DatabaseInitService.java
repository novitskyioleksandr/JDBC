package jdbc.service_db;

import jdbc.prefs.Prefs;
import jdbc.read_file.ReadFile;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        DatabaseInitService.initDB(database);
    }

    public static void initDB (Database database) {
        String initDbFileName = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);

        ReadFile readFile = new ReadFile();
        readFile.setSql(initDbFileName);

        for (String sql: readFile.getSql()) {
            database.executeUpdate(sql + ";");
        }
    }
}
