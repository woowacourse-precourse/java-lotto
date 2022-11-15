package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

import static lotto.collectionPrintout.*;
enum Rate {
    FIVE(5, "3개 일치 (5,000원)") {
        int calculate(int num) {
            return num * 5000;
        }
    },
    FOUR(4, "4개 일치 (50,000원)") {
        //"4개 일치 (50,000원)"),
        int calculate(int num) {
            return num * 50000;
        }
    },
    THREE(3, "5개 일치 (1,500,000원)") {
        //"5개 일치 (1,500,000원)"),
        int calculate(int num) {
            return num * 1500000;
        }
    },
    TWO(2, "5개 일치, 보너스 볼 일치 (30,000,000원)") {
        //"),
        int calculate(int num) {
            return num * 30000000;
        }
    },
    ONE(1, "6개 일치 (2,000,000,000원)") {
        //,
        int calculate(int num) {
            return num * 2000000000;
        }
    };

    private final int rate;
    private final String str;

    Rate(int num, String str) {
        this.rate = num;
        this.str = str;
    }

    public int getRate() {
        return rate;
    }

    public String getStr() {
        return str;
    }

    abstract int calculate(int num);
}
public class Application {
    static int lottoNumber;
    static int inputMoney;
    static int[] stats = {0, 0, 0, 0, 0, 0};
    static List<List<Integer>> randomNumbers = new ArrayList<>();

    public static void getMoney() {
        System.out.print(inputMoneyStr);

        String pattern = "^[0-9]*$";
        String inputStr = Console.readLine();
        if (!Pattern.matches(pattern, inputStr)) {
            throw new IllegalArgumentException(exceptionHeader + notInteger);
        }

        inputMoney = Integer.parseInt(inputStr);
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException(exceptionHeader + wrongUnit);
        }

        lottoNumber = inputMoney / 1000;
        System.out.println(lineBreak + lottoNumber + inputMoneyPrint);
    }

    public static void makeRandomNumbers() {
        for (int lotto = 0; lotto < lottoNumber; lotto++) {
            List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 7);
            Collections.sort(pickNumbers);
            randomNumbers.add(pickNumbers);
            printOut(lotto);
        }
    }

    public static void getWinningNumbers() {
        System.out.println(lineBreak + winningNumbersStr);
        Lotto lotto = new Lotto(stringToListInteger(Console.readLine()));
        System.out.println(lineBreak + bonusNumbersStr);
        lotto.addBonusNumber(Integer.parseInt(Console.readLine()));

        statsCalculate(lotto);
    }

    public static void statsCalculate(Lotto lotto) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            stats[lotto.compareWithRandomNumbers(randomNumbers.get(i))]++;
        }
    }

    public static void printOutResult() {
        long profit = 0;
        System.out.println(lineBreak + winningStats);
        for (Rate r : Rate.values()) {
            System.out.print(r.getStr() + String.format(" - %d개\n", stats[r.getRate()]));
            profit += r.calculate(stats[r.getRate()]);
        }
        System.out.println(String.format("총 수익률은 %.1f입니다.", profit / inputMoney));
    }

    public static void printOut(int num) {
        List<Integer> numbers = randomNumbers.get(num);

        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(String.format("%d, ", numbers.get(i)));
        }
        System.out.print(numbers.get(6));
        System.out.println("]");
    }

    public static List<Integer> stringToListInteger(String str) {
        String[] strArray = str.split(",");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < strArray.length; i++) {
            list.add(Integer.parseInt(strArray[i]));
        }
        return list;
    }

    public static void main(String[] args) {

        getMoney();
        makeRandomNumbers();
        getWinningNumbers();
        printOutResult();

    }
}
