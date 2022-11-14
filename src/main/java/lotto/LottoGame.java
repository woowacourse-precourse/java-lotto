package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    public void start() {
        User user = new User();
        List<List<Integer>> userLottos = user.buyLotto();

        Lotto mainNumber = new Lotto(inputMainNumber());
        LottoNumber bonusNumber = new LottoNumber(inputBonusNumber());

        inputWinningNumber(mainNumber, bonusNumber);

        Map<Rank, Integer> result = getResult(userLottos, mainNumber, bonusNumber);

        gameResult(result, user);
    }

    public List<Integer> inputMainNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] splitInputValue = Console.readLine().split(",");
        List<String> rawMainNumber = Arrays.asList(splitInputValue);
        List<Integer> mainNumbers = convertToNumber(rawMainNumber);
        for (int oneNumber : mainNumbers) {
            LottoNumber lottoMain = new LottoNumber(oneNumber);
        }
        return mainNumbers;
    }

    public List<Integer> convertToNumber(List<String> winningNumber) {
        List<Integer> winningNumbers = winningNumber.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int inputBonus = Integer.parseInt(Console.readLine());
        return inputBonus;
    }

    public void inputWinningNumber(Lotto mainNumber, LottoNumber bonusNumber) {
        compareMainWithBonus(mainNumber.getNumbers(), bonusNumber.getNumber());
    }

    public void compareMainWithBonus(List<Integer> winningNumbers, int inputBonusNumber) {
        if (winningNumbers.contains(inputBonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 포함되어 있습니다.");
        }
    }

    public Map<Rank, Integer> getResult(List<List<Integer>> userLottos, Lotto mainNumber, LottoNumber bonusNumber) {
        Map<Rank, Integer> resultOrigin = new HashMap<>();

        for (List<Integer> userLotto : userLottos) {
            int hitCount = compareNumbers(mainNumber, userLotto);
            boolean hasBonusNumber = checkBonusNumber(bonusNumber, userLotto);
            Rank rank = Rank.calculateRank(hitCount, hasBonusNumber);
            resultOrigin.put(rank, resultOrigin.getOrDefault(rank, 0) + 1);

        }
        return resultOrigin;
    }

    public int compareNumbers(Lotto mainNumber, List<Integer> userLotto) {
        int hitCount = 0;
        for (Integer eachNumber : mainNumber.getNumbers()) {
            if (userLotto.contains(eachNumber)) {
                hitCount++;
            }
        }
        return hitCount;
    }

    public boolean checkBonusNumber(LottoNumber bonusNumber, List<Integer> userLotto) {
        boolean hasBonusNumber = false;
        if (userLotto.contains(bonusNumber.getNumber())) {
            hasBonusNumber = true;
            return hasBonusNumber;
        }
        return hasBonusNumber;
    }

    public void gameResult(Map<Rank, Integer> result, User user) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.println(totalResult(result, rank));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", totalYield(result, user));
    }

    public String totalResult(Map<Rank, Integer> result, Rank rank) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String reward = decimalFormat.format(rank.getReward());
        int rewardCount = result.getOrDefault(rank, 0);

        if (rank == Rank.SECOND) {
            return rank.getHitCount() + "개 일치, 보너스 볼 일치 (" + reward + "원) - " + rewardCount + "개";
        }
        return rank.getHitCount() + "개 일치 (" + reward + "원) - " + rewardCount + "개";
    }

    public double totalYield(Map<Rank, Integer> result, User user) {
        double moneyTotal = 0;
        for (Rank rank : Rank.values()) {
            moneyTotal += result.getOrDefault(rank, 0) * rank.getReward();
        }

        double yield = moneyTotal * 100 / (double) user.gameMoney;
        return yield;
    }

}
