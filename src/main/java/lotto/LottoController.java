package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    int BonusNumber;
    public void start(){
        Number_of_Lotto number_of_lotto = inputMoney();
        int Number_of_Purchase = number_of_lotto.Count_Number_of_Lotto();
        LottoView.printNumber_of_Purchase(Number_of_Purchase);
        List<Lotto> lottos = generateLottoNumbers.generate(Number_of_Purchase);
        LottoView.printLottos(lottos);
        WinningNumbers WinningNumbers = createWinningNumber();

    }
    private Number_of_Lotto inputMoney(){
        return new Number_of_Lotto(LottoView.inputMoney());
    }
    private WinningNumbers createWinningNumber(){
        return new WinningNumbers(inputWinningNumber(), inputBonusNumber());
    }
    private Lotto inputWinningNumber(){
        LottoView.printInputWinningNumber();
        int[] WiningNumber = Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        return new Lotto(Arrays.stream(WiningNumber).boxed().collect(Collectors.toList()));
    }
    private int inputBonusNumber(){
        LottoView.printInputBonusNumber();
        return Integer.parseInt(Console.readLine());
    }
}
