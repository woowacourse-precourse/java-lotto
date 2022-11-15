package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.uility.Utility;
import lotto.vo.Lotto;
import lotto.vo.LottoPurchaseInfo;
import lotto.vo.LottoWinNumberInfo;

public class LottoServiceImpl implements LottoService {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public LottoPurchaseInfo getLottoPurchase() {
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(inputView.getPrice());
        outputView.printPurchaseMessage(lottoPurchaseInfo.getLottoGameCount());
        return lottoPurchaseInfo;
    }

    @Override
    public String getLottoWinNumbers() {
        String inputWinNumbers = inputView.getNumbers();
        return inputWinNumbers;
    }

    @Override
    public int getLottoBonusNumber() {
        int inputBonusNumber = Utility.ConvertMoneyStringToInteger(inputView.getBonus());
        return inputBonusNumber;
    }

    @Override
    public List<Lotto> createLottoNumbers(int lottoGameCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoGameCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
            lottoNumbers.add(new Lotto(numbers));
        }
        return lottoNumbers;
    }

    @Override
    public List<String> getLottoRank(List<Lotto> lottoNumbers,
        LottoWinNumberInfo lottoWinNumberInfo) {
        List<String> result = new ArrayList<>();
        for (Lotto lotto : lottoNumbers) {
            result.add(Utility.checkLottoRank(lotto.getNumbers(), lottoWinNumberInfo));
        }
        return result;
    }
}
