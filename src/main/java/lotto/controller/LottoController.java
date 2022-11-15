package lotto.controller;

import lotto.constant.enumtype.UserInterfaceMessage;
import lotto.service.LottoBonusService;
import lotto.service.LottoInputDrawNumberService;
import lotto.service.LottoInputService;
import lotto.service.LottoNumberCompareService;
import lotto.service.LottoPublishService;

public class LottoController {
    private LottoInputService lottoInputService = LottoInputService.getInstance();
    private LottoPublishService lottoPublishService = LottoPublishService.getInstance();
    private LottoInputDrawNumberService lottoInputDrawNumberService = LottoInputDrawNumberService.getInstance();
    private LottoBonusService lottoBonusService = LottoBonusService.getInstance();
    private LottoNumberCompareService lottoNumberCompareService = LottoNumberCompareService.getInstance();

    public void inputLottoInfo() {
        try {
            String lottoPrice = lottoInputService.inputLottoPrice();
            printPublishedLotto(lottoPrice);
            lottoInputDrawNumberService.inputDrawNumber();
            lottoBonusService.inputLottoBonusNumber(lottoInputDrawNumberService.getLottoDrawNumber());
            lottoNumberCompareService.inputNumber(lottoPublishService.getPublishedLottoNumbers(),
                    lottoInputDrawNumberService.getLottoDrawNumber(),lottoBonusService.getLottoBonusNumber(),
                    Integer.parseInt(lottoPrice));

            lottoNumberCompareService.initMatchResult();
            lottoNumberCompareService.calcResult();
            lottoNumberCompareService.printResult();
//            lottoNumberCompareService.initCompareResult();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void printPublishedLotto(String lottoPrice) {
        lottoPublishService.lottoPublish(lottoPrice);
        System.out.println(String.format(UserInterfaceMessage.COUNT_BOUGHT.getValue(),
                lottoPublishService.getBoughtLottoCount()));
        lottoPublishService.printPublishedLottoNumbers();
    }
}
