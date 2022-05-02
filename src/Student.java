/**
 * 學生
 */
public class Student {
    /**
     * 屬性
     */
    private int seat;
    private String className;
    private String stdName;
    private int score;

    /**
     * 學生建構子
     * @param seat
     * @param className
     * @param stdName
     * @param score
     */
    public Student(int seat, String className, String stdName, int score) {
        this.seat = seat;
        this.className = className;
        this.stdName = stdName;
        this.score = score;
    }

    /**
     * 學生getter setter
     *
     */
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
