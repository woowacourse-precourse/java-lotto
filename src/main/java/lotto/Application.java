package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        AboutInputOutput io = new AboutInputOutput();

        System.out.println(io.PLEASE_ENTER_MONEY);
        int money = io.inputMoney();

        BuyLotto buyLotto = new BuyLotto(money);
        io.outputLottoCount(buyLotto.lottoCount);

        List<List<Integer>> lottoSet = buyLotto.getLottoSet(buyLotto.lottoCount);
        io.printLottoSet(lottoSet);

        System.out.println(io.PLEASE_ENTER_NUMBERS);
        List<Integer> inputNumbers = io.inputNumbers();

        // 당첨번호를 Lotto 클래스에 저장하여 검증
        new Lotto(inputNumbers);

        System.out.println(io.PLEASE_ENTER_BONUS_NUMBER);
        io.inputBonusNumber(inputNumbers);

        Calculator calculator = new Calculator(lottoSet, inputNumbers);
        List<Integer> result = calculator.getResult();

        io.printResult(result);
        io.printRateOfReturn(calculator.getRateOfReturn(money, result));
    }
}
