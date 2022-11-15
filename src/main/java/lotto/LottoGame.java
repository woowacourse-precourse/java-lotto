package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class LottoGame {
    private final String seperator = ",";
    private final LottoVendingMachine machine;
    private CheckPrize checkPrize;
    private final ArrayList<Integer> winningNumber;
    private int bonusNumber;
    private ArrayList<Lotto> purchasedLotto;
    private int inputMoney;

    public LottoGame() {
        machine = new LottoVendingMachine();
        winningNumber = new ArrayList<>();
        checkPrize = new CheckPrize();
    }

    public void start() {
        buyLotto();
        printPurchasedLotto();

        System.out.println("당첨 번호를 입력해 주세요");
        String numbersInput = Console.readLine();
        getWinnerNumber(numbersInput);

        System.out.println("보너스 번호를 입력해 주세요");
        String bonusInput = Console.readLine();
        bonusNumber = checkInteger(bonusInput);
        checkBonus(bonusNumber);

        printResult();
    }

    private void printPurchasedLotto() {
        for (Lotto l : purchasedLotto)
            System.out.println("[" + l + "]");
    }

    private void getWinnerNumber(String numbersInput) {
        String[] numbers = numbersInput.split(seperator);
        ArrayList<String> values = new ArrayList<>(Arrays.asList(numbers));
        for (String s : values)
            winningNumber.add(Integer.parseInt(s));

        validate(winningNumber);
        checkSame(winningNumber);
    }

    // 당첨 번호가 6개인지 확인하는 함수
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_OVER_SIX.getMessage());
        }
    }

    // 당첨 번호에 중복이 있는지 확인하는 함수
    private void checkSame(List<Integer> winningNumber) {
        Set<Integer> checkSet = new HashSet<>(winningNumber);

        if (winningNumber.size() != checkSet.size())
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED.getMessage());
    }

    // 보너스 번호가 당첨 번호와 중복되는지 확인하는 함수
    private void checkBonus(int bonusNumber) {
        for (int n : winningNumber) {
            if (n == bonusNumber)
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    // 돈을 입력받아 로또를 발행하는 함수
    private void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        inputMoney = checkInteger(input);
        purchasedLotto = machine.publishLotto(inputMoney);
    }

    //입력이 정수인지 확인하는 함수
    private int checkInteger(String moneyInput) {
        String value = "";
        for (int i = 0; i < moneyInput.length(); i++) {
            char digit = moneyInput.charAt(i);
            if (digit >= '0' && digit <= '9')
                value += Character.toString(digit);
            else {
                System.out.println(ErrorMessage.INPUT_IS_NOT_INTEGER.getMessage());
            }
        }

        return Integer.parseInt(value);
    }

    private void printResult() {
        int prize = checkPrize.getPrize(purchasedLotto, winningNumber, bonusNumber);
        double earnRate = ((double) prize / inputMoney) * 100;
        String rateFormat = "총 수익률은 %.1f%%입니다.";
        String printRate = String.format(rateFormat, earnRate);
        System.out.println(printRate);
    }
}
