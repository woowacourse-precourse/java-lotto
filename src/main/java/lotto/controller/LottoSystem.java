package lotto.controller;

import lotto.datamodel.*;
import lotto.view.UserInteraction;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {
    public LottoSystem() {
    }

    public void start(){
        UserInteraction user = new UserInteraction();

        int lottoCount;
        int aNumber;
        List<List<Integer>> lottoNumbers;
        List<Integer> numbers;

        //input the money
        String input = user.money();
        try{
            PurchaseAmount purchase = new PurchaseAmount(input);
            lottoCount = purchase.getMoneyCount();

            MakeLottoNumber makeLotto = new MakeLottoNumber(lottoCount);
            lottoNumbers = makeLotto.makeNumbers();
            user.showLotto(lottoCount, lottoNumbers);

            numbers =  user.winningNumbers();
            Lotto win = new Lotto(numbers);

            aNumber = user.bonusNumber();
            BonusLotto bonus = new BonusLotto(aNumber, win.getNumbers());

            CompareLottoNumbers compare = new CompareLottoNumbers(win.getNumbers(), bonus.getBonusNumber());
            List<Integer> prize = compare.calculator(lottoCount, lottoNumbers);

            user.printResult(prize, lottoCount);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 입력값을 정확하게 입력하세요");
        }



    }
}
