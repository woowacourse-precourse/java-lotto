package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private static List<Integer> winningNumbers;

    public List<Integer> saveWinningNumber(String input){
        validateWinningNumber(input);
        winningNumbers = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        new Lotto(winningNumbers);
        return winningNumbers;
    }

    public void checkBonus(String bonus){
        validateBonusNumber(bonus);
        validateBonusRange(Integer.parseInt(bonus));
        validateDuplicateBonus(Integer.parseInt(bonus),winningNumbers);
    }
    private void validateBonusRange(int bonus){
        if(bonus<1 || bonus>45)
            throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45 중에서 입력하셔야 합니다.");
    }
    public void validateDuplicateBonus(int bonus, List<Integer> winningNumber){
        if(winningNumber.contains(bonus))
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복되면 안됩니다.");
    }
    private void validateBonusNumber(String bonus){
        if(!bonus.matches("^[0-9]*$"))
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능 합니다.");
    }
    private void validateWinningNumber(String input){
        if(!input.matches("^[0-9,]*$"))
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표(,)로 이루어져야 합니다.");
    }
}
