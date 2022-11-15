package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class WinningTicket {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningTicket() {
    }

    void setNumbers() {
        List<Integer> lottoNumbers;

        lottoNumbers = inputNumbers();
        Lotto.validateLottoNumbers(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private List<Integer> inputNumbers() {
        String userInput;
        List<Integer> adjusted;

        System.out.println("당첨 번호를 입력해 주세요.");
        userInput = Console.readLine();
        adjusted = adjustUserInput(userInput);
        return adjusted;
    }

    List<Integer> adjustUserInput(String userInput) {
        String[] splitInput = userInput.split(",");
        List<Integer> lottoNumbers;

        validateIsNum(splitInput);
        lottoNumbers = intoNumbers(splitInput);

        return lottoNumbers;
    }

    void validateIsNum(String[] splitInput) {
        for (String number : splitInput) {
            if (!User.isNum(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요");
            }
        }
    }

    List<Integer> intoNumbers(String[] splitInput) {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String number : splitInput) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        return lottoNumbers;
    }

    void setBonusNumber() {
        String bonus;

        bonus = inputBonusNumber();
        validateBonusNumber(bonus);
        this.bonusNumber = Integer.parseInt(bonus);
    }

    private String inputBonusNumber() {
        String userInput;

        System.out.println("보너스 번호를 입력해 주세요.");
        userInput = Console.readLine();

        return userInput;
    }
}