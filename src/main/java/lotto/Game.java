package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private View view;
    private Exception exception;
    private LottoMaker lottoMaker;
    private WinningResult winningResult;
    private List<Lotto> total_lotto;
    private List<Integer> user_number;

    private int bonus_user_number;
    private int money;

    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String SHOW_LOTTO ="개를 구매했습니다.";
    private final String INPUT_LOTTO = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_LOTTO = "보너스 번호를 입력해 주세요";

    public Game(){

        view=new View();
        exception= new Exception();
        lottoMaker = new LottoMaker();
        winningResult = new WinningResult(view);
        total_lotto = new ArrayList<>();
        user_number = new ArrayList<>();

        this.bonus_user_number=0;
        this.money=0;

    }

    public void run(){

        money = requestMoney();
        lottoNumberSave(money);
        view.lottoNumberShow(total_lotto,(money/1000)+SHOW_LOTTO);
        user_number=requestLottoNumber();
        bonus_user_number=requestBonusLottoNumber();
        winningResult.compareLotto(total_lotto,user_number,bonus_user_number,money);

    }

    private void lottoNumberSave(int money){
        for(int i=0;i<money/1000;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(numbers);
            total_lotto.add(lotto);
        }
    }

    private int requestMoney(){

        view.showMessage(INPUT_MONEY);
        int inputMoney = stringtoIntegerInput(Console.readLine());
        if(exception.moneyValidator(inputMoney)){
            return inputMoney;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    private List<Integer> requestLottoNumber(){

        view.showMessage(INPUT_LOTTO);
        String inputNumber = view.input();
        return lottoMaker.splitNumber(inputNumber);

    }

    private int requestBonusLottoNumber(){

        view.showMessage(INPUT_BONUS_LOTTO);
        int inputNumber = stringtoIntegerInput(view.input());
        lottoMaker.addOverlap(inputNumber);

        if(exception.lottoValidator(inputNumber)&&lottoMaker.overlapException("bonusLotto")){
            return inputNumber;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    private int stringtoIntegerInput(String input){
        if(exception.isNumeric(input))return Integer.parseInt(input);
        throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
    }

}
