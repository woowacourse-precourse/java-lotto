package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.enumType.*;

public class Service {

    static Map<enumType, Integer> result = new HashMap<>();

    public String getMoneyInput() {
        String input = Console.readLine();
        String moneyInput = input.replaceAll("\\s", "");
        checkMoney(moneyInput);
        return moneyInput;
    }

    private void checkMoney(String moneyInput) {
        try {
            int money = Integer.parseInt(moneyInput);
            if (!(money % 1000 == 0)) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public List<List<Integer>> createNumber(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        int numberOfCreate = money / 1000;
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfCreate; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto validate = new Lotto(lottoNumber);
            System.out.println(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

    public String getWinningNumberInput() {
        String input = Console.readLine();
        String winningNumberInput = input.replaceAll("\\s", "");
        checkWinningNumber0(winningNumberInput);
        return winningNumberInput;
    }

    public void checkWinningNumber0(String winningNumberInput) {
        if (!winningNumberInput.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식이 아닙니다.");
        }
        String[] winningNumbers = winningNumberInput.split(",");
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
        Set<String> winningNumberSet = new HashSet<>(Arrays.asList(winningNumbers));
        if (winningNumberSet.size() != winningNumbers.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
        checkWinningNumber1(winningNumbers);
    }

    public void checkWinningNumber1(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            try {
                Integer.parseInt(winningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
            }
            if (!(Integer.parseInt(winningNumber) > 0) || !(Integer.parseInt(winningNumber) < 46)) {
                throw new IllegalArgumentException("[ERROR] 범위를 벗어나는 숫자입니다.");
            }
        }
    }

    public String getLuckyNumberInput(String winningNumberInput) {
        String input = Console.readLine();
        String luckyNumberInput = input.replaceAll("\\s", "");
        checkLuckyNumber0(luckyNumberInput, winningNumberInput);
        return luckyNumberInput;
    }

    public void checkLuckyNumber0(String luckyNumberInput, String winningNumberInput) {
        try {
            int luckyNumber = Integer.parseInt(luckyNumberInput);
            if (!(luckyNumber > 0) || !(luckyNumber < 46)) {
                throw new IllegalArgumentException("[ERROR] 범위를 벗어나는 숫자입니다.");
            }
            checkLuckyNumber1(luckyNumber, winningNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public void checkLuckyNumber1(int luckyNumber, String winningNumberInput) {
        String[] winningNumbers = winningNumberInput.split(",");
        for (String winningNumber : winningNumbers) {
            if (luckyNumber == Integer.parseInt(winningNumber)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            }
        }
    }

    public List<Integer> countWinner(List<List<Integer>> lottoNumberList, String winningNumberInput, String luckyNumberInput) {
        for (List<Integer> lottoNumber : lottoNumberList) {
            if (countCorrectNumber(lottoNumber, winningNumberInput) == 3) {
                result.put(winner5st, result.getOrDefault(winner5st, 1) + 1);
            } else if (countCorrectNumber(lottoNumber, winningNumberInput) == 4) {
                result.put(winner4st, result.getOrDefault(winner4st, 1) + 1);
            } else if (countCorrectNumber(lottoNumber, winningNumberInput) == 5 && !correctLuckyNumber(luckyNumberInput, lottoNumber)) {
                result.put(winner3st, result.getOrDefault(winner3st, 1) + 1);
            } else if (countCorrectNumber(lottoNumber, winningNumberInput) == 5 && correctLuckyNumber(luckyNumberInput, lottoNumber)) {
                result.put(winner2st, result.getOrDefault(winner2st, 1) + 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (Integer value : result.values()) {
            resultList.add(value);
        }
        return resultList;
    }

    private boolean correctLuckyNumber(String luckyNumberInput, List<Integer> lottoNumber) {
        int luckyNumber = Integer.parseInt(luckyNumberInput);
        for (int number : lottoNumber) {
            if (number == luckyNumber) {
                return true;
            }
        }
        return false;
    }

    private int countCorrectNumber(List<Integer> lottoNumber, String winningNumberInput) {
        int count = 0;
        for (int number : lottoNumber) {
            if (correctNumber(number, winningNumberInput)) {
                count++;
            }
        }
        return count;
    }

    private boolean correctNumber(int number, String winningNumberInput) {
        boolean correct = false;
        String[] winningNumbers = winningNumberInput.split(",");
        for (String winningNumber : winningNumbers) {
            if (Integer.parseInt(winningNumber) == number) {
                correct = true;
            }
        }
        return correct;
    }
}
