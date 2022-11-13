package lotto;

import java.util.*;

public class LottoCounter {
    private int threeMatched;
    private int fourMatched;
    private int fiveMatched;
    private int fiveAndBonusMatched;
    private int sixMatched;

    public LottoCounter(){


    }
    public int countHowManyNumbersMatched(List<Integer> ticketNumbers,List<Integer> winningNumbers){
        final int twelveNumbers = 12;
        List<Integer> mergedList = new ArrayList<>();
        Set<Integer> mergedListWithoutDuplication;
        Collections.addAll(mergedList, ticketNumbers.toArray(new Integer[0]));
        Collections.addAll(mergedList, winningNumbers.toArray(new Integer[0]));
        mergedListWithoutDuplication= new TreeSet<>(mergedList);
        return twelveNumbers-mergedListWithoutDuplication.size();
    }

    public int threeMatchedTickets(List<Integer> ticketNumbers,List<Integer> winningNumbers){
        this.threeMatched=threeMatched;
        if(countHowManyNumbersMatched(ticketNumbers, winningNumbers)==3){
            threeMatched++;
        }
        return threeMatched;
    }

    public int fourMatchedTickets(List<Integer> ticketNumbers,List<Integer> winningNumbers){
        this.fourMatched=fourMatched;
        if(countHowManyNumbersMatched(ticketNumbers, winningNumbers)==4){
            fourMatched++;
        }
        return fourMatched;
    }

    public int fiveMatchedTickets(List<Integer> ticketNumbers,List<Integer> winningNumbers){
        this.fiveMatched=fiveMatched;
        if(countHowManyNumbersMatched(ticketNumbers, winningNumbers)==5){
            fiveMatched++;
        }
        return fiveMatched;
    }

    public int fiveAndBonusMatchedTickets(List<Integer> ticketNumbers,List<Integer> winningNumbers, int bonusInput){
        this.fiveAndBonusMatched=fiveAndBonusMatched;
        if(winningNumbers.contains(bonusInput)&&countHowManyNumbersMatched(ticketNumbers, winningNumbers)==5){
            fiveAndBonusMatched++;
        }
        return fiveAndBonusMatched;
    }

    public int sixMatchedTickets(List<Integer> ticketNumbers,List<Integer> winningNumbers){
        this.sixMatched=sixMatched;
        if(countHowManyNumbersMatched(ticketNumbers, winningNumbers)==6){
            sixMatched++;
        }
        return sixMatched;
    }

    public float winningRate(){

    }

}
