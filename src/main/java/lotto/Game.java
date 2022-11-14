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
        isValidBonusNumber(Integer.parseInt(bonusNumber),winningLotto.getLottoNumber());
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

    private void isValidBonusNumber(int bonusNumber, List<Integer> winningLotto) throws IllegalArgumentException{
        if(!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호입니다.");
        }
        if(winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호입니다.");
        }
    }
}
