package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.LottoRule;
import lotto.constant.enumtype.UserInterfaceMessage;
import lotto.domain.lotto.repository.Lotto;

public class LottoPublishService {
    private List<Lotto> publishedLottoNumbers = new ArrayList<>();
    private Integer lottoPrice;
    private Integer boughtLottoCount;

    private LottoPublishService() {
    }

    private static class InnerLottoPublishService {
        private static LottoPublishService instance = new LottoPublishService();
        private static void renewInstance() {
            instance = null;
            instance = new LottoPublishService();
        }
    }

    public static LottoPublishService getInstance() {
        return InnerLottoPublishService.instance;
    }
    public static LottoPublishService getRenewInstance() {
        InnerLottoPublishService.renewInstance();
        return InnerLottoPublishService.instance;
    }

    private void createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumberInclusive.START.getValue(),
                LottoNumberInclusive.END.getValue(),
                LottoRule.LOTTO_MAX_COUNT.getValue());
        publishedLottoNumbers.add(new Lotto(numbers));
    }

    public List<Lotto> getPublishedLottoNumbers() {
        return publishedLottoNumbers;
    }

    public void lottoPublish(String price) {
        lottoPrice = String2Integer(price);
        boughtLottoCount(lottoPrice);
        for (int i = 1; i <= boughtLottoCount; i++) {
            createLottoNumber();
        }
    }

    private Integer String2Integer(String numberformat) {
        Integer price = 0;
        try {
            price = Integer.parseInt(numberformat);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_INCLUSIVE.getValue(),
                    LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
        }
        return price;
    }

    private void boughtLottoCount(Integer lottoPrice) {
        boughtLottoCount = lottoPrice / LottoRule.LOTTO_PRICE.getValue();
    }

    public Integer getBoughtLottoCount() {
        return boughtLottoCount;
    }

    public void printPublishedLottoNumbers() {
        for (Lotto publishedLotto : publishedLottoNumbers) {
            System.out.println(publishedLotto.getNumbers());
        }
    }
}
