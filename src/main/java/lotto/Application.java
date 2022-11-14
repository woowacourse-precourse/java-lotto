package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    static int e = 0;
    private static final String ERROR = "[ERROR]";
    static int Recall = 0;
    static int money;
    public static final int[] PAY = {5000, 50000, 1500000, 30000000, 2000000000};
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요");

        try {
            input(Console.readLine());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Recall = money / 1000;

        System.out.println(Recall + "개");

        List<List<Integer>> numbers = new ArrayList<>();
        for (int j = 0; j < Recall; j++) {
            RandomLotto lottoNumbers = new RandomLotto();
            numbers.add(lottoNumbers.numbers);
            System.out.println(numbers.get(j));
        }
        List winNumber = WinnerNumber();

    }

    public static void input(String moneya) {
        try {
            for (int i = 0; i < moneya.length(); i++) {
                if (!(moneya.charAt(i) >= '0' && moneya.charAt(i) <= '9')) {
                    throw new IllegalArgumentException(ERROR);
                }
            }
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR + "잘못된 금액입니다.");
        }

        money = Integer.parseInt(moneya);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR + "천원단위로 구매해주세요.");
        }
    }

    public static List WinnerNumber() {
        List<Integer> winNumber = new ArrayList<>();

        System.out.println("당첨 숫자를 입력해주세요");
        String[] inputGivenNumber = Console.readLine().split(",");
        for (int i = 0; i < inputGivenNumber.length; i++) {
            if (winNumber.contains(Integer.parseInt(inputGivenNumber[i]))) {
                throw new IllegalArgumentException(ERROR + "잘못된 당첨 번호입니다.");
            }
            winNumber.add(Integer.parseInt(inputGivenNumber[i]));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if(winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + "잘못된 보너스 번호입니다.");
        }
        winNumber.add(bonusNumber);

        return winNumber;
    }
    private static void caunt(int sameNumber,int samebonusNumber){
        if(sameNumber==3){
            a = a + 1;
        }else if(sameNumber == 4){
            b = b + 1;
        }else if(sameNumber == 5){
            c = c + 1;
        }else if(sameNumber == 6){
            d = d + 1;
        }else if(samebonusNumber == 7){
            e = e + 1;
        }

    }

}
