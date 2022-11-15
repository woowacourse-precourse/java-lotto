package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {

    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public WinningNumber() throws IllegalArgumentException {

        setWinningNumbers();
        validateWinningNumber(winningNumbers);
        setBonusNumber();
        validateBonusNumber(winningNumbers, bonusNumber);

    }

    private void validateWinningNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호를 입력해주세요.");
        }
        if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber)
            throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private void setWinningNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요. (1~45)중 6개를 골라주세요. 쉼표로 구분됩니다");
        String winningNumberUserInput = readLine();
        try {
            winningNumbers = Stream.of(winningNumberUserInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void setBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요. (1~45)중 1개를 골라주세요.");
        String bonusNumberUserInput = readLine();
        try {
            bonusNumber = Integer.parseInt(bonusNumberUserInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
