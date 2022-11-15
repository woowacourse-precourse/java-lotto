package lotto.service;

import lotto.domain.GameSet;
import lotto.domain.Lotto;
import lotto.domain.LottoProperties;

import java.io.IOException;
import java.util.List;

import static lotto.view.OutputLotto.printResult;


public class LottoServiceImpl implements LottoService {
    @Override
    public void play() throws IOException {
        GameSet gameSet = new GameSet();
        gameSet.generateLotto();
        gameSet.generateAwardLotto();
        List<Lotto> generatedLotto = gameSet.getGeneratedLotto();
        for(int i =0;i<generatedLotto.size();i++){
            Lotto currentLotto = generatedLotto.get(i);
            LottoProperties lottoProperties = currentLotto.lotteryCheck(gameSet.getAwardLotto(),gameSet.getBonusNumber());
            gameSet.updateGameSet(lottoProperties);
        }
        printResult(gameSet);
    }
}
