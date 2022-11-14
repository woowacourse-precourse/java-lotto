package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoStatus;

import java.util.*;
import java.util.Map.Entry;

import static lotto.config.BaseValidation.INVALID_FORMAT;
import static lotto.config.BaseValidation.INVALID_LOTTO_STATUS;
import static lotto.config.Constant.*;
import static lotto.config.LottoStatus.*;

public class Checker {

    private final View view = new View();

    private List<Integer> winningNumbers = new ArrayList<>();
    private HashMap<LottoStatus, Integer> winningStats = new HashMap<>() {{
        put(THREE, 0);
        put(FOUR, 0);
        put(FIVE, 0);
        put(SIX_WITH_BONUS, 0);
        put(SIX, 0);
    }};
    private LottoStatus status = INVALID;
    private int bonusNumber;
    private int key;
    private double returnRate;

    public void insertWinningNumbers() {

        view.insertWinningNumber();
        String winningNumber = Console.readLine();

        try {
            int[] numbers = Arrays.stream(winningNumber.split(",")).mapToInt(Integer::parseInt).toArray();

            for (int number : numbers) {
                winningNumbers.add(number);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }

    }

    public void insertBonusNumber() {

        view.insertBonusNumber();

        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void checkMyLotto(List<Integer> lotto) {

        int oldCount;

        try {
            key = 0;
            checkNumber(lotto);
            status = status.getStatus(key);

            if (status == SIX_WITH_BONUS) { // 당첨 번호와 같은 번호가 6개이면 보너스 번호 당첨 여부 확인
                status = checkBonusNumber(lotto);
            }

            if (winningStats.containsKey(status)) {
                oldCount = winningStats.get(status);
                winningStats.replace(status, oldCount, oldCount + 1);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LOTTO_STATUS.getMessage());
        }

    }

    private void checkNumber(List<Integer> lotto) {
        for (int number : lotto) {
            if (winningNumbers.contains(number) || number == bonusNumber) {
                key++;
            }
        }
    }

    private LottoStatus checkBonusNumber(List<Integer> lotto) {
        if (lotto.contains(bonusNumber)) {
            return SIX_WITH_BONUS;
        }
        return SIX;
    }

    public HashMap<LottoStatus, Integer> getWinningStats() {
        return winningStats;
    }

    public void showWinningStats() {

        view.startWinningStats();

        for (Entry<LottoStatus, Integer> entry : winningStats.entrySet()) {

            view.showWinningStatsValueByKey(entry.getKey(), entry.getValue());

        }

    }

    public void calculateRateOfReturn(int payMoney) {

        double total = 0;

        for (Entry<LottoStatus, Integer> entry : winningStats.entrySet()) {

            LottoStatus status = entry.getKey();
            int count = entry.getValue();

            total += calculateTotalWinningAmount(status, count);

        }

        returnRate = (total / payMoney) * 100;

    }

    public double calculateTotalWinningAmount(LottoStatus status, int count) {

        if (status == THREE) {
            return THREE_PRICE * count;
        }

        if (status == FOUR) {
            return FOUR_PRICE * count;
        }

        if (status == FIVE) {
            return FIVE_PRICE * count;
        }

        if (status == SIX_WITH_BONUS) {
            return SIX_WITH_BONUS_PRICE * count;
        }

        if (status == SIX) {
            return SIX_PRICE * count;
        }

        return 0;
    }

    public double getReturnRate() {
        return returnRate;
    }

}
