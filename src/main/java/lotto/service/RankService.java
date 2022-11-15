package lotto.service;

import lotto.domain.rank.Rank;
import lotto.domain.rank.RankInfo;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.user.User;
import lotto.error.ErrorMsg;

import java.util.*;
import java.util.stream.Collectors;

public class RankService {

    public WinLotto generateWinningLotto(String numbers, String bonus)
            throws IllegalArgumentException{
        validate(numbers, bonus);
        try {
            List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());
            int bonusNumber = Integer.parseInt(bonus);

            return new WinLotto(winningNumbers, bonusNumber);
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMsg.INPUT_ERROR.toString());
        }
    }

    private void validate(String numbers, String bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMsg.DUPLICATE_BONUS_NUMBER.toString());
        }
    }

    public Rank calculateRanking(User user, WinLotto win){
        Set<Integer> winLotto = new HashSet<>(win.getNumbers());
        Rank ranking = new Rank();

        for (Lotto lotto : user.getLotto()){
            int rank = calculateRanking(lotto, winLotto, win.getBonusNumber());
            ranking.count(rank);
        }
        return ranking;
    }

    private int calculateRanking(Lotto lotto, Set<Integer> win, int bonus){
        Set<Integer> matchNumber = new HashSet<>(lotto.getNumbers());
        matchNumber.retainAll(win);

        if (matchNumber.size() == 6) return 1;
        if (matchNumber.size() == 5){
            if (isMatchBonus(lotto, bonus)) return 2;
            return 3;
        }
        if (matchNumber.size() == 4) return 4;
        if (matchNumber.size() == 3) return 5;
        return 0;
    }

    private Boolean isMatchBonus(Lotto lotto, int bonus){
        for (Integer number : lotto.getNumbers()){
            if (number == bonus) {
                return true;
            }
        }
        return false;
    }

    public Double calculateProfit(User user, Rank ranking){
        double totalProfit = 0.0;
        for (RankInfo rankInfo: ranking.getRank().keySet()){
            totalProfit += ranking.getRank().get(rankInfo) * rankInfo.getMoney();
        }
        totalProfit /= user.getMoney();
        totalProfit *= 100;
        return totalProfit;
    }
}
