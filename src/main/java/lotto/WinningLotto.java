package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winNumbers;
    public int bonus;

    public WinningLotto(String inputNumbers) {
        List<String> splitInput = splitNum(inputNumbers);
        checkWinLength(splitInput);
        this.winNumbers = checkWinNum(splitInput);
    }

    private List<String> splitNum(String inputNumbers) {
        return List.of(inputNumbers.split(","));
    }

    private void checkWinLength(List<String> splitNum) {
        if (splitNum.size() != 6) {
            throw new IllegalArgumentException("6개 숫자를 입력해주세요.");
        }
    }

    private List<Integer> checkWinNum(List<String> splitInput) {
        List<Integer> winNumbers = new ArrayList<>();
        for (String input : splitInput) {
            int winNumber = Integer.parseInt(input);
            if (winNumber < 1 || winNumber > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winNumbers.contains(winNumber)) {
                throw new IllegalArgumentException("로또 번호는 중복되지 않습니다.");
            }
            winNumbers.add(winNumber);
        }
        return winNumbers;
    }

    private void compareBonusWithWin(int bonus) {
        for (int winNumber : this.winNumbers) {
            if (bonus == winNumber) {
                throw new IllegalArgumentException("보너스 번호는 또로 번호와 중복되선 안됩니다.");
            }
        }
    }

    private int checkBonusNumber(String input) {
        try {
            int bonus = Integer.parseInt(input);
            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            compareBonusWithWin(bonus);
            return bonus;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }

    }

    public void inputBonusNumber(String input) {
        this.bonus = checkBonusNumber(input);
    }

    public List<Integer> getWinNumbers() {
        return this.winNumbers;
    }

    public int getBonusNumber() {
        return this.bonus;
    }

}

/*
당첨번호 입력 - inputWinNumber()
쉼표를 기준으로 구분한 1~45 사이 6개의 중복되지 않는 번호 입력
입력받은 값을 쉼표 기준으로 split - splitWinNum()
split한 리스트의 길이가 6이면 통과 - checkWinLength()
범위 밖의 숫자가 없고 중복되는 숫자가 없으면 통과 - checkWinNum()
위의 조건 통과하지 못하면 예외처리
보너스 번호 입력 - inputBonusNumber()
1~45 사이의 수 입력
입력받은 수가 당첨번호와 중복되지 않으면 통과 - compareBonusWin()
이외의 경우 예외처리
 */