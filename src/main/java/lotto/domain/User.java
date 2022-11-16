package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validate;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> winningNumber;
    private Integer bonusNumber;
    Validate validate = new Validate();

    public User(){};

    public void inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> numbers = List.of(input.split(","));

        validate.validateLottoNum(numbers);
        winningNumber = new ArrayList<>();
        for (String num : numbers) {
            winningNumber.add(Integer.parseInt(num));
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        validate.validateBonusNum(bonusInput, winningNumber);
        bonusNumber = Integer.parseInt(bonusInput);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }



}
