package jdbc.service_db;

import jdbc.descriptionclasses.*;
import jdbc.prefs.Prefs;
import jdbc.read_file.ReadFile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private final Database database = Database.getInstance();
    private final ReadFile readFile = new ReadFile();

    public List<LongestProject> findLongestProject () throws SQLException {
        String findLongestProjectFileName = new Prefs().getString(Prefs.FIND_LONGEST_PROJECT_FILE_PATH);

        List <LongestProject> longestProjectList = new ArrayList<>();
        readFile.setSql(findLongestProjectFileName);

        for (String sql: readFile.getSql()) {
            if (sql.startsWith("USE")) {
                database.executeUpdate(sql);
                continue;
            }

            ResultSet rs = database.executeQuery(sql);

            while (rs.next()) {
                int project_id = rs.getInt("project_id");
                int monthCount = rs.getInt("month_count");
                LongestProject longestProject = new LongestProject(project_id, monthCount);
                longestProjectList.add(longestProject);
            }
        }
        return longestProjectList;
    }

    public List<MaxProjectsClient> findMaxProjectClient () throws SQLException {
        String findMaxProjectClientFileName = new Prefs().getString(Prefs.FIND_MAX_PROJECTS_CLIENT_FILE_PATH);

        List <MaxProjectsClient> maxProjectsClientsList = new ArrayList<>();
        readFile.setSql(findMaxProjectClientFileName);

        for (String sql: readFile.getSql()) {
            if (sql.startsWith("USE")) {
                database.executeUpdate(sql);
                continue;
            }

            ResultSet rs = database.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                int projectCount = rs.getInt("project_count");
                MaxProjectsClient maxProjectsClient = new MaxProjectsClient(name, projectCount);
                maxProjectsClientsList.add(maxProjectsClient);
            }
        }
        return maxProjectsClientsList;
    }

    public List<MaxSalaryClient> findMaxSalaryClient () throws Exception {
        String findMaxSalaryClientFileName = new Prefs().getString(Prefs.FIND_MAX_SALARY_WORKER_FILE_PATH);

        List<MaxSalaryClient> maxSalaryClientList = new ArrayList<>();
        readFile.setSql(findMaxSalaryClientFileName);

        for (String sql: readFile.getSql()) {
            if (sql.startsWith("USE")) {
                database.executeUpdate(sql);
                continue;
            }

            ResultSet rs = database.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                MaxSalaryClient maxSalaryClient = new MaxSalaryClient(name, salary);
                maxSalaryClientList.add(maxSalaryClient);
            }
        }
        return maxSalaryClientList;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers () throws Exception {
        String findYoungestEldestWorkersFileName = new Prefs().getString(Prefs.FIND_YOUNGEST_ELDEST_WORKERS_FILE_PATH);

        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();
        readFile.setSql(findYoungestEldestWorkersFileName);

        for (String sql: readFile.getSql()) {
            if (sql.startsWith("USE")) {
                database.executeUpdate(sql);
                continue;
            }

            ResultSet rs = database.executeQuery(sql);

            while (rs.next()) {
                String type = rs.getString("Type");
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(type, name, birthday);
                youngestEldestWorkersList.add(youngestEldestWorkers);
            }
        }
        return youngestEldestWorkersList;
    }

    public List<PrintProjectPrices> printProjectPrices () throws Exception {
        String printProjectPricesFileName = new Prefs().getString(Prefs.PRINT_PROJECT_PRICES_FILE_PATH);

        List<PrintProjectPrices> printProjectPricesList = new ArrayList<>();
        readFile.setSql(printProjectPricesFileName);

        for (String sql: readFile.getSql()) {
            if (sql.startsWith("USE")) {
                database.executeUpdate(sql);
                continue;
            }

            ResultSet rs = database.executeQuery(sql);

            while (rs.next()) {
                int projectID = rs.getInt("project_id");
                int price = rs.getInt("price");

                PrintProjectPrices printProjectPrices = new PrintProjectPrices(projectID, price);
                printProjectPricesList.add(printProjectPrices);
            }
        }
        return printProjectPricesList;
    }
}
