package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.UserInterfaceMessage;

public class LottoInputService {
    private LottoInputService() {
    }

    private static class InnerLottoInputService {
        private static final LottoInputService instance = new LottoInputService();
    }

    public static LottoInputService getInstance() {
        return InnerLottoInputService.instance;
    }

    public String inputLottoPrice() {
        System.out.println(UserInterfaceMessage.REQUEST_INPUT_PRICE.getValue());
        return validateInputLottoPrice(readLine());
    }

    private String validateInputLottoPrice(String lottoPrice) {
        lottoPrice = lottoPrice.strip();
        lottoPrice = lottoPrice.replace(",", "");
        try {
            Integer.parseInt(lottoPrice);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(UserInterfaceMessage.ERROR_INPUT_BUY_INFO.getValue());
        }

        return lottoPrice;
    }
}
