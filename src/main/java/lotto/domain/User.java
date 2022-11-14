package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.view.Printer;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public void inputWinningNUmber() {
        Printer.inputWinningNumber();
        String[] numbers = Console.readLine().split(",");
        for(String str: numbers) {
            winningNumber.add(Integer.parseInt(str));
        }
        Printer.inputBonusNumber();
        bonusNumber = Integer.parseInt(Console.readLine());
    }
}
