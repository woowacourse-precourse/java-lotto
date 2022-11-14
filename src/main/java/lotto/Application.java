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
    static int f = 0;
    private static final String ERROR_MESSAGE = "[ERROR]";
    static int Recall = 0;
    static int money;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요");

        try {
            input(Console.readLine());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Recall = money / 1000;

        System.out.println(Recall + "개를 구매했습니다.");

        List<List<Integer>> numbers = new ArrayList<>();
        for (int j = 0; j < Recall; j++) {
            RandomLotto lottoNumbers = new RandomLotto();
            numbers.add(lottoNumbers.numbers);
            System.out.println(numbers.get(j));
        }
        List winNumber = WinnerNumber();

        for (int i = 0; i < numbers.size(); i++) {
            Compare compare = new Compare();
            int sameNumber = compare.compareNumbers(winNumber, numbers.get(i));
            count(sameNumber);
        }
        calculation();
    }


    public static void input(String moneya) {
        try {
            for (int i = 0; i < moneya.length(); i++) {
                if (!(moneya.charAt(i) >= '0' && moneya.charAt(i) <= '9')) {
                    throw new IllegalArgumentException(ERROR_MESSAGE);
                }
            }
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 금액입니다.");
        }

        money = Integer.parseInt(moneya);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "천원단위로 구매해주세요.");
        }
    }

    public static List WinnerNumber() {
        List<Integer> winNumber = new ArrayList<>();

        System.out.println("당첨 숫자를 입력해주세요");
        String[] inputGivenNumber = Console.readLine().split(",");
        for (int i = 0; i < inputGivenNumber.length; i++) {
            if (winNumber.contains(Integer.parseInt(inputGivenNumber[i]))) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 당첨 번호입니다.");
            }
            winNumber.add(Integer.parseInt(inputGivenNumber[i]));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 보너스 번호입니다.");
        }
        winNumber.add(bonusNumber);

        return winNumber;
    }

    private static void count(int sameNumber) {
        if (sameNumber == 3) {
            a = a + 1;
        } else if (sameNumber == 4) {
            b = b + 1;
        } else if (sameNumber == 5) {
            c = c + 1;
        } else if (sameNumber == 6) {
            d = d + 1;
        } else if (sameNumber == 7) {
            e = e + 1;
        }

    }
    private static void calculation() {
        double percentage;

        System.out.print("3개 일치 (5,000원) - " + a + "개" + "\n" +
                "4개 일치 (50,000원) - " + b + "개" + "\n" +
                "5개 일치 (1,500,000원) - " + c + "개" + "\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + d + "개" + "\n" +
                "6개 일치 (2,000,000,000원) - " + e + "개"+"\n");
        f = (a * 5000) + (b * 50000) + (c * 1500000) + (d * 2000000000) + (e * 30000000);
        percentage = ((double)f / money)* 100;
        System.out.print("총 수익률은 ");
        System.out.printf("%.1f" ,percentage);
        System.out.print("%입니다.");
    }
}