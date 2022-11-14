package lotto.Domain;

import java.util.HashSet;
import java.util.Set;

public class LottoCalculator {
    LottoMaker lottoMaker;
    Lotto lottoAnswer;
    Bonus bonus;

    public LottoCalculator(LottoMaker lottoMaker, Lotto lottoAnswer, Bonus bonus){
        this.lottoMaker = lottoMaker;
        this.lottoAnswer = lottoAnswer;
        this.bonus = bonus;
    }

    // 전체 로또 비교기
    public void lottoComparator(){
        LottoMaker lottoMaker = this.lottoMaker;
        Lotto lottoAnswer = this.lottoAnswer;
        Bonus bonus = this.bonus;
    }

    // 하나의 로또에 대한 당첨 결과 반환기
    public int lottoRanker(Lotto user,Lotto answer,Bonus bonus){
        int equalNumber = getEqualNumber(user,answer);
        if((equalNumber == 5) && hasBonus(user,bonus)){
            equalNumber++;
        }
        return equalNumber;
    }
    
    // 하나의 로또에 대한 일치하는 번호갯수 반환기
    public int getEqualNumber(Lotto user,Lotto answer){
        Lotto userAnswer = user;
        Lotto lottoAnswer = answer;
        Set<Integer> equalNumbers = new HashSet<>();

        for(Lotto number : user){

        }
    }

    // 보너스를 가지고 있다면 true반환
    public boolean hasBonus(Lotto user, Bonus bonus){
        return true;
    }

}
