package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 당첨 번호 발표
 */
public class LottoCompany {
    private Lotto winningNumbers;
    private int bonusNumber;

    public void drawWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> winningNumbers = Arrays.asList(readLine().split(","));
        validateNumericWinningNumbers(winningNumbers);
        this.winningNumbers = new Lotto(winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public void drawBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String number = readLine();
        validateNumericBonusNumber(number);
        int bonusNumber = Integer.parseInt(number);
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumericWinningNumbers(List<String> numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumericBonusNumber(String number) {
        if (!isNumeric(number)) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(int number) {
        if (this.winningNumbers.getNumbers().contains(number)) {
            System.out.println("[ERROR] 당첨 번호는 로또 번호와 다른 번호를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String number) {
        return number.matches("^[0-9]+$");
    }
}
