package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.view.Printer;

import java.util.ArrayList;
import java.util.List;


public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private Integer bonusNumber;
    public User() {};
    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    Validate validate = new Validate();
    public void inputWinningNumber() {
        Printer.inputWinningNumber();
        String input = Console.readLine();
        List<String> numbers = List.of(input.split(","));

        validate.validateLottoNum(numbers);
        for(String str: numbers) {
            winningNumber.add(Integer.parseInt(str));
        }
    }
    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
    public void inputBonusNumber() {
        Printer.inputBonusNumber();
        String bonusInput = Console.readLine();
        validate.validateBonusNum(bonusInput, winningNumber);
        bonusNumber = Integer.parseInt(bonusInput);
    }
    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
