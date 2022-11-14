package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GameSet;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    @Override
    public void play(List<Lotto> generatedLotto, GameSet gameSet){
        for(int i =0;i<generatedLotto.size();i++){
            gameSet.plusCount(lotteryCheck(generatedLotto.get(i),gameSet.getAwardLotto(),gameSet.getBonusNumber()));
        }
    }
    @Override
    public int lotteryCheck(Lotto inputLotto, Lotto awardLotto, int bonusNumber){
        int correct = 0;
        int bonus = 0;
        int i = 0;
        int j = 0;
        while (i<inputLotto.getNumbers().size() && j<awardLotto.getNumbers().size()){
            int inputNumber=inputLotto.getNumbers().get(i);
            int awardNumber=awardLotto.getNumbers().get(j);
            if(inputNumber==awardNumber){
                correct++;
                i++;
                j++;
            }
            if(inputNumber < awardNumber){
                i++;
            }
            if (awardNumber < inputNumber){
                j++;
            }
            if(inputLotto.getNumbers().get(i)==bonusNumber){
                bonus=1;
            }
        }
        LottoProperties lottoProperties = LottoProperties.findType(correct);
        int index = lottoProperties.function(correct);
        if (lottoProperties.name().equals("LOTTO_THIRDWINNER")){
            index-=bonus;
        }
        return index;
    }
}
