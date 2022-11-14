package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.user.User;
import lotto.error.ErrorMsg;

import java.util.*;
import java.util.stream.Collectors;

public class RankService {

    public WinLotto generateWinningLotto(String numbers, String bonus)
            throws IllegalArgumentException{
        try {
            List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());
            int bonusNumber = Integer.parseInt(bonus);

            return new WinLotto(winningNumbers, bonusNumber);
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMsg.INPUT_ERROR.toString());
        }
    }

    public List<Integer> calculateRanking(User user, WinLotto lotto){
        List<Integer> ranking = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

        for (Lotto boughtLotto : user.getLotto()){
            int rank = calculateRanking(boughtLotto, lotto);
            ranking.set(rank, ranking.get(rank) + 1);
        }
        return ranking;
    }

    private int calculateRanking(Lotto lotto, WinLotto winningLotto){
        Set<Integer> winningNumbers = new HashSet<>(lotto.getNumbers());
        Set<Integer> lottoNumbers = new HashSet<>(winningLotto.getNumbers());
        lottoNumbers.retainAll(winningNumbers);
        if (lottoNumbers.size() == 6) return 1;
        if (lottoNumbers.size() == 5){
            if (isMatchBonus(lotto, winningLotto.getBonusNumber()))
                return 2;
            return 3;
        }
        if (lottoNumbers.size() == 4) return 4;
        if (lottoNumbers.size() == 3) return 5;

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
}
