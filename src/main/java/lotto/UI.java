package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoLogic;

public class UI {
    static LottoLogic lottoLogic = new LottoLogic();

    public static String LottoInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println();
        return input;
    }

    public void LottoCountOutput(){
        System.out.println(lottoLogic.getLottoCount()+"개를 구매했습니다.");
    }

    public void PrintLottoNumber(){
        for (int i = 0; i < lottoLogic.getLottos().size(); i++){
            System.out.println(lottoLogic.getLottos().get(i).getLottoNumber());
        }
    }

}
