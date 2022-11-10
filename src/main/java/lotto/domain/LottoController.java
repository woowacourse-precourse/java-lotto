package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoInterface;
import lotto.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private int price;
    private int lottoNumber;
    private static final int oneLottoPrice = 1000;
    private static final int startRange = 1;
    private static final int endRange = 45;
    private static final int count = 6;
    private List<Integer> winningLotto;
    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(startRange,endRange, count);
    }

    public int calculateLottoNumber(int price){
        if(price % oneLottoPrice != 0){
            throw new IllegalArgumentException("[ERROR] 가격은 천원 단위로 입력해주세요.");
        }
        return price / oneLottoPrice;
    }

    public WinningLotto inputWinningLotto(){
        List<Integer> winningLottoNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        inputWinningNumbers(winningLottoNumbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        inputBonusNumber(winningLottoNumbers);

        return new WinningLotto(winningLottoNumbers);
    }

    public void inputWinningNumbers(List<Integer> winningLotto){
        String inputWinnerNumbers = Console.readLine();
        String[] winningNumbers = inputWinnerNumbers.split(",");
        for (String winningNumber : winningNumbers) {
            winningLotto.add(Integer.parseInt(winningNumber));
        }
    }

    public void inputBonusNumber(List<Integer> winningLotto){
        String bonusNumber = Console.readLine();
        winningLotto.add(Integer.parseInt(bonusNumber));
    }

}
