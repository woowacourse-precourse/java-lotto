package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.MoneyParser;
import lotto.model.SingleLottoNumValidator;
import lotto.model.WinningNumberParser;
import lotto.view.Terminal;
import lotto.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSystem {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final int LOTTO_NUM_COUNT = 6;

    private final View view = new Terminal();

    //TODO 지역변수로 함수끼리 주고받도록 수정
    private List<Lotto> boughtLottoes;
    private List<Integer> winningNumbers;
    int bonusNumber;

    public void run() {
        buy();
        draw();
        result();
    }

    private void buy() {
        MoneyParser moneyParser = new MoneyParser();
        int lottoCount = moneyParser.parse(view.requestMoney()) / LOTTO_PRICE;
        view.printLottoCount(lottoCount);
        boughtLottoes = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            boughtLottoes.add(new Lotto(numbers));
        }
        view.printLotto(boughtLottoes);
    }

    private void draw() {
        WinningNumberParser winningNumberParser = new WinningNumberParser();
        winningNumbers = winningNumberParser.parse(view.requestWinningNumbers());
        SingleLottoNumValidator singleLottoNumValidator = new SingleLottoNumValidator();
        String inputBonusNumber = view.requestBonusNumber();
        singleLottoNumValidator.validate(inputBonusNumber);
        bonusNumber = Integer.parseInt(inputBonusNumber);
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 추첨 숫자들과 중복될 수 없습니다.");
        }
    }

    private void result() {

    }
}
