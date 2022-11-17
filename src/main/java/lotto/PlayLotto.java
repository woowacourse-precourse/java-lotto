package lotto;

import lotto.Result.Result;
import lotto.number.LottoNumber;
import lotto.receiver.Receiver;
import lotto.validate.ValidateNumber;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {

    public static void run() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList = LottoNumber.generateLottoNumber(Receiver.receiveHowMuch());
        Lotto lotto = new Lotto(Receiver.receiveWinNumber());
        Integer bonusNumber = Receiver.receiveBonusNumber();
        ValidateNumber.validateBonusNumber(bonusNumber, lotto);
        Result.checkResult(lottoList, lotto, bonusNumber);
    }
}
