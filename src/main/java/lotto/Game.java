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
    private List<Lotto> total_lotto;

    private List<Integer> user_number;
    private int bonus_user_number;



    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String SHOW_LOTTO ="개를 구매했습니다.";
    private final String INPUT_LOTTO = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_LOTTO = "보너스 번호를 입력해 주세요";

    public void run(){
        init();
        int money = requestMoney();
        lottoNumberSave(money);
        view.lottoNumberShow(total_lotto,(money/1000)+SHOW_LOTTO);
        user_number=requestLottoNumber();
        bonus_user_number=requestBonusLottoNumber();


    }

    public void lottoNumberSave(int money){
        for(int i=0;i<money/1000;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(numbers);
            total_lotto.add(lotto);
        }
    }

    public int requestMoney(){

        view.showMessage(INPUT_MONEY);
        int inputMoney = stringtoIntegerInput(Console.readLine());
        if(exception.isNumeric(inputMoney)&&exception.divThousandOfMoney(inputMoney)
                &&exception.lessThanThousand(inputMoney)){

            return inputMoney;
        }
        throw new IllegalArgumentException("ERROR");
    }

    public List<Integer> requestLottoNumber(){

        view.showMessage(INPUT_LOTTO);
        String inputNumber = view.input();
        System.out.println(inputNumber);
        return lottoMaker.splitNumber(inputNumber);

    }

    public int requestBonusLottoNumber(){

        view.showMessage(INPUT_BONUS_LOTTO);
        int inputNumber = stringtoIntegerInput(view.input());
        lottoMaker.addOverlap(inputNumber);

        if(exception.lottoValidator(inputNumber)&&lottoMaker.overlapException("bonusLotto")){
            return inputNumber;
        }
        throw new IllegalArgumentException("ERROR");
    }

    public int stringtoIntegerInput(String input){
        return Integer.parseInt(input);
    }

    private void init(){

        view= new View();
        lottoMaker = new LottoMaker();
        total_lotto = new ArrayList<>();
        exception = new Exception();
    }
}
