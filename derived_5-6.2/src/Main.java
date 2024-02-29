public class Main {
    public static void main(String[] args)
    {
        Course basic = new Course();
        basic.setNum("ECE287");
        basic.setTitle("Digital Systems Design");
        basic.printInfo();

        OfferedCourse extra = new OfferedCourse();
        extra.setNum("ECE387");
        extra.setTitle("Embedded Systems Design");
        extra.setInstructor("Mark Patterson");
        extra.setLocation("Wilson Hall 231");
        extra.setTime("WF: 2-3:30 pm");
        extra.printInfo();
    }
}
