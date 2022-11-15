package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {

    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public WinningNumber() {
        try{
            setWinningNumbers();
            validateWinningNumber(this.winningNumbers);
            setBonusNumber();
            validateBonusNumber(this.winningNumbers, this.bonusNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 5) {
            throw new IllegalArgumentException("[Error] 5개의 당첨 번호를 입력해주세요.");
        }
        if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 5) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 중복될 수 없습니다.");
        }

    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private void setWinningNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요. (1~45)중 5개를 골라주세요. 쉼표로 구분됩니다");
        String winningNumberUserInput = readLine();
        try{
            List<Integer> winningNumbers = Stream.of(winningNumberUserInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            this.winningNumbers = winningNumbers;
        }catch (Exception e){
            throw new IllegalArgumentException("[Error] 당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void setBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요. (1~45)중 1개를 골라주세요.");
        String bonusNumberUserInput = readLine();
        try{
            int bonusNumber = Integer.parseInt(bonusNumberUserInput);
            this.bonusNumber = bonusNumber;
        }catch (Exception e){
            throw new IllegalArgumentException("[Error] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
