package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.util.LottoUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.service.ExceptionHandler.validateBonusNumber;
import static lotto.values.Constants.Digit.LOTTO_PRICE;
import static lotto.values.Constants.Util.LOTTO_NUMBER_SEPARATOR;

public class LottoService {
    private static final LottoService lottoService = new LottoService();

    public static LottoService getLottoService(){
        return lottoService;
    }

    public List<Lotto> generateLottos(int lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(sortLottoNumbers(lottoNumbers)));
        }
        return lottos;
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        Stream<Integer> sortedNumbers = lottoNumbers.stream().sorted();

        return sortedNumbers.collect(Collectors.toList());
    }

    public Lotto generateWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();

        return new Lotto(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        String inputNumbers = Console.readLine();
        String[] splitNumbers = inputNumbers.split(LOTTO_NUMBER_SEPARATOR);

        for (String splitNumber : splitNumbers) {
            int number = Integer.parseInt(splitNumber);
            winningNumbers.add(number);
        }

        return winningNumbers;
    }

    public int generateBonusNumber() {
        int bonusNumber = getBonusNumber();
        validateBonusNumber(bonusNumber);

        return bonusNumber;
    }

    public int getBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public int getLottoCntByMoney(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    private int calculateProfit(LinkedHashMap<Integer, Integer> rankData) {
        int totalProfit = 0;
        RankService rankService = RankService.getRankService();
        Set<Integer> ranking = rankData.keySet();

        for (Integer rank : ranking) {
            Integer cnt = rankData.get(rank);
            totalProfit += rankService.calculateRankingPrize(rank, cnt);
        }
        return totalProfit;
    }

    public String getProfitPercentage(Rank rank, int inputMoney) {
        int totalProfit = calculateProfit(rank.getRank());
        double profitPercent = (double) totalProfit / (double) inputMoney * 100.0;
        String roundedPercent = String.format("%.1f", profitPercent);
        return roundedPercent;
    }
}