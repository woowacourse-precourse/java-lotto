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
        // 구입금액입력
        Printer.printInfoMoneyInput();
        String moneyInput = Console.readLine();
        int money = Integer.parseInt(moneyInput);
        List<Lotto> lottoGroup = publisher.getLottoGroup(money);
        MoneyManager moneyManager = new MoneyManager(money);

        // - 구매한 로또 목록 출력
        Printer.printLottoGroup(lottoGroup);

        // 당첨번호 입력
        Printer.printInfoInputResult();
        String result = Console.readLine();
        List<Integer> resultNumber = Arrays.stream(result.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 보너스 번호 입력
        Printer.printInfoInputBonus();
        String bonus = Console.readLine();
        Integer bonusNumber = Integer.parseInt(bonus);

        LottoResultDto resultDto = new LottoResultDto(resultNumber, bonusNumber);
        Checker checker = new Checker(resultDto);

        // - 당첨통계 출력
        Map<ResultPrice, Integer> totalScore = checker.getTotalScore(lottoGroup);
        Printer.printTotalScore(totalScore);
        Double moneyReturn = moneyManager.getMoneyReturn(totalScore);
        Printer.printMoneyReturn(moneyReturn);
    }
}
