package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.ui.LottoGameUi;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int PERCENTAGE = 100;
    private final LottoGameUi lottoGameUi = new LottoGameUi();

    public void start() {
        int lottoAmount = getLottoAmount();

        List<Lotto> lottos;
        lottos = createLottos(lottoAmount);

        WinningLotto winningLotto = createWinningLotto();

        lottoResultStatistics(lottos, winningLotto);
    }

    private int getLottoAmount() {
        int payment = getPayment();

        return (payment / TICKET_PRICE);
    }

    private int getPayment() {
        lottoGameUi.printPaymentRequestMessage();
        String payment = readLine();

        if (!isValidPayment(payment)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 올바르지 않습니다.");
        }

        return Integer.parseInt(payment);
    }

    private boolean isValidPayment(String payment) {
        if (!isValidPaymentCharacter(payment) || !isValidPaymentScope(payment) || !isValidPaymentUnit(payment)) {
            return false;
        }

        return true;
    }

    private boolean isValidPaymentCharacter(String payment) {
        try {
            Integer.parseInt(payment);
        } catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }

        return true;
    }

    private boolean isValidPaymentScope(String payment) {
        return Integer.parseInt(payment) > 0;
    }

    private boolean isValidPaymentUnit(String payment) {
        return Integer.parseInt(payment) % TICKET_PRICE == 0;
    }

    private List<Lotto> createLottos(int lottoAmount) {
        lottoGameUi.printPurchaseHistory(lottoAmount);

        List<Lotto> lottos = new ArrayList<>();

        for (int idx = 0; idx < lottoAmount; idx++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                LOTTO_NUMBERS_SIZE);

        LottoGameUi.printLottoNumbers(lottoNumbers);

        return new Lotto(lottoNumbers);
    }


    private WinningLotto createWinningLotto() {
        Lotto lotto = new Lotto(getWinningNumbers());
        int bonusNumber = getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }

    private List<Integer> getWinningNumbers() {
        lottoGameUi.printWinningNumberRequestMessage();

        List<Integer> winningNumbers = new ArrayList<>();
        String winningNumbersWithComma = readLine();
        List<String> numbers = List.of(winningNumbersWithComma.split(","));

        if (!isValidWinningNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 올바르게 입력되지 않았습니다.");
        }

        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    private boolean isValidWinningNumbers(List<String> numbers) {
        if (!isValidWinningNumbersSize(numbers) || !isValidWinningNumbersScope(numbers)) {
            return false;
        }
        return true;
    }

    private boolean isValidWinningNumbersSize(List<String> numbers) {
        return numbers.size() == 6;
    }

    private boolean isValidWinningNumbersScope(List<String> numbers) {
        for (String number : numbers) {
            if (!(Integer.parseInt(number) >= LOTTO_MIN_NUMBER && Integer.parseInt(number) <= LOTTO_MAX_NUMBER)) {
                return false;
            }
        }
        return true;
    }

    private int getBonusNumber() {
        lottoGameUi.printBonusNumberRequestMessage();

        String bonusNumber = readLine();
        if (!isValidBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 볼 번호가 올바르게 입력되지 않았습니다.");
        }

        return Integer.parseInt(bonusNumber);
    }

    private boolean isValidBonusNumber(String bonusNumber) {
        if (!(Integer.parseInt(bonusNumber) >= LOTTO_MIN_NUMBER && Integer.parseInt(bonusNumber) <= LOTTO_MAX_NUMBER)) {
            return false;
        }
        return true;
    }

    private void lottoResultStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = setResult();
        Rank rank;

        for (int idx = 0; idx < lottos.size(); idx++) {
            rank = winningLotto.match(lottos.get(idx));
            result.put(rank, result.get(rank) + 1);
        }

        LottoGameUi.printResult(result);

        int lottoAmount = lottos.size();
        printYieldRate(result, lottoAmount);
    }

    private Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        return result;
    }

    private void printYieldRate(Map<Rank, Integer> result, int lottoAmount) {
        double yieldRate = 0;

        for (Rank rank : result.keySet()) {
            yieldRate += (double) (rank.getWinningMoney()) * result.get(rank);
        }
        yieldRate = (yieldRate / (lottoAmount * TICKET_PRICE)) * PERCENTAGE;

        lottoGameUi.printYield(yieldRate);
    }
}
