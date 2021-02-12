package DefiningClasses.Ex07Google;

public class Parents {
    private String parentName;
    private String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setParentBirthday(String parentBirthday) {
        this.parentBirthday = parentBirthday;
    }
    @Override
    public String toString() {
        return this.parentName + " " + this.parentBirthday;
    }
}
