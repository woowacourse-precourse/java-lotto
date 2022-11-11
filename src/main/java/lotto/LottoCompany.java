package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoCompany {

    private final int LENGTH=6;

    Validator validator = new Validator();
    Result result = new Result();
    Map<Integer, LottoNumber> lottoNumberMap = new LottoNumberGenerater().makeLottoNumberMap();
    List<Integer>forValidate = new ArrayList<>();
    public Lottos lottos;
    public Lotto lotto;
    public LottoNumber bonus;

    public LottoCompany(){

    }

    public void winningNumbers(Lottos lottos){
        this.lottos = lottos;
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        makeWinningNumbers(winningNumbers);
    }

    public void makeWinningNumbers(String numbers) {
        String [] winningNumbers = numbers.split(",");
        Arrays.sort(winningNumbers);
        validate(winningNumbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int order=0; order<LENGTH;order++){
            lottoNumbers.add(lottoNumberMap.get(Integer.parseInt(winningNumbers[order])));
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
