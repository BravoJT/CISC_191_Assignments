public class Course {
    private String num;
    private String title;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void printInfo()
    {
        System.out.println("Course Information:");
        System.out.println("\tCourse Number: "+num);
        System.out.println("\tCourse Title: "+title);
    }

}
class OfferedCourse extends Course{
    private String instructor;
    private String location;
    private String time;

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("\tInstructor Name: "+instructor);
        System.out.println("\tLocation: "+location);
        System.out.println("\tClass time: "+time);
    }
}
