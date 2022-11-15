package lotto;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Institution {

    private static Institution institution = new Institution();

    private Institution() {};

    public static Institution getInstance() {
        return institution;
    }

    public Integer countPrizeAndLottoDuplicatedNumber(List<Integer> numbers, List<Integer> winningNumbers) {
        List<Integer> nonDuplicatedNumbers = numbers.stream()
                .filter(nums-> winningNumbers.stream().anyMatch(Predicate.isEqual(nums)))
                .collect(Collectors.toList());

        Integer count = nonDuplicatedNumbers.size();

        return count;
    }

    public Boolean isBonusNumberIncluded(List<Integer> numbers, Integer bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public void updatePrizeWinnerCount(List<PrizeWinner> prizeWinners, Integer count, Boolean bonusNumberIncluded) {
        if(count==6) {
            prizeWinners.get(prizeWinners.indexOf(PrizeWinner.FIRSTPLACE)).addCount();
        }else if(count==5 && bonusNumberIncluded==true) {
            prizeWinners.get(prizeWinners.indexOf(PrizeWinner.SECONDPLACE)).addCount();
        }else if(count==5 && bonusNumberIncluded==false) {
            prizeWinners.get(prizeWinners.indexOf(PrizeWinner.THIRDPLACE)).addCount();
        }else if(count==4) {
            prizeWinners.get(prizeWinners.indexOf(PrizeWinner.FOURTHPLACE)).addCount();
        }else if(count==3) {
            prizeWinners.get(prizeWinners.indexOf(PrizeWinner.FIFTHPLACE)).addCount();
        }
    }

    public void confirmWinner(List<PrizeWinner> prizeWinners, User user, Prize prize) {
        List<Integer> winningNumbers = prize.getNumbers();

        for(Lotto lotto : user.getLottos()) {
            Integer count = countPrizeAndLottoDuplicatedNumber(lotto.getNumbers(), winningNumbers);
            Boolean bonusNumberIncluded = isBonusNumberIncluded(lotto.getNumbers(), prize.getBonusNumber());

            updatePrizeWinnerCount(prizeWinners, count, bonusNumberIncluded);
        }
    }

    public void announceWinnerResult(List<PrizeWinner> prizeWinners, User user) {
        for(PrizeWinner prizeWinner : prizeWinners) {
            System.out.println(prizeWinner.toString());
        }
    }
}
