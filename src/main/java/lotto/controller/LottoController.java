package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GameSet;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.utils.GenerateLottoNumbers;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.GetInput.getInput;

public class LottoController {
    private final GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers();
    private final LottoService lottoService = new LottoServiceImpl();
    private List<Lotto> generatedLotto = new ArrayList<>();
    private static int lottoCount;
    private GameSet gameSet;
    public void run(){
        init();
        generateLotto();
    }
    private void init(){
        System.out.println("구입금액을 입력해 주세요.");
        lottoCount=Integer.parseInt(Console.readLine());
        if(lottoCount%1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또값은 1000원 이상 혹은 1000원으로 나눠떨어져야 합니다.");
        }
        lottoCount/=1000;
        System.out.println(lottoCount+"개를 구매했습니다.");
    }
    private void generateLotto(){
        for(int i =0;i<lottoCount;i++) {
            generatedLotto.add(new Lotto(generateLottoNumbers.generateLottoNumber()));
            System.out.println(generatedLotto.get(i).getNumbers());
        }
    }

}
