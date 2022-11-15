package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputOutput {

    public int getMoneyInput() {
        String inputMoney = Console.readLine();
        return gameStringToInt(inputMoney);
    }

    private int gameStringToInt(String inputMoney) {
        int money = validateStringToInt(inputMoney);
        validateMoney(money);
        return money;
    }

    private int validateStringToInt(String string) {
        int interger = 0;
        try {
            interger = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        return interger;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 떨어지는 숫자를 입력해주세요.");
        }
    }

    public void printLotto(List<Lotto> buyerLotto) {
        Stream<Lotto> stream = buyerLotto.stream();
        stream.forEach(Lotto::printLotto);
    }

    public List<Integer> getWinnigLotto() {
        String winnigLottoString = Console.readLine();

        String[] split = winnigLottoString.split(",");

        return arrayStringToIntList(split);
    }

    private List<Integer> arrayStringToIntList(String[] split) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String singleNumString : split) {
            int num = stringToIntAndCheckError(winningNumbers, singleNumString);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private int stringToIntAndCheckError(List<Integer> winningNumbers, String string) {
        int num = validateStringToInt(string);

        checkNumInRange(num);

        checkDuplication(winningNumbers, num);
        return num;
    }

    private void checkNumInRange(int num) {
        if (num < 1 || num > 45)
            throw new IllegalArgumentException("[ERROR] 1~45의 범위에 있는 숫자를 입력해주세요.");
    }

    private void checkDuplication(List<Integer> winningNumbers, int num) {
        if (winningNumbers.contains(num))
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        String bonusNumString = Console.readLine();
        return stringToIntAndCheckError(winningNumber, bonusNumString);
    }
}
