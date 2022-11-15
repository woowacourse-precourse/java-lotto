package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InputManager {

    public int getPurchasingAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int amount;
        try {
            amount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 구입 급액은 숫자 외에 다른 문자가 포함되지 않아야 합니다.");
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 급액은 1000원 단위여야 합니다.");
        }

        return amount;
    }

    public List<Integer> drawWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberInput;
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            winningNumberInput = Console.readLine().replaceAll(" ", "").split(",");
            for (String winningNumber : winningNumberInput) {
                winningNumbers.add(Integer.parseInt(winningNumber));
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표를 기준으로 구분해야 합니다.");
        }
        validateWinningNumbers(winningNumbers);


        return winningNumbers;
    }

    public int drawBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 하고 숫자 외에 다른 문자가 포함되지 않아야 합니다.");
        }

        validateBonusNumber(bonusNumber, winningNumbers);

        return bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }

        Set<Integer> numbersSet = Sets.newHashSet(winningNumbers);
        if (numbersSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

}
