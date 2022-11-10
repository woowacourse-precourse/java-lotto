package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private int price;
    private int lottoNumber;
    private static final int oneLottoPrice = 1000;
    private static final int start_Range = 1;
    private static final int end_Range = 45;
    private static final int count = 6;
    private List<Integer> winningLotto;
    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(start_Range,end_Range, count);
    }

    public int calculateLottoNumber(int price){
        if(price % oneLottoPrice != 0){
            throw new IllegalArgumentException("[ERROR] 가격은 천원 단위로 입력해주세요.");
        }
        return price / oneLottoPrice;
    }

    public List<Integer> inputWinningLotto(){
        List<Integer> winningLotto = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        inputWinningNumbers(winningLotto);
        System.out.println("보너스 번호를 입력해 주세요.");
        inputBonusNumber(winningLotto);

        validateWinningLotto(winningLotto);
        return winningLotto;
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

    public void validateWinningLotto(List<Integer> winningLotto){
        validateWinningLottoSize(winningLotto);
        validateWinningLottoNumberRange(winningLotto);
        validateWinningLottoNumberDuplicated(winningLotto);
    }
    public void validateWinningLottoSize(List<Integer> winningLotto){
        if(winningLotto.size() != 7){
            throw new IllegalArgumentException("[ERROR] 당첨 로또는 당첨 번호 6개와 보너스 번호 1개로 이루어져야 합니다.");
        }
    }

    public void validateWinningLottoNumberRange(List<Integer> winningLotto){
        for(int number : winningLotto){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateWinningLottoNumberDuplicated(List<Integer> winningLotto){
        if(winningLotto.size() != winningLotto.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되서는 안됩니다");
        }
    }
}
