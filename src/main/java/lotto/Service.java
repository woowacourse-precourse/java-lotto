package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Service {

    private static final int LOTTERY_PRICE = 1000;
    private static final int BONUS_CRITERIA = 5;
    private static final String NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

    Exception exception = new Exception();


    public int stringToInt(String string) {
        if(!isInteger(string)){
            exception.isNotIntegerException();
        }
        return Integer.parseInt(string);
    }

    public boolean isInteger(String string) {
        if(string.matches(NUMBER_REGEX) == false) {
            return false;
        }
        return true;
    }

    public boolean isDividedByLotteryPrice(int money) {
        if(money % LOTTERY_PRICE != 0) {
            return false;
        }
        return true;
    }

    public int numberOfLottery(int money) {
        if(!isDividedByLotteryPrice(money)) {
            exception.isMoneyUnitException();
        }
        int lotteryCount = money/LOTTERY_PRICE;
        return lotteryCount;
    }

    public List<Lotto> createLotteryTickets(int numberOfTickets, LottoGroup lottoGroup) {
        for(int count = 0; numberOfTickets > count; count++) {
            lottoGroup.createLotto();
        }
        return lottoGroup.getAllLotteryTickets();
    }

    public List<String> splitByCommas(String string) {
        return Arrays.asList(string.split(","));
    }

    public List<Integer> toIntegers(List<String> strings) {
        List<Integer> integers = new ArrayList<>();

        for(String string : strings) {
            int number = 0;
            if(!isInteger(string)) {
                exception.isNotIntegerException();
            }
            number = Integer.parseInt(string);
            integers.add(number);
        }

        return integers;
    }

    public RankType getLotteryRank(Lotto lotto, WinningNumber winningNumber) {
       int matchNumberCount = matchNumberCount(lotto.getNumbers(), winningNumber.getLotto().getNumbers());

       boolean isMatchNumber = true;

       if(matchNumberCount == BONUS_CRITERIA) {
           isMatchNumber = isMatchNumber(winningNumber.getBonus(), lotto.getNumbers());
       }
       return RankType.findRankType(matchNumberCount, isMatchNumber);
    }

    public List<RankType> getLotteriesRanks(LottoGroup lottoGroup, WinningNumber winningNumber) {
        List<RankType> rankTypes = new ArrayList<>();
        for(Lotto lotto : lottoGroup.getAllLotteryTickets()) {
            rankTypes.add(getLotteryRank(lotto, winningNumber));
        }
        return rankTypes;
    }


    public int matchNumberCount(List<Integer> numbers, List<Integer> comparisonCriteria) {
        int count = 0;
        for(int loopCount = 0; numbers.size() > loopCount; loopCount++) {
            if(comparisonCriteria.contains(numbers.get(loopCount))) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatchNumber(int number, List<Integer> comparisonCriteria) {
        if(comparisonCriteria.contains(number)) {
            return true;
        }
        return false;
    }

    public int sumAllWinnings(List<RankType> rankTypes) {
        int allWinnings = 0;

        for(RankType rankType : rankTypes) {
            allWinnings += rankType.getReward();
        }
        return allWinnings;
    }


}
