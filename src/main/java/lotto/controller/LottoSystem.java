package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
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
    int money;

    public void run() {
        buy();
        draw();
        result();
    }

    private void buy() {
        MoneyParser moneyParser = new MoneyParser();
        money = moneyParser.parse(view.requestMoney());
        int lottoCount = money / LOTTO_PRICE;
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
        for(Lotto lotto : boughtLottoes) {
            MatchedResult matchedResult = lotto.checkPrizes(winningNumbers, bonusNumber);
            if(matchedResult.getMatchedNum() == Rank.FIRST.getMatchCount()) {
                Rank.FIRST.setAchievedCount(Rank.FIRST.getAchievedCount() + 1);
            } else if (matchedResult.getMatchedNum() == Rank.SECOND.getMatchCount() && matchedResult.isBonusMatched()) {
                Rank.SECOND.setAchievedCount(Rank.SECOND.getAchievedCount() + 1);
            } else if (matchedResult.getMatchedNum() == Rank.THIRD.getMatchCount()) {
                Rank.THIRD.setAchievedCount(Rank.THIRD.getAchievedCount() + 1);
            } else if (matchedResult.getMatchedNum() == Rank.FOURTH.getMatchCount()) {
                Rank.FOURTH.setAchievedCount(Rank.FOURTH.getAchievedCount() + 1);
            } else if (matchedResult.getMatchedNum() == Rank.FIFTH.getMatchCount()) {
                Rank.FIFTH.setAchievedCount(Rank.FIFTH.getAchievedCount() + 1);
            }
        }
        int income = 0;
        for (Rank rank : Rank.values()) {
            income += rank.getPrize() * rank.getAchievedCount();
        }
        double ratio = income / money;
        view.printResult(ratio);
    }
}
