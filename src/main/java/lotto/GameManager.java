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

    private Map<ResultPrice, Integer> getTotalScore(List<Lotto> lottoGroup) {
        List<Integer> resultNumbers = getResultNumbers();
        Integer bonusNumber = getBonusNumber();

        LottoResultDto resultDto = new LottoResultDto(resultNumbers, bonusNumber);
        Checker checker = new Checker(resultDto);

        // - 당첨통계 출력
        Map<ResultPrice, Integer> totalScore = checker.getTotalScore(lottoGroup);
        return totalScore;
    }

    private Integer getBonusNumber() {
        // 보너스 번호 입력
        Printer.printInfoInputBonus();
        String bonus = Console.readLine();
        return Integer.parseInt(bonus);
    }

    private List<Integer> getResultNumbers() {
        // 당첨번호 입력
        Printer.printInfoInputResult();
        String result = Console.readLine();
        List<Integer> resultNumber = Arrays.stream(result.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return resultNumber;
    }

    private List<Lotto> getLottoGroup(int money) {
        List<Lotto> lottoGroup = publisher.getLottoGroup(money);
        // - 구매한 로또 목록 출력
        return lottoGroup;
    }

    private int getMoney() {
        // 구입금액입력
        Printer.printInfoMoneyInput();
        String moneyInput = Console.readLine();
        int money = 0;

        money = Integer.parseInt(moneyInput);
        return money;
    }
}
