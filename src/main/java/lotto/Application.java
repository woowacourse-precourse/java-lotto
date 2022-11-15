package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        try {
            Player player = new Player();
            Set<Lotto> playerLotto = player.buyLotto();

            List<Integer> winningNumbers = player.pickNumbers();
            int bonusNumber = player.pickBonus(winningNumbers);

            Judgement judgement = new Judgement();
            judgement.compare(playerLotto, winningNumbers, bonusNumber);
            judgement.winningResult(playerLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
