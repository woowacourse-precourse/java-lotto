package lotto.service;

import lotto.domain.*;
import lotto.view.OutputLotto;
import java.io.IOException;



public class LottoServiceImpl implements LottoService {
    LottoResult lottoResult;
    Game game = new Game();
    @Override
    public void play() throws IOException {
        game.inputLottoCount();
        game.generateLotto();
        game.generateAwardLotto();
        game.generateLottoBonusNumber();
        UserLotto generatedLotto = game.getGeneratedLotto();
        for(int i =0;i<generatedLotto.getUserLotto().size();i++){
            lottoResult = new LottoResult(generatedLotto.getUserLotto().get(i),game.getAwardLotto(),game.getLottoBonusNumber().getBonusNumber());
            LottoProperties lottoProperties = lottoResult.getLottoProperties();
            game.updateGame(lottoProperties);
        }
        OutputLotto.printResult(game);
    }
}
