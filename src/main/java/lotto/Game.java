package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void generator() {
        Lotto winningLotto = getWinningLotto();
        System.out.println(winningLotto.getLottoNumber());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
    }

    private Lotto getWinningLotto() {
        System.out.println("\n당첨 번호를 입력해주세요.");
        String inputValue = Console.readLine().trim();
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String numberValue : inputValue.split(",")) {
            winningLottoNumbers.add(Integer.parseInt(numberValue));
        }
        return new Lotto(winningLottoNumbers);
    }
}
