package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LottoCompany {

    private final int LENGTH = 6;
    private final int MAX_VALUE = 45;
    private final int MIN_VALUE = 1;

    Result result = new Result();
    List<Integer> forValidate = new ArrayList<>();
    Lottos lottos;
    Lotto lotto;
    int bonus;

    public LottoCompany() {

    }

    public void winningNumbers(Lottos lottos) {
        this.lottos = lottos;
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        makeWinningNumbers(winningNumbers);
    }

    public void bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validateBonus(bonusNumber, forValidate);
        this.bonus = Integer.parseInt(bonusNumber);
        result.compareNumbers(this.lottos, this.lotto, this.bonus);
    }

    public void validateBonus(String bonusInput, List<Integer> numbers) {
        validateBonusOneNumber(bonusInput);
        int bonus = Integer.parseInt(bonusInput);
        validateBonusRange(bonus);
        validateBonusDuplicate(numbers, bonus);
    }

    public void validateBonusDuplicate(List<Integer> numbers, int bonus) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bonus) {
                System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않게 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateBonusRange(int bonus) {
        if (bonus > MAX_VALUE || bonus < MIN_VALUE) {
            System.out.println("[ERROR] 보너스 번호는 1~45 사이의 숫자만 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusOneNumber(String bonusInput) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, bonusInput)) {
            System.out.println("[ERROR] 보너스 번호는 '하나의 숫자로만' 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void makeWinningNumbers(String numbers) {
        String[] winningNumbers = numbers.split(",");
        Arrays.sort(winningNumbers);
        validate(winningNumbers);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int order = 0; order < LENGTH; order++) {
            lottoNumbers.add((Integer.parseInt(winningNumbers[order])));
        }
        this.lotto = new Lotto(lottoNumbers);
        bonusNumber();
    }

    private void validate(String[] winningNumbers) {
        validateWinningNumbers(winningNumbers);
        validateDuplicate(winningNumbers);
        for (int i = 0; i < winningNumbers.length; i++) {
            forValidate.add(Integer.parseInt(winningNumbers[i]));
        }
    }

    public void validateWinningNumbers(String[] numbers) {
        String pattern = "^[0-9]*$";
        String manInput = String.join("", numbers);
        if (!Pattern.matches(pattern, manInput)) {
            System.out.println("[ERROR] 6개의 '숫자만' 입력하고 ','로 당첨 번호를 구분해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(String[] numbers) {
        long distinctCount = Stream.of(numbers).distinct().count();
        if (numbers.length != distinctCount) {
            System.out.println("[ERROR] 중복되지 않은 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
