package lotto;

import java.util.*;

public class LottoCounter {
    private int threeMatched;
    private int fourMatched;
    private int fiveMatched;
    private int fiveAndBonusMatched;
    private int sixMatched;


    public void countHowManyNumbersMatched(List<Integer> ticketNumbers,List<Integer> winningNumbers, int bonus){
        final int twelveNumbers = 12;
        int matchedNumbers;
        List<Integer> mergedNumbers = new ArrayList<>();
        Set<Integer> mergedNumbersWithoutDuplication;
        Collections.addAll(mergedNumbers, ticketNumbers.toArray(new Integer[0]));
        Collections.addAll(mergedNumbers, winningNumbers.toArray(new Integer[0]));
        mergedNumbersWithoutDuplication= new TreeSet<>(mergedNumbers);
        matchedNumbers = twelveNumbers-mergedNumbersWithoutDuplication.size();
        countThreeMatchedTickets(matchedNumbers);
        countFourMatchedTickets(matchedNumbers);
        countFiveAndBonusMatchedTickets(matchedNumbers, bonus, mergedNumbersWithoutDuplication);
        countFiveMatchedTickets(matchedNumbers);
        countSixMatchedTickets(matchedNumbers);
    }
    public void countThreeMatchedTickets(int matchedNumbers){
        if(matchedNumbers==3){
            threeMatched++;
        }
    }
    public void countFourMatchedTickets(int matchedNumbers){
        if(matchedNumbers==4){
            fourMatched++;
        }
    }

    public void countFiveAndBonusMatchedTickets(int matchedNumbers,int bonus, Set<Integer> mergedWithoutDuplication){
        if(matchedNumbers==5&&mergedWithoutDuplication.contains(bonus)){
            fiveAndBonusMatched++;
        }
    }

    public void countFiveMatchedTickets(int matchedNumbers){
        if(matchedNumbers==5){
            fiveMatched++;
        }
    }

    public void countSixMatchedTickets(int matchedNumbers){
        if(matchedNumbers==6){
            sixMatched++;
        }
    }
    public int getThreeMatchedTickets(){
        return threeMatched;
    }

    public int getFourMatchedTickets(){
        return fourMatched;
    }

    public int getFiveMatchedTickets(){
        return fiveMatched;
    }

    public int getFiveAndBonusMatchedTickets(){
        return fiveAndBonusMatched;
    }

    public int getSixMatchedTickets(){
        return sixMatched;
    }

    public float addAllPrizeMoney(){
        float totalPrizeMoney=0;
        totalPrizeMoney=threeMatched*5000+fourMatched*50000+fiveMatched*1500000+fiveAndBonusMatched*30000000
                +sixMatched*2000000000;
        return totalPrizeMoney;
    }

    public float calculateLottoYield(float principal, float prizeMoney){
        double totalYield = prizeMoney/principal;
        totalYield = Math.round(totalYield*1000)/(float)10;
        totalYield = totalYield*100/100;
        return (float)totalYield;
    }

}
