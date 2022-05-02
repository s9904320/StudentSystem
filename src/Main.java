import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean systemContinue = true; //判斷系統停止
        boolean haveData = false; //是否有資料
        boolean isNum = false;  //是否為數字
        SudentArray studentArr = new SudentArray(null);  //學生陣列
        Student studentInfo; //學生資訊
        int studentCount = 0;  //學生數量
        int option = 0;  //使用者選擇
        int seat = 0;  //座號
        int score = 0;  //分數
        String className = "";  //班級名稱
        String studentName = " ";  //學生名稱
        String tmpStr = " ";  //字串 檢查用
        do {
            System.out.println("請選擇功能:");
            System.out.println("1:新增一個學生");
            System.out.println("2:印出指定\"座號\"的學生成績");
            System.out.println("3:依照成績由大到小排序學生");
            System.out.println("4:依照座號由小到大排序學生");
            System.out.println("5:更改指定\"座號\"的學生成績");
            System.out.println("6:結束程式");

            option = sc.nextInt();
            switch (option) {
                case 1: //新增學生
                    haveData = false;
                    sc.nextLine();
                    System.out.println("請輸入班級");
                    className = sc.nextLine();
                    System.out.println("請輸入座號");
                    tmpStr = sc.nextLine();
                    isNum = isNumeric(tmpStr);//判斷是否為數字
                    if (isNum) {
                        seat = Integer.parseInt(tmpStr);
                        studentInfo = studentArr.searchStudentBySeat(seat);//透過座號查詢學生
                        if (studentInfo != null) {
                            System.out.println("已有相同座號");
                            break;
                        }
                        else {  //新建學生資訊
                            System.out.println("請輸入姓名");
                            studentName = sc.nextLine();
                            System.out.println("請輸入成績");
                            tmpStr = sc.nextLine();
                            isNum = isNumeric(tmpStr);//判斷是否為數字
                            if (isNum) {
                                score = Integer.parseInt(tmpStr);
                                studentInfo = new Student(seat,className,studentName,score);
                                studentArr.addStudent(studentInfo,studentCount);
                                studentCount++;
                            } else {
                                System.out.println("輸入非數字");
                            }
                        }
                    } else {
                        System.out.println("輸入非數字");
                    }
                    break;
                case 2: //指定座號的成績
                    sc.nextLine();
                    haveData = false;
                    System.out.println("請輸入座號");
                    tmpStr = sc.nextLine();
                    isNum = isNumeric(tmpStr); //判斷是否為數字
                    if (isNum) {
                        seat = Integer.parseInt(tmpStr);
                        studentInfo = studentArr.searchStudentBySeat(seat); //透過座號查詢學生
                        if (studentInfo == null) {
                            System.out.println("查無此座號");
                        }else {
                            System.out.println(" 座號: " + studentInfo.getSeat() + " 姓名: " + studentInfo.getStdName() + " 班級: " + studentInfo.getClassName() + "分數: " + studentInfo.getScore());
                        }
                    } else {
                        System.out.println("輸入非數字");
                    }
                    break;
                case 3: //由大到小排序成績
                    for (int i = 0; i < studentCount - 1; i++) {
                        for (int j = i + 1; j < studentCount; j++) {
                            if (studentArr.mappingStudent(i).getScore() < studentArr.mappingStudent(j).getScore()) {
                                Student tmp = studentArr.mappingStudent(i);
                                studentArr.fixStudent(i,studentArr.mappingStudent(j));
                                studentArr.fixStudent(j,tmp);
                            }
                        }
                    }
                    for (int i = 0; i < studentCount; i++) {
                        System.out.println("分數: " + studentArr.mappingStudent(i).getScore() + " 座號: " + studentArr.mappingStudent(i).getSeat() + " 姓名: " + studentArr.mappingStudent(i).getStdName() + " 班級: " + studentArr.mappingStudent(i).getClassName());
                    }
                    break;
                case 4://由小到大排序座號
                    for (int i = 0; i < studentCount - 1; i++) {
                        for (int j = i + 1; j < studentCount; j++) {
                            if (studentArr.mappingStudent(i).getSeat() >studentArr.mappingStudent(j).getSeat()) {
                                Student tmp = studentArr.mappingStudent(i);
                                studentArr.fixStudent(i,studentArr.mappingStudent(j));
                                studentArr.fixStudent(j,tmp);
                            }
                        }
                    }
                    for (int i = 0; i < studentCount; i++) {
                        System.out.println("座號: " + studentArr.mappingStudent(i).getSeat() + " 姓名: " + studentArr.mappingStudent(i).getStdName() + " 分數: " + studentArr.mappingStudent(i).getScore() + "班級: " + studentArr.mappingStudent(i).getClassName());
                    }
                    break;
                case 5://更改指定座號的成績
                    sc.nextLine();
                    haveData = false;
                    System.out.println("請輸入座號");
                    tmpStr = sc.nextLine();
                    isNum = isNumeric(tmpStr);//判斷是否為數字
                    if (isNum) {
                        seat = Integer.parseInt(tmpStr);
                        studentInfo = studentArr.searchStudentBySeat(seat);//透過座號查詢學生
                        if(studentInfo != null){
                            for (int i = 0; i < studentCount; i++) {
                                if (studentArr.mappingStudent(i).getSeat() == seat) {
                                    System.out.println("請輸入修改後成績");
                                    score = sc.nextInt();
                                    studentArr.mappingStudent(i).setScore(score);
                                    System.out.println("座號" + studentArr.mappingStudent(i).getSeat() + "修改後分數為" + studentArr.mappingStudent(i).getScore());
                                    haveData = true;
                                    break;
                                }
                            }
                        }
                        else  {
                            System.out.println("查無此座號");
                        }
                    } else {
                        System.out.println("輸入非數字");
                    }
                    break;
                case 6: //關閉程式
                    systemContinue = false;
                    break;
            }
        } while (systemContinue);
    }

    /**
     * 判斷是否為數字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
