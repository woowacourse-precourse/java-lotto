package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값을 입력하였습니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위입니다.";
    private static final String LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개입니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호가 존재합니다.";

    public static void main(String[] args) {
        int inputMoney = 0;
        int lottoQuantity = 0;
        List<Lotto> lottos = new ArrayList<>();
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();

        try {
            inputMoney = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        if (inputMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }

        lottoQuantity = inputMoney / LOTTO_PRICE;
        System.out.printf("\n%d개를 구매했습니다.\n", lottoQuantity);

        for (int cnt = 0; cnt < lottoQuantity; cnt++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
            lotto.sort();
            lottos.add(lotto);
            System.out.println(lotto);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        userInput = Console.readLine();
        Set<Integer> checkDuplicatedNumbers = new HashSet<>();
        String[] splitInput = userInput.split(",");

        if (splitInput.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }

        for (int cnt = 0; cnt < LOTTO_NUMBER_COUNT; cnt++) {
            int currNum;

            try {
                currNum = Integer.parseInt(splitInput[cnt].trim());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
            }

            if (currNum < MIN_LOTTO_NUMBER || currNum > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }

            checkDuplicatedNumbers.add(currNum);

            if (checkDuplicatedNumbers.size() != cnt + 1) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE);
            }
        }

        List<Integer> winningNumbers = new ArrayList<>(checkDuplicatedNumbers);
        winningNumbers.sort(Integer::compareTo);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        userInput = Console.readLine();
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(userInput.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }

        if (checkDuplicatedNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE);
        }

        Map<Rank, Integer> rankCounts = new HashMap<>(Map.of(
                Rank.FIFTH, 0,
                Rank.FORTH, 0,
                Rank.THIRD, 0,
                Rank.SECOND, 0,
                Rank.FIRST, 0));

        for (Lotto lotto : lottos) {
            int matchCount = lotto.compareWithWinningNumbers(winningNumbers);
            Rank rank = Rank.getRankByMatchCount(matchCount, lotto.contains(bonusNumber));

            if (rank != Rank.NONE) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
        }

        System.out.println("\n당첨 통계");
        System.out.println("---");

        List<Rank> ranks = new ArrayList<>(rankCounts.keySet());
        ranks.sort(Rank::compareTo);
        long totalPrize = 0L;

        for (Rank rank : ranks) {
            int rankCount = rankCounts.get(rank);
            totalPrize += ((long) rank.getPrize()) * rankCount;
            System.out.printf(rank + " - %d개\n", rankCounts.get(rank));
        }

        double rateOfReturn = Math.round(((double) totalPrize / inputMoney) * 1000) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
