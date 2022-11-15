package lotto.service;

import lotto.domain.GameSet;
import lotto.domain.Lotto;
import lotto.domain.LottoProperties;

import java.util.List;

import static lotto.view.OutputLotto.printResult;


public class LottoServiceImpl implements LottoService {
    GameSet gameSet = new GameSet();
    @Override
    public void play(){
        gameSet.generateLotto();
        gameSet.generateAwardLotto();
        List<Lotto> generatedLotto = gameSet.getGeneratedLotto();
        for(int i =0;i<generatedLotto.size();i++){
            Lotto currentLotto = generatedLotto.get(i);
            LottoProperties lottoProperties = currentLotto.lotteryCheck(gameSet);
            gameSet.updateGameSet(lottoProperties);
        }
        printResult(gameSet);
    }
}
