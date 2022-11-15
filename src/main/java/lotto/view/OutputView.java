package lotto.view;

import java.util.List;

public class OutputView {

    public static String isNumberMsg() {
        return "[ERROR] 숫자를 입력해주세요.";
    }

    public static String unitErrorMsg() {
        return "[ERROR] 1000원으로 나누어 떨어지지 않습니다.";
    }

    public static void lottoCountMsg(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static String equalMsg() {
        return "[ERROR] 중복된 값이 있습니다.";
    }

    public static String rangeMsg(){
        return "[ERROR] 1~45범위의 숫자만 입력해주세요.";
    }

    public static String validateMsg(){
        return "[ERROR] 6개의 숫자를 입력해주세요.";
    }

    public static String equalBonusMsg() {
        return "[ERROR] 당첨 번호와 중복된 값이 있습니다.";
    }

    public static void userLottoMsg(int index, List<List<Integer>> lotto) {
        System.out.println(lotto.get(index));
    }

    public static void rankMsg(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void fifthMsg(int count) {
        System.out.println("3개 일치 (5,000원) - " + count + "개");
    }

    public static void fourthMsg(int count){
        System.out.println("4개 일치 (50,000원) - " + count + "개");
    }

    public static void thirdMsg(int count){
        System.out.println("5개 일치 (1,500,000원) - " + count + "개");
    }

    public static void secondMsg(int count){
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
    }

    public static void firstMsg(int count) {
        System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
    }

    public static void rateMsg(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

}
