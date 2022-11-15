package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exception.ExceptionCode.INVALID_BONUS_NUMBER_INPUT;
import static lotto.exception.ExceptionCode.INVALID_MONEY_INPUT;
import static lotto.exception.ExceptionCode.INVALID_WINNING_NUMBER_INPUT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LotteryShop {

    private final static String REGEX = ",";
    private final static int INCLUDE_EMPTY_SPLIT_OPTION = -1;
    private final static String REQUEST_MONEY = "구입 금액을 입력해 주세요.";
    private final static String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String PURCHASED_LOTTO_SIZE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private final static String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---\n";
    private final static String REWARD_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    public void open() {
        Money money = new Money(receiveMoney());
        List<Lotto> purchasedLotto = purchaseLotto(money);
        print(purchasedLotto);

        WinningLotto winningLotto = getWinningLotto();

        printResult(getLottoResult(purchasedLotto, winningLotto), money);
    }

    private long receiveMoney() {
        try {
            System.out.println(REQUEST_MONEY);
            return Long.parseLong(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_MONEY_INPUT);
        }
    }

    private List<Lotto> purchaseLotto(Money money) {
        long lottoPurchaseAmount = money.getLottoPurchaseAmount();
        List<Lotto> purchasedLotto = new ArrayList<>();
        while (lottoPurchaseAmount-- > 0) {
            purchasedLotto.add(Lotto.generateRandomLotto());
        }
        return purchasedLotto;
    }

    private void print(List<Lotto> purchasedLotto) {
        System.out.printf(PURCHASED_LOTTO_SIZE_MESSAGE, purchasedLotto.size());
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }

    private WinningLotto getWinningLotto() {
        return new WinningLotto(new Lotto(getWinningLottoNumbers()), new LottoNumber(getBonusNo()));
    }

    private List<Integer> getWinningLottoNumbers() {
        try {
            System.out.println();
            System.out.println(REQUEST_WINNING_NUMBER);
            return Stream.of(readLine().split(REGEX, INCLUDE_EMPTY_SPLIT_OPTION))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_INPUT);
        }
    }

    private int getBonusNo() {
        try {
            System.out.println();
            System.out.println(REQUEST_BONUS_NUMBER);
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_INPUT);
        }
    }

    private LottoResult getLottoResult(List<Lotto> purchasedLotto, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : purchasedLotto) {
            lottoResult.putRank(winningLotto.match(lotto));
        }
        return lottoResult;
    }

    private void printResult(LottoResult lottoResult, Money money) {
        System.out.print(WINNING_STATISTICS_MESSAGE);
        System.out.print(lottoResult);
        System.out.printf(REWARD_MESSAGE, money.getEarningRate(lottoResult.getReward()));
    }
}
