package lotto;

import camp.nextstep.edu.missionutils.Console;
import domain.Money;
import dto.ResultDto;
import ui.Printer;
import util.RandomNumberFactory;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private final static Integer START = 1;
    private final static Integer END = 45;
    private final static Integer COUNT = 6;
    private final static Integer MONEY_TARGET = 1000;
    private static List<Lotto> boughtLottos = new ArrayList<>();
    private static Printer printer = new Printer();
    private static RandomNumberFactory randomNumberFactory = new RandomNumberFactory(START, END, COUNT);
    private static LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        try {
            printer.printEnterPurchaseAmount();
            Money money = new Money(Console.readLine());
            Integer numberOfPurchases = money.getValue() / MONEY_TARGET;
            printer.printBoughtNum(numberOfPurchases);
            for (int i=0; i<numberOfPurchases; i++)
                boughtLottos.add(new Lotto(randomNumberFactory.makeUniqueNumbersInRange()));
            printer.printLotto(boughtLottos);

            printer.printEnterWinningNumber();
            Lotto winningLotto = lottoService.makeLottoFromInput(Console.readLine());

            printer.printEnterBonusNumber();
            Integer bonus = Integer.parseInt(Console.readLine());

            ResultDto dto = winningLotto.getResult(boughtLottos, bonus);
            dto = lottoService.makeGrossReturn(dto, (double) money.getValue());
            printer.printWinningStatistics(dto);
        }
        catch (IllegalArgumentException exception) {
            printer.printErrorMessage(exception);
            return;
        }
    }
}
