package lotto.play;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Util.InputPrint;
import lotto.Util.OutputPrint;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Prize;
import lotto.valid.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private Player player;

    private ArrayList<Lotto> lottos;

    private Prize prize;

    private List<Integer> matchResults;


    public Game() {
        player = new Player();
        lottos = new ArrayList<>();
        prize = new Prize();
        matchResults = new ArrayList<>();
    }

    public void playGame(){
        startGame();
        OutputPrint.moneyToNumberPrint(player.getPurchaseNumber());
        generateNumbers(player.getPurchaseNumber());
        OutputPrint.generatedLottoNumbersPrint(lottos);
        prize.inputPrizeNumbers();
        prize.inputBonusNumber();
        matchPrize();
    }

    private void matchPrize() {
        for (Lotto lotto : lottos) {
            int matchResult = prize.match(lotto);
            matchResults.add(matchResult);
        }
        OutputPrint.resultPrint(matchResults);
    }


    private void startGame(){
        player.inputMoney();
    }

    private void generateNumbers(int count){
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }
}
