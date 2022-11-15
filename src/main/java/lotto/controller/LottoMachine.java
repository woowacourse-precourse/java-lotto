package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.info.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.info.Rule.*;

public class LottoMachine {
    public static Lotto publishLotto() {
        List<Integer> lottoNumbers = getLottoNumber();
        return new Lotto(sort(lottoNumbers));
    }

    private static List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER.getNumber(), END_NUMBER.getNumber(), NUMBER_COUNT.getNumber());
    }

    private static List<Integer> sort(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().sorted().collect(Collectors.toList());
    }

    public static List<Rank> getRanksFromPlayer(Player player) {
        List<Lotto> lottos = player.getLottos();
        Set<Integer> players = player.getPlayersLottoNumber();
        int bonus = player.getBonus();

        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Rank rank = getRank(players, bonus, lotto);
            ranks.add(rank);
        }

        return ranks;
    }

    public static int countMatchNumber(Set<Integer> playerLottoNumbers, Lotto lotto) {
        int count = 0;
        List<Integer> lottos = lotto.getNumbers();
        for (Integer players : playerLottoNumbers) {
            if (lottos.contains(players)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isBonusMatch(int bonus, Lotto lotto) {
        return lotto.getNumbers().contains(bonus);
    }

    public static Rank getRank(Set<Integer> playersLottoNumber, int bonus, Lotto lotto) {
        int count = countMatchNumber(playersLottoNumber, lotto);
        boolean isBonus = isBonusMatch(bonus, lotto);

        return Rank.getRank(count, isBonus);
    }
}
