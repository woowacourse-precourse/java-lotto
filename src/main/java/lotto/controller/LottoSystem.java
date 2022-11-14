package lotto.controller;

import lotto.datamodel.*;
import lotto.view.UserInteraction;
import java.util.List;

public class LottoSystem {
    public LottoSystem() {
    }

    public void start(){
        int lottoCount;
        int bonusInput;
        List<List<Integer>> lottoNumbers;
        List<Integer> numbers;

        UserInteraction user = new UserInteraction();
        String input = user.money();

        try{
            PurchaseAmount purchase = new PurchaseAmount(input);
            lottoCount = purchase.getMoneyCount();

            MakeLottoNumber makeLotto = new MakeLottoNumber(lottoCount);
            lottoNumbers = makeLotto.makeNumbers();
            user.showLotto(lottoCount, lottoNumbers);

            numbers =  user.winningNumbers();
            Lotto win = new Lotto(numbers);

            bonusInput = user.bonusNumber();
            BonusLotto bonus = new BonusLotto(bonusInput, win.getNumbers());

            CompareLottoNumbers compare = new CompareLottoNumbers(win.getNumbers(), bonus.getBonusNumber());
            List<Integer> prize = compare.calculator(lottoCount, lottoNumbers);

            user.printResult(prize, lottoCount);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 입력값을 정확하게 입력하세요");
        }



    }
}
