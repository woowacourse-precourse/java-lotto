package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Application {

    public static boolean isMultipleThousands(int number) {
        return number % 1000 == 0;
    }

    public static void validateLottoPrice(String priceString) {
        int price;
        try {
            price = Integer.parseInt(priceString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (!isMultipleThousands(price)) {
            throw new IllegalArgumentException();
        }
    }

    public static int readLottoPrice() {
        String priceString = Console.readLine();
        validateLottoPrice(priceString);
        return Integer.parseInt(priceString);
    }

    public static List<Lotto> buyLottoList(int price) {
        int count = price / 1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        String[] stringLotto = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : stringLotto) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public static int readBonusNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static void printSortedLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static HashMap<Rank, Integer> countWinningRank(List<Rank> statistics) {
        HashMap<Rank, Integer> countWinningRank = new HashMap<>();
        for (Rank rank : Rank.values()) {
            int count = Collections.frequency(statistics, rank);
            countWinningRank.put(rank, count);
        }
        return countWinningRank;
    }

    public static void printStatistics(List<Rank> statistics) {
        HashMap<Rank, Integer> countWinningRank = countWinningRank(statistics);
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getResultText() + " - " + countWinningRank.get(rank) + "개");
        }
    }

    public static void printEarnPriceRate(Double EarnPriceRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarnPriceRate) + "%입니다.");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price;
        List<Lotto> lottoList;
        List<Integer> winningNumbers;
        int bonusNumber;

        try {
            price = readLottoPrice();
            lottoList = buyLottoList(price);
            winningNumbers = readWinningNumbers();
            bonusNumber = readBonusNumber();

        } catch (Exception e) {
            System.out.println("[ERROR] 입력이 올바르지 않습니다.");
            return;
        }

        LottoGame lottoGame = new LottoGame(price, lottoList, winningNumbers, bonusNumber);
        printSortedLottoList(lottoGame.getSortedLottoList());

        List<Rank> statistics = lottoGame.getStatistics();
        printStatistics(statistics);

        Double EarnPriceRate = lottoGame.getEarnPriceRate();
        printEarnPriceRate(EarnPriceRate);
    }
}
