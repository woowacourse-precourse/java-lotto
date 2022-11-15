package lotto.service;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.LottoProperties;
import lotto.view.OutputLotto;
import java.io.IOException;
import java.util.List;



public class LottoServiceImpl implements LottoService {
    @Override
    public void play() throws IOException {
        Game game = new Game();
        game.generateLotto();
        game.generateAwardLotto();
        List<Lotto> generatedLotto = game.getGeneratedLotto();
        for(int i =0;i<generatedLotto.size();i++){
            Lotto currentLotto = generatedLotto.get(i);
            LottoProperties lottoProperties = currentLotto.lotteryCheck(game.getAwardLotto(), game.getBonusNumber());
            game.updateGame(lottoProperties);
        }
        OutputLotto.printResult(game);
    }
}
