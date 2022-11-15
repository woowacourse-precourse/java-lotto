package lotto.service;

import lotto.domain.GameSet;
import lotto.domain.Lotto;
import lotto.domain.LottoProperties;
import lotto.utils.GenerateLottoNumbers;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.InputLotto.getInput;

public class LottoServiceImpl implements LottoService {
    private GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers();
    private List<Lotto> generatedLotto = new ArrayList<>();
    private GameSet gameSet;
    @Override
    public GameSet startGame(){
        return gameSet = new GameSet();
    }
    @Override
    public void generateAwardLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        gameSet.setAwardLotto(new Lotto(getInput()));
        System.out.println("보너스 번호를 입력해 주세요.");
        gameSet.setBonusNumber(getInput());
    }
    @Override
    public void generateLotto(){
        for(int i =0;i<gameSet.getLottoCount();i++) {
            generatedLotto.add(new Lotto(generateLottoNumbers.generateLottoNumber()));
            System.out.println(generatedLotto.get(i).getNumbers());
        }
    }
    @Override
    public void play(){
        for(int i =0;i<generatedLotto.size();i++){
            LottoProperties lottoProperties = generatedLotto.get(i).lotteryCheck(gameSet.getAwardLotto(),gameSet.getBonusNumber());
            gameSet.updateGameSet(lottoProperties);
        }
    }
}
