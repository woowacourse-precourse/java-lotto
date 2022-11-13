package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    int Number_of_Purchase;
    int BonusNumber;
    List<Lotto> lottos = new ArrayList<>();
    Lotto WinningNumber;
    public void start(){
        Number_of_Lotto number_of_lotto = inputMoney();
        Number_of_Purchase = number_of_lotto.Count_Number_of_Lotto();
        LottoView.printNumber_of_Purchase(Number_of_Purchase);
        lottos = generateLottoNumbers.generate(Number_of_Purchase);
        LottoView.printLottos(lottos);
        WinningNumber = inputWinningNumber();
        BonusNumber = inputBonusNumber(WinningNumber);

    }
    private Number_of_Lotto inputMoney(){
        return new Number_of_Lotto(LottoView.inputMoney());
    }
    private Lotto inputWinningNumber(){
        LottoView.printInputWinningNumber();
        int[] WiningNumber = Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        return new Lotto(Arrays.stream(WiningNumber).boxed().collect(Collectors.toList()));
    }
    private int inputBonusNumber(Lotto WinningNumber){
        LottoView.printInputBonusNumber();
        int BonusNumber = Integer.parseInt(Console.readLine());
        if (BonusNumber < 1 || BonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (WinningNumber.getNumbers().stream().anyMatch(number -> number.equals(BonusNumber))){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹치지 않아햐 합니다.");
        }
        return BonusNumber;
    }
}
