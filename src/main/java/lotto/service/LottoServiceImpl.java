package lotto.service;

import lotto.domain.GameSet;
import lotto.domain.Lotto;

import java.util.List;

public class LottoServiceImpl implements LottoService {
    final int SECOND_WINNDER_CORRECT = 5;
    private GameSet gameSet;
    @Override
    public void play(List<Lotto> generatedLotto, GameSet gameSet){
        this.gameSet = gameSet;
        for(int i =0;i<generatedLotto.size();i++){
            lotteryCheck(generatedLotto.get(i),gameSet.getAwardLotto(),gameSet.getBonusNumber());
        }
    }
    @Override
    public void lotteryCheck(Lotto inputLotto, Lotto awardLotto, int bonusNumber){
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
                bonus=2;
            }
        }
        if (correct==SECOND_WINNDER_CORRECT){
            correct+=bonus;
        }
        LottoProperties lottoProperties = LottoProperties.findType(correct);
        updateGameSet(lottoProperties,correct);
    }
    @Override
    public void updateGameSet(LottoProperties lottoProperties, int correct){
        gameSet.plusCount(lottoProperties.function(correct));
        gameSet.plusTotalPrize(lottoProperties.getPrice());
    }
}
