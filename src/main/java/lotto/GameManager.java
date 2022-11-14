package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.dto.LottoResultDto;
import lotto.util.ResultPrice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameManager {
    private static final Validation validation = new Validation();

    private final Publisher publisher;

    GameManager() {
        publisher = new Publisher();
    }

    public void play() {
        int money = getMoney();
        MoneyManager moneyManager = new MoneyManager(money);

        List<Lotto> lottoGroup = getLottoGroup(money);
        Printer.printLottoGroup(lottoGroup);

        Map<ResultPrice, Integer> totalScore = getTotalScore(lottoGroup);
        Printer.printTotalScore(totalScore);

        Double moneyReturn = moneyManager.getMoneyReturn(totalScore);
        Printer.printMoneyReturn(moneyReturn);
    }

    private int getMoney() {
        Printer.printInfoMoneyInput();

        String money = Console.readLine();
        validation.validateMoneyInput(money);

        return Integer.parseInt(money);
    }

    private List<Lotto> getLottoGroup(int money) {
        return publisher.getLottoGroup(money);
    }

    private List<Integer> getResultNumbers() {
        Printer.printInfoInputResult();
        String result = Console.readLine();
        validation.validateResultNumberInput(result);

        return Arrays.stream(result.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private Integer getBonusNumber() {
        Printer.printInfoInputBonus();
        String bonus = Console.readLine();
        validation.validateIsNumberInput(bonus);

        return Integer.parseInt(bonus);
    }

    private Map<ResultPrice, Integer> getTotalScore(List<Lotto> lottoGroup) {
        List<Integer> resultNumbers = getResultNumbers();
        Integer bonusNumber = getBonusNumber();

        LottoResultDto resultDto = new LottoResultDto(resultNumbers, bonusNumber);
        Checker checker = new Checker(resultDto);

        return checker.getTotalScore(lottoGroup);
    }

}
