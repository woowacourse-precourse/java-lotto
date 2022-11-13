package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static InputView inputView;
    private static User user;
    private static OutputView outputView;
    private static Lotto lotto;
    private static BonusNumber bonusNumber;
    private static LottoNumber lottoNumber;


    public static void main(String[] args) {
        // TODO: 프로그램 구현\

        inputView = new InputView();
        outputView = new OutputView();
        user = new User();
        bonusNumber = new BonusNumber();

        lottoNumber = new LottoNumber();
        WinDetail winDetail = WinDetail.findRankBy(5,true);

        System.out.println(winDetail);

        String str = inputView.buyLotto();

        user.checkError(str);
        int count = user.lottoCount(str);
        outputView.lottoCountMsg(count);

        List<List<Integer>> lottos = lottoNumber.userLotto(count);
        lottoNumber.printUserLotto(lottos);

        String win = inputView.winningLotto();
        List<Integer> numbers = new ArrayList<>();
        lotto = new Lotto(win, numbers);
        numbers = lotto.change(win);
        
        String bonus = inputView.bonusNumber();
        bonusNumber.checkBonusNumber(numbers, bonus);





    }

}
