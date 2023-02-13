package jdbc.descriptionclasses;

public class LongestProject {
    private int project_id;
    private int month_count;

    public LongestProject(int project_id, int month_count) {
        this.project_id = project_id;
        this.month_count = month_count;
    }

    public int getProject_id() {
        return project_id;
    }

    public int getMonth_count() {
        return month_count;
    }
}
