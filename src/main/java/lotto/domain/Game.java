package lotto.domain;

import lotto.domain.money.Money;
import lotto.domain.money.ValidateMoney;
import lotto.domain.myLotto.Lotto;
import lotto.domain.winningLotto.ValidateWinningLotto;
import lotto.domain.winningLotto.WinningLotto;
import lotto.setting.Setting;
import lotto.ui.Output;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Game {

    public void start(){
        Money money = inputMoney();

        List<Lotto> myLotto = myLotto(money.countBoughtLotto());

        WinningLotto winningLotto = inputWinningLotto();
        winningLotto.statistics(myLotto);
        winningLotto.total(myLotto, money.getMoney());
    }

    public Money inputMoney(){
        Output.printInputMoney();
        String money = readLine();

        ValidateMoney validateMoney = new ValidateMoney();
        validateMoney.validate(money);

        return new Money(validateMoney.validatedMoneyToLong(money));
    }

    public List<Lotto> myLotto(int countBoughtLotto){
        List<Lotto> myLotto = new ArrayList<>();

        for(int i=0; i<countBoughtLotto; i++){
            List<Integer> boughtLotto = pickUniqueNumbersInRange(Setting.LOTTO_MIN_NUMBER, Setting.LOTTO_MAX_NUMBER, Setting.LOTTO_PICK_NUMBER);
            myLotto.add(new Lotto(boughtLotto));
            Output.printBoughtLottoNumbers(boughtLotto);
        }

        return myLotto;
    }

    public WinningLotto inputWinningLotto(){
        List<Integer> lottoNumbers = winningLottoNumbers();
        int bonusNumber = winningBonusNumber();

        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    public List<Integer> winningLottoNumbers(){
        Output.printInputWinningNumber();
        String lottoNumbers = readLine().replaceAll(" ", "");

        ValidateWinningLotto validateWinningLotto = new ValidateWinningLotto();
        validateWinningLotto.validateInputLottoNumber(lottoNumbers);

        return Arrays.stream(lottoNumbers.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    public int winningBonusNumber(){
        Output.printBonusNumber();
        String bonusNumber =  readLine();

        ValidateWinningLotto validateWinningLotto = new ValidateWinningLotto();
        validateWinningLotto.validateBonusNumberIsRightNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}
