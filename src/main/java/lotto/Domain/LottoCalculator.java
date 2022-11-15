package lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {
    LottoMaker lottoMaker;
    Lotto lottoAnswer;
    Bonus bonus;

    public LottoCalculator(){}

    public LottoCalculator(LottoMaker lottoMaker, Lotto lottoAnswer, Bonus bonus){
        this.lottoMaker = lottoMaker;
        this.lottoAnswer = lottoAnswer;
        this.bonus = bonus;
    }

    // 전체 로또 비교기
    public List<Rank> lottoComparator(LottoMaker lottoMaker, Lotto answer, Bonus bonus){
        List<Rank> rank = new ArrayList<>();
        for(Lotto eachLotto : lottoMaker.getLottoTickets()){
            rank.add(lottoRanker(eachLotto, answer, bonus));
        }
        return rank;
    }

    // 하나의 로또에 대한 당첨 결과 반환기
    public Rank lottoRanker(Lotto user, Lotto answer, Bonus bonus){
        int equalNumber = getEqualNumber(user,answer);
        return Rank.findRank(equalNumber, hasBonus(user, bonus));
    }
    
    // 하나의 로또에 대한 일치하는 번호갯수 반환기
    public int getEqualNumber(Lotto user,Lotto answer){
        int equalNumbers = 0;
        List<Integer> userNumbers = user.getNumbers();
        List<Integer> answerNumbers = answer.getNumbers();

        for(Integer number : userNumbers){
            if (answerNumbers.contains(number)){
                equalNumbers++;
            }
        }

        return equalNumbers;
    }

    // 보너스를 가지고 있다면 true반환
    public boolean hasBonus(Lotto user, Bonus bonus){
        List<Integer> userNumbers = user.getNumbers();
        int bonusNumber = bonus.getBonus();
        return userNumbers.contains(bonusNumber);
    }

}
