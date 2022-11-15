package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lotto.utils.constants.Comment;
import lotto.utils.constants.IntegerCommon;
import lotto.utils.constants.ErrorMessage;
import lotto.utils.constants.LottoConstant;
import lotto.domain.Lotto;
import lotto.utils.iosupport.LottoPrinter;
import lotto.utils.validator.UserMoneyValidator;

public class LottoManager {

    private static final String regex = ",";

    public void run() {
        long purchaseAmount = processPurchase();
        List<Lotto> lottoNumbers = processLottoNumbers(purchaseAmount);
        Lotto winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        isValidBonusNumber(winningNumbers, bonusNumber);
        processWinningStats(purchaseAmount, lottoNumbers, winningNumbers, bonusNumber);
    }

    private void processWinningStats(long purchaseAmount, List<Lotto> lottoNumbers,
                                     Lotto winningNumbers, int bonusNumber) {
        WinningStatsCalculator winningStatsCalculator =
                new WinningStatsCalculator(lottoNumbers, winningNumbers, bonusNumber, purchaseAmount);

        LottoPrinter.printWinningStats(
                winningStatsCalculator.getWinningStats(),
                winningStatsCalculator.getReturnRate()
        );
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

    private Lotto getWinningNumbers() {
        System.out.println();
        System.out.println(Comment.INPUT_WINNING_NUMBER.getComment());
        String winningNumbers = Console.readLine();
        try {
            List<Integer> numbers = Arrays.stream(winningNumbers.split(regex))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_TYPE.getMessage());
        }
    }

    private int getBonusNumber() {
        System.out.println(Comment.INPUT_BONUS_NUMBER.getComment());
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_TYPE.getMessage());
        }
    }

    private void isValidBonusNumber(Lotto lottoNumbers, int bonusNumber) {
        if (lottoNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }
}
