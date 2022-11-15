package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    @DisplayName("당첨로또와 산 로또를 비교하는 테스트")
    void matchCount() {
        List<Integer> winningLottoList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> nowBuyLottoList = Arrays.asList(4, 5, 6, 7, 8, 9);
        int bonusNumber = 10;
        LottoGame game = new LottoGame();
        Integer integer = game.matchCount(winningLottoList, nowBuyLottoList, bonusNumber);
        Assertions.assertThat(integer).isEqualTo(3);
    }

    @Test
    @DisplayName("해당 랭킹이 몇개인지 테스트")
    void countingRank() {
        List<Integer> rankedBox = getRankedBox();

        Assertions.assertThat(rankedBox.get(0)).isEqualTo(2);
    }

    @Test
    @DisplayName("최종 돈 계산")
    void calculateSumMoney() {
        List<Integer> rankedBox = getRankedBox();
        long sumGetMoney = 0;

        for (int index = 0; index < rankedBox.size(); index++) {
            Integer nowRankMoney = LottoGame.moneyRanks.get(index);
            Integer howManyRanked = rankedBox.get(index);
            sumGetMoney += nowRankMoney * howManyRanked;
        }

        Assertions.assertThat(sumGetMoney).isEqualTo(10000);


    }

    private List<Integer> getRankedBox() {
        List<Integer> winningLottoList = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> nowBuyLottoList = Arrays.asList(4, 5, 6, 7, 8, 9);
        List<Integer> nowBuyLottoList2 = Arrays.asList(1, 2, 3, 9, 10, 11);
        int bonusNumber = 10;
        LottoGame game = new LottoGame();
        List<Integer> matchCountBox = new ArrayList<>();
        List<Integer> rankedBox = new ArrayList<>();
        matchCountBox.add(game.matchCount(winningLottoList, nowBuyLottoList, bonusNumber));
        matchCountBox.add(game.matchCount(winningLottoList, nowBuyLottoList2, bonusNumber));

        for (int index = 3; index <= 7; index++) {
            int finalJ = index;
            rankedBox.add((int) matchCountBox.stream().filter(n -> n == finalJ).count());
        }
        return rankedBox;
    }


}