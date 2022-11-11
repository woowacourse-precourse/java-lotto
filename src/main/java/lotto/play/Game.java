package lotto.play;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Util.InputPrint;
import lotto.Util.OutputPrint;
import lotto.domain.Lotto;
import lotto.domain.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private Player player;
    private ArrayList<Lotto> lottos;

    public Game() {
        player = new Player();
        lottos = new ArrayList<>();
    }

    public void playGame(){
        startGame();
        OutputPrint.moneyToNumberPrint(player.getPurchaseNumber());
        generateNumbers(player.getPurchaseNumber());
    }

    private void startGame(){
        InputPrint.startInput();
        player.inputString();
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
