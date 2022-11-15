package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidUserInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class Game {

    private User user;
    private Computer computer;

    private Lotto winningLotto;
    private int bonusNumber;

    public Game(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void enterWinningNumber() {
        String[] numbers = Console.readLine().split(",");

        // (1) ,을 기준으로 올바르게 입력하지 않았다면, InvalidUserInputException 오류 반환
        // (2) 1~45 숫자를 입력하지 않았다면, 6자리 숫자 검증에서 오류
        // 중복 검사까지 실시
        try {
            Lotto lotto = new Lotto(Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .filter(n -> 1 <= n)
                    .filter(n -> n <= 45)
                    .collect(Collectors.toList()));

            this.winningLotto = lotto;

        } catch(NumberFormatException e) {
            throw new InvalidUserInputException("[ERROR] 올바른 형식으로 입력해 주세요.");
        }
    }

    public void enterBonusNumber() {
        int tempBonusNumber = Integer.parseInt(Console.readLine());

        if (tempBonusNumber < 1 || 45 < tempBonusNumber) {
            throw new InvalidUserInputException("[ERROR] 1 ~ 45 사이의 숫자를 입력해 주세요.");
        } else if (winningLotto.getNumbers().contains(tempBonusNumber)) {
            throw new InvalidUserInputException("[ERROR] 당첨 번호와 다른 보너스 번호를 입력해 주세요.");
        }

        this.bonusNumber = tempBonusNumber;
        this.winningLotto.getNumbers().add(bonusNumber);
    }

    /**
     * 각 로또마다, 당첨 등수를 계산해 반환
     */
    public List<Integer> discriminateRanking() {

        List<Long> matchingCount = countMatchingNumbers();
        List<Boolean> isBonusMatched = isBonusMatch();

        List<Integer> ranks = new ArrayList<>();

        int cnt = 0;
        for(Long count : matchingCount) {
            ranks.add(getRank(count, isBonusMatched.get(cnt++)));
        }

        return ranks;
    }

    /**
     * 로또의 각 게임마다, 당첨 등수의 개수를 반환
     */
    public int[] getRankCount(List<Integer> ranks) {
        int[] counts = new int[6];

        for(int rank : ranks) {
            counts[rank]++;
        }

        return counts;
    }

    /**
     * 로또 당첨 등수를 반환
     */
    public int getRank(Long matchingCount, Boolean bonusMatched) {

        if(matchingCount == 6) {
            return 1;
        } else if(matchingCount == 5 && bonusMatched) {
            return 2;
        } else if(matchingCount == 5) {
            return 3;
        } else if(matchingCount == 4) {
            return 4;
        } else if(matchingCount == 3) {
            return 5;
        } else {
            return 0;
        }

    }

    /**
     * 당첨 로또와 사용자의 각 로또를 비교해 각 로또마다 매칭되는 개수를 반환
     */
    public List<Long> countMatchingNumbers() {
        List<Long> counts = new ArrayList<>();

        this.user.getUserLottos().stream()
                .forEach(
                        lotto -> counts.add(lotto.getNumbers()
                                .stream()
                                .filter(num -> winningLotto.getNumbers().contains(num))
                                .count())
                );

        return counts;
    }

    /**
     * 당첨 로또와 사용자의 각 로또를 비교해 각 로또마다 보너스 매칭 여부를 반환
     */
    public List<Boolean> isBonusMatch() {
        List<Boolean> matches = new ArrayList<>();

        this.user.getUserLottos().stream()
                .forEach(
                        lotto -> matches.add(lotto.getNumbers()
                                .stream()
                                .filter(num -> winningLotto.getNumbers().contains(num))
                                .findAny()
                                .isPresent())
                );

        return matches;
    }

    /**
     * 유저의 모든 로또 게임 결과를 합산해, 수익률을 반환
     **/
    public String getYield(int[] rankCount) {
        int amount = this.user.getGameCount() * 1000; // 유저가 지불한 총 금액
        List<Integer> prizeMoney = new ArrayList<>(Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000)); // 1 ~ 5등 상금

        double yield = 0; // 수익률

        for(int i = 1; i <= 5; i++) {
            yield += rankCount[i] * prizeMoney.get(i-1);
        }

        return String.format("%.1f", yield / amount * 100);
    }

}
