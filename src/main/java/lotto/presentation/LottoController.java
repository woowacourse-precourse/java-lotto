package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.LottoFacade;
import lotto.application.LottoFacadeImpl;
import lotto.domain.Lotto;
import lotto.domain.enummodel.ErrorMessageEnum;
import lotto.domain.enummodel.LottoEnum;
import lotto.domain.enummodel.PriceEnum;
import lotto.domain.enummodel.RankEnum;

import java.util.List;
import java.util.NoSuchElementException;

public class LottoController {

    private final LottoFacade lottoFacade = new LottoFacadeImpl();
    public void run() {

        List<Lotto> clientLotto = buyLotto();
        Lotto winLotto = inputWinLotto();
        int bonusNum = inputBonusNum();
        List<Integer> result = viewResult(clientLotto, winLotto, bonusNum);
        viewMargin(clientLotto, result);

    }


    private List<Lotto> buyLotto() {
        String moneyInput = inputWithMessage(ViewValue.BUY_INFO_MESSAGE.getValue());

        List<Lotto> clientLotto = lottoFacade.buyLotto(parseNumber(moneyInput));

        printLottoNumber(clientLotto);
        return clientLotto;
    }

    private String inputWithMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private void printLottoNumber(List<Lotto> clientLotto) {
        System.out.println(clientLotto.size()+ViewValue.BUY_INFO_DONE.getValue());

        clientLotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private Integer parseNumber(String stringInput) {
        try{
            return Integer.valueOf(stringInput);
        } catch (Exception e) {
            System.out.println(ErrorMessageEnum.ERROR_MESSAGE_VALIDATE.getValue());
            throw new NoSuchElementException();
        }
    }

    private Lotto inputWinLotto() {
        String lottoNumberInput = inputWithMessage(ViewValue.INSERT_NUMBER_INFO.getValue());
        return lottoFacade.registerWinLotto(lottoNumberInput);
    }

    private int inputBonusNum() {
        String bonusInput = inputWithMessage(ViewValue.INSERT_BONUS_INFO.getValue());
        int parseInput = parseNumber(bonusInput);
        validateNumberRange(parseInput);
        return parseInput;
    }

    private void validateNumberRange(int parseInput) {
        if (LottoEnum.LOTTO.getMinNum() > parseInput |
                LottoEnum.LOTTO.getMaxNum() < parseInput) {
            throw new IllegalArgumentException(ErrorMessageEnum.ERROR_MESSAGE_NUMBER_RANGE.getValue());
        }
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

    private void viewMargin(List<Lotto> clientLotto, List<Integer> result) {
        Integer money = lottoFacade.calculateMoney(result);
        String margin = lottoFacade.getMargin(clientLotto.size() * PriceEnum.LOTTO_PRICE.getValue(), money);
        System.out.println(ViewValue.MARGIN_INFO_HEAD.getValue() + margin + ViewValue.MARGIN_INFO_END.getValue());
    }
}
