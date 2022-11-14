package lotto.service;

import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.vo.LottoPurchaseInfo;
import lotto.vo.LottoWinNumberInfo;

public class LottoServiceImpl implements LottoService {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    @Override
    public LottoPurchaseInfo LottoPurchaseServcie() {
        int lottoPrice = ConvertMoneyStringToInteger(inputView.getPrice());
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(lottoPrice);
        outputView.printPurchaseMessage(lottoPurchaseInfo.getLottoGameCount());
        return lottoPurchaseInfo;
    }

    @Override
    public LottoWinNumberInfo lottoNumbersService() {
        String inputWinNumbers = inputView.getNumbers();
        LottoWinNumberInfo lottoWinNumberInfo = new LottoWinNumberInfo(inputWinNumbers);
        return lottoWinNumberInfo;
    }

    @Override
    public LottoWinNumberInfo lottoBonusNumberService() {
        int inputBonusNumber = ConvertMoneyStringToInteger(inputView.getBonus());
        LottoWinNumberInfo lottoWinNumberInfo = new LottoWinNumberInfo(inputBonusNumber);
        return lottoWinNumberInfo;
    }


    private int ConvertMoneyStringToInteger(String money) {
        return Integer.parseInt(money);
    }
}
