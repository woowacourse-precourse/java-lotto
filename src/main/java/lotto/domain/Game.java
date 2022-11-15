package lotto.domain;

import lotto.view.InputView;

public class Game {

    public void playGame() {
        InputView inputView = new InputView();
        LottoCreate lottoCreate = new LottoCreate();
        Compare compare = new Compare();

        inputView.purchasedLotto();
        lottoCreate.createLottos();

        inputView.input_Lotto_Numbers();

        inputView.input_Bonus_Number();
        compare.compare_Numbers_Group(lottoCreate.lottoGroups, inputView.lottoNum, inputView.bonusNum);
        compare.printRank();
        compare.printTotalRate(inputView.getInputMoney());
    }

}
