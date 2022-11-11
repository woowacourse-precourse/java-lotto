package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoCompany {

    private final int LENGTH=6;

    Validator validator = new Validator();
    Result result = new Result();
    List<Integer>forValidate = new ArrayList<>();
    Lottos lottos;
    Lotto lotto;
    int bonus;

    public LottoCompany(){

    }

    public void winningNumbers(Lottos lottos){
        this.lottos = lottos;
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        makeWinningNumbers(winningNumbers);
    }

    public void bonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validator.validateBonus(bonusNumber, forValidate);
        this.bonus = Integer.parseInt(bonusNumber);
        result.compareNumbers(this.lottos, this.lotto, this.bonus);
    }

    public void makeWinningNumbers(String numbers) {
        String [] winningNumbers = numbers.split(",");
        Arrays.sort(winningNumbers);
        validate(winningNumbers);
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int order=0; order<LENGTH;order++){
            lottoNumbers.add((Integer.parseInt(winningNumbers[order])));
        }
        this.lotto = new Lotto(lottoNumbers);
        bonusNumber();
    }

    private void validate(String[] winningNumbers) {
        validator.validateWinningNumbers(winningNumbers);
        validator.validateLottoLength(winningNumbers);
        validator.validateDuplicate(winningNumbers);
        for(int i = 0; i< winningNumbers.length; i++){
            forValidate.add(Integer.parseInt(winningNumbers[i]));
        }
        validator.validateNumbersRange(forValidate);
    }

}
