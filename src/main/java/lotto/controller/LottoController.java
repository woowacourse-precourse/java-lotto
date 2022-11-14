package lotto.controller;

import lotto.constant.enumtype.UserInterfaceMessage;
import lotto.service.LottoInputDrawNumberService;
import lotto.service.LottoInputService;
import lotto.service.LottoPublishService;

public class LottoController {
    private LottoInputService lottoInputService = LottoInputService.getInstance();
    private LottoPublishService lottoPublishService = LottoPublishService.getInstance();
    private LottoInputDrawNumberService lottoInputDrawNumberService = LottoInputDrawNumberService.getInstance();

    public void inputLottoInfo() {
        try {
            String lottoPrice = lottoInputService.inputLottoPrice();
            printPublishedLotto(lottoPrice);
            lottoInputDrawNumberService.inputDrawNumber();
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
