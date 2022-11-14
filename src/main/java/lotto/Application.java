package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static final int LOTTO_START = 1;
    static final int LOTTO_END = 45;
    static final int LOTTO_PICK_NUM = 6;
    public static void main(String[] args) {
        printInputMoney();

        int money = getMoneyInputFromUser();
        int numberOfLotteries = calculateNumberOfLotteries(money);

        printNumberOfLotteries(numberOfLotteries);

        List<Lotto> lotteries = new LinkedList<>();
        randomPickLotteries(lotteries, numberOfLotteries);

        printInputWinLotto();
        WinLotto winLotto = getWinLottoInputFromUser();
    }

    private static WinLotto getWinLottoInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //TODO: 입력 검증 후 보너스 번호 입력

        return null;
    }

    private static void printInputWinLotto() {
        System.out.println(Message.INPUT_LOTTO_WIN.message);
    }

    public static void randomPickLotteries(List<Lotto> lotteries, int numberOfLotteries) {
        for (int i = 0; i < numberOfLotteries; i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_PICK_NUM);
            Collections.sort(uniqueNumbers);
            Lotto lotto = new Lotto(uniqueNumbers);
            lotteries.add(lotto);

            System.out.println(lotto);
        }
    }

    private static void printNumberOfLotteries(int numberOfLotteries) {
        System.out.println(numberOfLotteries + Message.OUTPUT_LOTTO_NUMBER.message);
    }

    public static int calculateNumberOfLotteries(int money) {
        return money / 1000;
    }

    private static int getMoneyInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return validateMoneyInput(input);
    }

    public static int validateMoneyInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(Message.ERROR_MONEY.message);
        }

        int inputInInt = Integer.parseInt(input);
        if (!inMoneyRange(inputInInt) || !divisibleByThousand(inputInInt)) {
            throw new IllegalArgumentException(Message.ERROR_MONEY.message);
        }

        return inputInInt;
    }

    public static boolean inMoneyRange(int inputInt) {
        if (inputInt >= 0) {
            return true;
        }
        return false;
    }

    public static boolean divisibleByThousand(int inputInt) {
        if (inputInt % 1000 == 0) {
            return true;
        }
        return false;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private static void printInputMoney() {
        System.out.println(Message.INPUT_MONEY.message);
    }
}
