package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            runApplication();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void runApplication() {
        System.out.println("구입금액을 입력해 주세요.");
        User user = new User(Console.readLine());
        user.printLottoList();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningLottoNumbers = getWinningLottoNumbers(Console.readLine());
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber(Console.readLine(), winningLottoNumbers);
        Calculator calculator = new Calculator(winningLotto, user.getLottoList(), bonusNumber);
        calculator.printHistory();
        Yield yield = new Yield(user.getPurchasePrice(), getProfits(calculator.getHistory()));
        yield.printYieldRate();
    }

    public static List<Integer> getWinningLottoNumbers(String input) {
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            validateNumber(inputNumber);
            numbers.add(Integer.parseInt(inputNumber));
        }
        return numbers;
    }

    public static int getBonusNumber(String input, List<Integer> winningLottoNumbers) {
        validateNumber(input, winningLottoNumbers);
        return Integer.parseInt(input);
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.INVALID_INPUT_VALUE.getMessage());
        }
    }

    public static void validateNumber(String input, List<Integer> winningLottoNumbers) {
        validateNumber(input);
        if (winningLottoNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(Error.INPUT_DUPLICATE.getMessage());
        }
    }

    public static double getProfits(HashMap<Rank, Integer> history) {
        double profits = 0;
        profits += history.get(Rank.FIFTH) * Rank.FIFTH.getPrice();
        profits += history.get(Rank.FOURTH) * Rank.FOURTH.getPrice();
        profits += history.get(Rank.THIRD) * Rank.THIRD.getPrice();
        profits += history.get(Rank.SECOND) * Rank.SECOND.getPrice();
        profits += history.get(Rank.FIRST) * Rank.FIRST.getPrice();
        return profits;
    }
}
