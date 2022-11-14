package lotto.play;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Util.InputPrint;
import lotto.Util.OutputPrint;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Prize;

import java.util.*;

public class Game {
    private Player player;

    private ArrayList<Lotto> lottos;

    private Prize prize;

    private Map<Integer ,Integer> matchResults;


    public Game() {
        player = new Player();
        lottos = new ArrayList<>();
        prize = new Prize();
        matchResults = new HashMap<>();
    }

    public void playGame(){
        player.inputMoney();
        OutputPrint.moneyToNumberPrint(player.getPurchaseNumber() / 1000);
        generateNumbers(player.getPurchaseNumber() / 1000);
        OutputPrint.generatedLottoNumbersPrint(lottos);
        prize.inputPrizeNumbers();
        prize.inputBonusNumber();
        OutputPrint.prizePrint();
        matchPrize();
    }

    private void matchPrize() {
        for (Lotto lotto : lottos) {
            int matchResult = prize.match(lotto);
            matchResults.put(matchResult, matchResults.getOrDefault(matchResult, 0) + 1);
        }
        int sum = earnSum();
        OutputPrint.resultPrint(matchResults, player.getPurchaseNumber(), sum);
    }

    private int earnSum() {
        return matchResults.getOrDefault(3, 0) * 5000
                + matchResults.getOrDefault(4, 0) * 50000
                + matchResults.getOrDefault(5, 0) * 1500000
                + matchResults.getOrDefault(6, 0) * 30000000
                + matchResults.getOrDefault(7, 0) * 2000000000;
    }

    private void generateNumbers(int count){
        for (int i = 0; i < count; i++) {
            List<Integer> subNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> numbers = new ArrayList<>(subNumbers);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }
}
