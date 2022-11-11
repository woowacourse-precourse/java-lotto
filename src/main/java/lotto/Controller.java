package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.Rank.Grade;

public class Controller {

    public static void startGame() {
        String inputMoney = View.inputMoney();
        try {
            validateMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        int money = Integer.parseInt(inputMoney);

        List<Lotto> lottoList = Lotto.getLottoList(money);
        View.printLottoList(lottoList);

        String numbers = View.inputWinningNumbers();
        try {
            validateWinningNumbers(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        List<Integer> winningNumbers = getWinningNumbers(numbers);

        int bonusNumber = View.inputBonusNumber();
        try {
            validateBonusNumber(bonusNumber, winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        Map<Integer, Integer> result = Rank.getResult(winningNumbers, lottoList, bonusNumber);
        View.printResult(result);
        double yield = getYield(money, result);
        View.printYield(yield);
    }

    public static void validateMoney(String inputMoney) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(inputMoney);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static List<Integer> getWinningNumbers(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public static void validateWinningNumbers(String numbers) {
        if (!isDigit(numbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (!hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 6개의 다른 숫자만 입력 가능합니다.");
        }
        if (!hassValidScope(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static boolean isDigit(String numbers) {
        for (char element : numbers.toCharArray()) {
            if (element == ',') {
                continue;
            }
            if (!Character.isDigit(element)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDuplication(String numbers) {
        Set<String> elements = new HashSet<>(Arrays.asList(numbers.split(",")));
        return elements.size() == 6;
    }

    public static boolean hassValidScope(String numbers) {
        for (String number : numbers.split(",")) {
            int element = Integer.parseInt(number);
            if (!(0 < element && element < 46)) {
                return false;
            }
        }
        return true;
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 존재합니다.");
        }
    }

    public static double getYield(int money, Map<Integer, Integer> result) {
        double sum = 0;
        for (Grade grade : Grade.values()) {
            if (grade.isCheck())
                sum += grade.getPrize() * result.get(7);
            if (!grade.isCheck()) {
                sum += grade.getPrize() * result.get(grade.getMatchCount());
            }
        }
        System.out.println((sum / money) * 100);
        return (sum / money) * 100;
    }
}
