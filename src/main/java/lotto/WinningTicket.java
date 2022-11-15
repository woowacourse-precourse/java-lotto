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
    }

    private void inputBonusNumber() {
        String userInput = "";

        System.out.println("보너스 번호를 입력해 주세요.");
        userInput = Console.readLine();
        validateBonusNumber(userInput);
        this.bonusNumber = Integer.parseInt(userInput);
    }
}