package lotto.serviceImpl;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.util.LottoValues;
import lotto.domain.User;
import lotto.domain.util.Winning;
import lotto.service.GameService;

import java.util.ArrayList;
import java.util.List;

public class LottoGameServiceImpl implements GameService {
    private static final int percentCalculation = 100;

    @Override
    public void startGame() {

        User user = new User();

        System.out.println("구입금액을 입력해 주세요.");
        user.lottoPurchaseAmount(userInput());

        int lottoAmount = user.getPurchaseAmount();
        System.out.println(lottoAmount * LottoValues.LOTTO_AMOUNT.getValue() + "\n");
        System.out.println(lottoAmount + "개를 구매했습니다.");
        List<Lotto> winningNumbers = makeLottoWinningNumbers(lottoAmount);
        printWinningLottoNumber(winningNumbers);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        Lotto userNumber = new Lotto(userInput());
        user.setUserNumbers(userNumber);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = user.isValidBonusNumber(userInput());

        System.out.println("\n당첨 통계\n" + "---");
        confirmWinningCount(winningNumbers, userNumber, bonusNumber);
        printEarnRate(lottoAmount);
    }

    private String userInput() {
        return Console.readLine();
    }

    private void printEarnRate(int amount) {
        long total = printResultAnGetTotal();
        double earnRate = (double) total / (amount * LottoValues.LOTTO_AMOUNT.getValue());

        System.out.println(String.format("총 수익률은 %1$,.1f", (earnRate * percentCalculation)) + "%입니다.");
    }

    private long printResultAnGetTotal() {
        long total = 0L;

        for (Winning win : Winning.values()) {
            if (win == Winning.NOTHING) continue;
            System.out.println(win.getWinningMessage() + win.getCount() + "개");
            total += ((long) win.getCount() * win.getValue());
        }
        return total;
    }

    public void confirmWinningCount(List<Lotto> winningNumbers,
                                    Lotto userNumber,
                                    int bonusNumber) {
        for (Lotto winningNumber : winningNumbers) {
            int count = compareWinningAndUserInput(winningNumber, userNumber, bonusNumber);

            Winning.findWinningValue(count, winningNumber, bonusNumber);
        }
    }

    private int compareWinningAndUserInput(Lotto winningNumber,
                                           Lotto userNumber,
                                           int bonusNumber) {
        int count = 0;
        for (int user : userNumber.getNumbers()) {
            if (winningNumber.getNumbers().contains(user)) count++;
        }

        if (!userNumber.getNumbers().contains(bonusNumber)
                && winningNumber.getNumbers().contains(bonusNumber)) count++;

        return count;
    }

    private void printWinningLottoNumber(List<Lotto> winningNumbers) {
        for (Lotto winningNumber : winningNumbers) {
            System.out.println(winningNumber.getNumbers().toString());
        }
    }

    public List<Lotto> makeLottoWinningNumbers(int lottoAmount) {
        List<Lotto> amount = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms
                    .pickUniqueNumbersInRange(LottoValues.START_LOTTO_VALUE.getValue(),
                            LottoValues.MAX_LOTTO_VALUE.getValue(),
                            LottoValues.COUNT.getValue());

            amount.add(new Lotto(numbers));
        }
        return amount;
    }
}
