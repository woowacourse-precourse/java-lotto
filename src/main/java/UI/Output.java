package UI;

import java.util.List;

public class Output {
    public static final String INPUTPRICE = "구입금액을 입력해 주세요.";
    public static final String INPUTWINNINGNUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUTBONUSNUMBER = "보너스 번호를 입력해 주세요";

    public static void inputPrice() {
        System.out.println(INPUTPRICE);
    }

    public static void inputWinningNumber() {
        System.out.println(INPUTWINNINGNUMBERS);
    }

    public static void inputBounsNumber() {
        System.out.println(INPUTBONUSNUMBER);
    }

    //구매한 내역 출력
    public static void printRandomLottoNumbers(List<List<Integer>> randomLottoNumbers) {
        int numberOfLotto = randomLottoNumbers.size();
        System.out.printf("%d 개를 구매했습니다\n", numberOfLotto);

        for (List<Integer> number : randomLottoNumbers) {
            System.out.println(number);
        }
    }


    //당첨통계 출력

}
