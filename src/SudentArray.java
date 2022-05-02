/**
 * 學生陣列
 */
public class SudentArray {
    /**
     * 屬性
     */
    private Student[] students;

    /**
     * 建構子
     * @param students
     */
    public SudentArray(Student[] students) {
        this.students = students;
    }

    /**
     * 新增學生
     * @param student
     * @param studentCount
     */
    public void addStudent(Student student, int studentCount) {
            if(students == null){
                this.students = new Student[1];
            }
        if (studentCount == students.length) {
            students = doubleArr(students);
        }
        students[studentCount] = student;
    }

    /**
     *修改學生
     * @param number
     * @param studentInfo
     */
    public void fixStudent(int number, Student studentInfo){
        students[number] = studentInfo;
    }

    /**
     * 透過座號搜尋學生
     * @param seat
     * @return 回傳學生 沒有則Null
     */
    public Student searchStudentBySeat(int seat) {
        boolean haveData = false;
        int studentNum = 0;
        if(students == null){
            haveData = false;
        }else {
            for (int i = 0; i < students.length; i++) {
                if (seat == students[i].getSeat()) {
                    studentNum = i;
                    haveData = true;
                    break;
                }
            }
        }

        if (haveData) {
            return students[studentNum];
        } else {
            return null;
        }
    }

    /**
     * 透過編號尋找學生
     * @param number
     * @return
     */
    public Student mappingStudent(int number){
        return students[number];
    }

    /**
     * 擴充陣列空間
     * @param students
     * @return
     */
    public Student[] doubleArr(Student[] students) {
        Student[] newArr = new Student[students.length * 2];
        for (int i = 0; i < students.length; i++) {
            newArr[i] = students[i];
        }
        return newArr;
    }
}
