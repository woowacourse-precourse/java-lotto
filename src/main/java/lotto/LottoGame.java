package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자가 입력되지 않았습니다.";
    private static final String MONEY_INPUT_ERROR_MESSAGE = "[ERROR] 금액을 1000원 단위로 입력해주세요.";
    private static final String BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 보너스번호와 당첨번호가 중복됩니다.";
    private static final String WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨번호에 숫자를 입력해주세요.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45의 번호가 아닙니다.";
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String RESULT_INFO_MESSAGE = "당첨 통계\n---";
    private static final Integer LOTTO_PRICE = 1000;

    private static final Integer[] winningPrizes = {2000000000, 30000000, 1500000, 50000, 5000};

    private Lotto winningNumbers;
    private int bonusNumber;

    public void setBonusNumbers() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        int bonusNumber = convertNumbers(Console.readLine()).get(0);
        checkBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
        System.out.println();
    }

    private void checkBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
        for (int number : winningNumbers.getNumbers()) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE);
            }
        }
    }

    public void setWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        this.winningNumbers = new Lotto(convertNumbers(Console.readLine()));
        System.out.println();
    }

    public List<Integer> convertNumbers(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Lotto> buyLotto() {
        int money = inputMoney();
        int lottoNum = countLotto(money);
        return pickLottoList(lottoNum);
    }

    private List<Lotto> pickLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");

        while (count > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            System.out.println(numbers.toString());
            count -= 1;
        }
        System.out.println();
        return lottoList;
    }

    public int countLotto(int money) {
        if (money == 0 || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR_MESSAGE);
        }
        return money / LOTTO_PRICE;
    }

    private int inputMoney() {
        try {
            System.out.println(MONEY_INPUT_MESSAGE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    public void printResult(LottoSet lottoSet) {
        List<Integer> result = lottoSet.checkWinning(this.winningNumbers.getNumbers(), this.bonusNumber);
        int inputMoney = lottoSet.getInputMoney();

        System.out.println(RESULT_INFO_MESSAGE);
        for (int index = result.size() - 1; index >= 0; index--) {
            int ranking = index + 1;
            int count = result.get(index);

            System.out.println(makeRankingMessage(ranking, count));
        }
        int totalWinngingPrize = getTotalPrize(result);
        System.out.println(makeProfitMessage((double)inputMoney, (double)totalWinngingPrize));
    }

    private int getTotalPrize(List<Integer> result) {
        int totalWinngingPrize = 0;
        for (int index = 0; index < result.size(); index++) {
            int count = result.get(index);
            int winningPrize = winningPrizes[index];
            totalWinngingPrize += count * winningPrize;
        }
        return totalWinngingPrize;
    }

    private String makeProfitMessage(Double inputMoney, Double totalWinngingPrize) {
        Double profit = totalWinngingPrize / inputMoney * 100;
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        return "총 수익률은 " + formatter.format(profit) + "%입니다.";
    }

    private String makeRankingMessage(int ranking, int count) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        if (ranking == 1) {
            return "6개 일치 (" + formatter.format(winningPrizes[ranking - 1]) + "원) - " + count + "개";
        }
        if (ranking == 2) {
            return "5개 일치, 보너스 볼 일치 (" + formatter.format(winningPrizes[ranking - 1]) + "원) - " + count + "개";
        }
        return 7 - ranking + 1 + "개 일치 (" + formatter.format(winningPrizes[ranking - 1]) + "원) - " + count + "개";
    }
}
