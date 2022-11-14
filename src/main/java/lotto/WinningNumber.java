package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<Integer> winningLottoNumber;
    private int bonusNumber;
    public void generator() {
        Lotto winningLotto = setWinningLotto();
        System.out.println(winningLotto.getLottoNumber());
        winningLottoNumber = winningLotto.getLottoNumber();
        bonusNumber = setBonusNumber();
    }

    public List<Integer> getWinningLotto() {
        return winningLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private Lotto setWinningLotto() {
        System.out.println("\n당첨 번호를 입력해주세요.");
        String inputValue = Console.readLine().trim();
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String numberValue : inputValue.split(",")) {
            winningLottoNumbers.add(Integer.parseInt(numberValue));
        }
        return new Lotto(winningLottoNumbers);
    }

    private int setBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return isValidBonusNumber(Integer.parseInt(bonusNumber), winningLottoNumber);
    }

    private int isValidBonusNumber(int bonusNumber, List<Integer> winningLotto) throws IllegalArgumentException{
        if(!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호입니다.");
        }
        if(winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호입니다.");
        }
        return bonusNumber;
    }
}
