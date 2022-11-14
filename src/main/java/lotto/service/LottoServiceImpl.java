package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.vo.Lotto;
import lotto.vo.LottoPurchaseInfo;
import lotto.vo.LottoWinNumberInfo;

public class LottoServiceImpl implements LottoService {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    @Override
    public LottoPurchaseInfo getLottoPurchase() {
        int lottoPrice = ConvertMoneyStringToInteger(inputView.getPrice());
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(lottoPrice);
        outputView.printPurchaseMessage(lottoPurchaseInfo.getLottoGameCount());
        return lottoPurchaseInfo;
    }

    @Override
    public LottoWinNumberInfo getLottoWinNumbers() {
        String inputWinNumbers = inputView.getNumbers();
        LottoWinNumberInfo lottoWinNumberInfo = new LottoWinNumberInfo(inputWinNumbers);
        return lottoWinNumberInfo;
    }

    @Override
    public LottoWinNumberInfo getLottoBonusNumber() {
        int inputBonusNumber = ConvertMoneyStringToInteger(inputView.getBonus());
        LottoWinNumberInfo lottoWinNumberInfo = new LottoWinNumberInfo(inputBonusNumber);
        return lottoWinNumberInfo;
    }

    @Override
    public List<Lotto> createLottoNumbers(int lottoGameCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < lottoGameCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(new Lotto(numbers));
        }
        return lottoNumbers;
    }


    private int ConvertMoneyStringToInteger(String money) {
        return Integer.parseInt(money);
    }
}
