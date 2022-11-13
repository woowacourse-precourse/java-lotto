package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        int money = getMoneyInput();
        int lottoTicketNumber = calculateHowManyTicketUserCanBuy(money);
        System.out.printf("%d개를 구매했습니다.\n", lottoTicketNumber);
        List<Lotto> lottoList = buyManyLotto(lottoTicketNumber);
        printLottoList(lottoList);
        LottoWinNumber lottoWinNumber = new LottoWinNumber(getLottoWinNumbersInput(),
            getBonusNumberInput());
        Map<LottoResult, Integer> statistics = compileStatistics(lottoList, lottoWinNumber);
        double rateOfReturn = calculateRateOfReturn(statistics, lottoTicketNumber);
        printStatistics(statistics, rateOfReturn);
    }

    private static int getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        int moneyInput = getIntegerInput();
        if (moneyInput < 0) {
            throw new IllegalArgumentException();
        }
        return moneyInput;
    }

    private static int getIntegerInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int calculateHowManyTicketUserCanBuy(int money) {
        return money / LottoWinNumber.price;
    }

    private static List<Lotto> buyManyLotto(int lottoTicketNumber) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoTicketNumber; i++) {
            lottoList.add(buyLotto());
        }
        return lottoList;
    }

    private static Lotto buyLotto() {
        return new Lotto(pickLottoNumbersByRandom());
    }

    private static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        System.out.print(numbers.stream()
            .map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.print("]\n");
    }

    private static List<Integer> pickLottoNumbersByRandom() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static List<Integer> getLottoWinNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String oneLine = Console.readLine();
        try {
            return Arrays.stream(oneLine.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int getBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getIntegerInput();
    }

    private static Map<LottoResult, Integer> compileStatistics(List<Lotto> lottoList,
        LottoWinNumber answer) {
        Map<LottoResult, Integer> statistics = prepareStatistics();
        for (Lotto lotto : lottoList) {
            LottoResult key = LottoMarker.produceWinningStatistic(answer, lotto);
            statistics.put(key, statistics.get(key) + 1);
        }
        return statistics;
    }

    private static double calculateRateOfReturn(Map<LottoResult, Integer> statistics,
        int lottoTicketNumber) {
        int cashPrizeSum = 0;
        for (Map.Entry<LottoResult, Integer> entry : statistics.entrySet()) {
            cashPrizeSum += entry.getKey().getCashPrize() * entry.getValue();
        }
        return Math.round(cashPrizeSum * 10 / (double) lottoTicketNumber) / 10.0;
    }

    private static Map<LottoResult, Integer> prepareStatistics() {
        Map<LottoResult, Integer> statistics = new HashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            statistics.put(lottoResult, 0);
        }
        return statistics;
    }


    private static void printStatistics(Map<LottoResult, Integer> statistics, double rateOfReturn) {
        System.out.printf("당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - %d개\n"
                + "4개 일치 (50,000원) - %d개\n"
                + "5개 일치 (1,500,000원) - %d개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
                + "6개 일치 (2,000,000,000원) - %d개\n"
                + "총 수익률은 %.01f%%입니다.\n", statistics.get(LottoResult.RANK_FIVE),
            statistics.get(LottoResult.RANK_FOUR), statistics.get(LottoResult.RANK_THREE),
            statistics.get(LottoResult.RANK_TWO), statistics.get(LottoResult.RANK_ONE), rateOfReturn
        );
    }

}
