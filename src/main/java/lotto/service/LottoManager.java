package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import lotto.utils.constants.Comment;
import lotto.utils.constants.IntegerCommon;
import lotto.utils.constants.LottoConstant;
import lotto.domain.Lotto;
import lotto.utils.iosupport.LottoPrinter;
import lotto.utils.validator.UserMoneyValidator;

public class LottoManager {

    public void run() {
        long purchaseAmount = processPurchase();
        List<Lotto> lottoNumbers = processLottoNumbers(purchaseAmount);
    }

    private List<Lotto> processLottoNumbers(long purchaseAmount) {
        List<Lotto> lottoNumbers = generateLottoNumbers(purchaseAmount);
        LottoPrinter.printLottoLists(lottoNumbers);
        return lottoNumbers;
    }

    private long processPurchase() {
        long purchaseAmount = getPurchaseAmount();
        LottoPrinter.printPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public long getPurchaseAmount() throws IllegalArgumentException {
        System.out.println(Comment.INPUT_AMOUNT.getComment());
        String purchaseMoney = Console.readLine();

        UserMoneyValidator.validate(purchaseMoney);
        return Long.parseLong(purchaseMoney) / LottoConstant.LOTTO_AMOUNT_UNIT.getNumber();
    }

    private List<Lotto> generateLottoNumbers(long purchaseAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        LongStream.range(IntegerCommon.ZERO.getNumber(), purchaseAmount)
                .forEach((index) -> {
                    Lotto lotto = new Lotto(LottoNumberGenerator.generate());
                    lottoNumbers.add(lotto);
                });

        return lottoNumbers;
    }
}
