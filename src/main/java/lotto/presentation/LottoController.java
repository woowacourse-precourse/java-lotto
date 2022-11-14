package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.LottoFacade;
import lotto.application.LottoFacadeImpl;
import lotto.domain.Lotto;
import lotto.domain.enummodel.RankEnum;

import java.util.List;

public class LottoController {

    private final LottoFacade lottoFacade = new LottoFacadeImpl();
    public void run() {

        List<Lotto> clientLotto = buyLotto();
        Lotto winLotto = inputWinLotto();
        int bonusNum = inputBonusNum();
        List<Integer> result = viewResult(clientLotto, winLotto, bonusNum);

    }


    private List<Lotto> buyLotto() {
        String moneyInput = getInput(ViewValue.BUY_INFO_MESSAGE.getValue());

        List<Lotto> clientLotto = lottoFacade.buyLotto(Integer.valueOf(moneyInput));

        System.out.println(clientLotto.size()+ViewValue.BUY_INFO_DONE.getValue());

        clientLotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
        return clientLotto;
    }

    private String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private Lotto inputWinLotto() {
        String lottoNumberInput = getInput(ViewValue.INSERT_NUMBER_INFO.getValue());
        return lottoFacade.registerWinLotto(lottoNumberInput);
    }

    private int inputBonusNum() {
        String bonusInput = getInput(ViewValue.INSERT_BONUS_INFO.getValue());
        return Integer.parseInt(bonusInput);
    }

    private List<Integer> viewResult(List<Lotto> clientLotto, Lotto winLotto, int bonusNum) {
        System.out.println(ViewValue.WINNING_INFO_MESSAGE.getValue());
        System.out.println("---");
        List<Integer> result = lottoFacade.checkWinning(winLotto, clientLotto, bonusNum);
        List<String> resultString = printValue(result);
        resultString.forEach(System.out::println);
        return result;
    }

    private List<String> printValue(List<Integer> result) {
        return List.of(
                ViewValue.WINNING_FIFTH.getValue()
                        + result.stream().filter(value -> value== RankEnum.FIFTH.getMatchNumber()).count() + ViewValue.WINNING_END.getValue(),
                ViewValue.WINNING_FOURTH.getValue()
                        + result.stream().filter(value -> value==RankEnum.FOURTH.getMatchNumber()).count() + ViewValue.WINNING_END.getValue(),
                ViewValue.WINNING_THIRD.getValue()
                        + result.stream().filter(value -> value==RankEnum.THIRD.getMatchNumber()).count() + ViewValue.WINNING_END.getValue(),
                ViewValue.WINNING_SECOND.getValue()
                        + result.stream().filter(value -> value==RankEnum.SECOND.getMatchNumber()+1).count() + ViewValue.WINNING_END.getValue(),
                ViewValue.WINNING_FIRST.getValue()
                        + result.stream().filter(value -> value==RankEnum.FIRST.getMatchNumber()+1).count() + ViewValue.WINNING_END.getValue()
        );
    }
}
