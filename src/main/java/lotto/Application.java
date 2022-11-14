package lotto;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {

    static Lotto lotto;
    static String stringTotal;
    static List<String> inputNumber = new ArrayList<>();
    static String stringBonus;
    static int lottoCnt;
    static int total;
    static List<Integer> collectCnt = new ArrayList<>();
    static Integer collectBonnusCnt = 0;
    static int[] resultArr = new int[4];

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        userInput();
        System.out.println(",");
        기능_테스트();
    }

    public static void lottoCheck() {
        int lt = 0;
        boolean bonus = false;
        for (Integer i : lotto.getNumber()) {
            for (String j : inputNumber) {
                if (i == Integer.parseInt(j)){
                    lt++;
                    break;
                }
            }
            if (i == Integer.parseInt(stringBonus)){
                bonus = true;
                break;
            }
        }
        if(lt == 5 && bonus) collectBonnusCnt++;
        collectCnt.add(lt);
    }

    public static void userInput() {
        String[] str = new String[6];
        stringTotal = 예외_테스트();
        str = readLine().split(",");
        for (int i = 0; i < str.length; i++) {
            inputNumber.add(str[i]);
        }
        stringBonus = readLine();
        total = Integer.parseInt(stringTotal);
        lottoCnt = total / 1000;
        System.out.print("[\"" + lottoCnt + "개를 구매했습니다.\"");
    }

    public static void 로또생성() {
        List<Integer> list = pickUniqueNumbersInRange(1, 45, 6);
        lotto = new Lotto(list);
    }

    public static String 예외_테스트(){
        String s = readLine();
        if(!isNumeric(s)){
            System.out.println("[ERROR]");
        }
        return s;
    }

    public static boolean isNumeric(String s) {
        for (int i = 0; i < s.length(); i++) {
            if( '0' > s.charAt(i) || s.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    public static void 기능_테스트() {
        for (int i = 0; i < lottoCnt; i++) {
            로또생성();
            lotto.myLotto_print();
            lottoCheck();
        }
        result_print();
    }

    public static void result_print() {
        for (Integer i : collectCnt) {
            if(i == 3){
                int k = resultArr[0]+1;
                resultArr[0] = k;
            }
            if(i == 4){
                int k = resultArr[1]+1;
                resultArr[1] = k;
            }
            if(i == 5){
                int k = resultArr[2]+1;
                resultArr[2] = k;
            }
            if(i == 6){
                int k = resultArr[3]+1;
                resultArr[3] = k;
            }
        }
        print();
        cal();
    }

    public static void print() {
        System.out.println("\"3개 일치 (5,000원) - " + resultArr[0] + "개\"");
        System.out.println("\"4개 일치 (50,000원) - " + resultArr[1] + "개\"");
        System.out.println("\"5개 일치 (1,500,000원) - " + resultArr[2] + "개\"");
        System.out.println("\"5개 일치, 보너스 볼 일치 (30,000,000원) - " + collectBonnusCnt + "개\"");
        System.out.println("\"6개 일치 (2,000,000,000원) - " + resultArr[3] + "개\"");
    }

    public static void cal() {
        double sum = 0;
        sum += 5000 * resultArr[0];
        sum += 50000 * resultArr[1];
        sum += 1500000 * resultArr[2];
        sum += 2000000000 * resultArr[3];
        sum += 30000000 * collectBonnusCnt;

        double result = (sum / total) * 100;
        String format = String.format("%.1f", result);
        System.out.println("\"총 수익률은 "+format+"%입니다.\"");
    }
}
