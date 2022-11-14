package lotto.model;

import lotto.views.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public static final int FIRST_INDEX = 0;
    public static final int INIT_NUMBER_COUNT = 0;
    public static final int INIT_BONUS_COUNT = 0;
    public static final int COUNT_PLUS_ONE = 1;
    public static final int NO_COUNT = 0;
    public MyLottos myLottos;
    public Lotto winningNumbers;


    public Person(MyLottos myLottos, Lotto winningNumbers) {
        this.myLottos = myLottos;
        this.winningNumbers = winningNumbers;
    }

    public void buyLotto() {
        List<PlaceStatus> myPlaces = confirmResult();
        Result lottoResult = new Result(myPlaces);
        lottoResult.getWinningResult();
        ResultView.printWinningResult(lottoResult);
    }

    private List<PlaceStatus> confirmResult() {
        List<PlaceStatus> myPlaces = new ArrayList<>();
        for (int myLottosIndex = FIRST_INDEX; myLottosIndex < myLottos.getMyLottoSize(); myLottosIndex++) {
            int numberCount = INIT_NUMBER_COUNT;
            int bonusCount = INIT_BONUS_COUNT;
            for (int winningNumberIndex = FIRST_INDEX; winningNumberIndex < 6; winningNumberIndex++) {
                int winningNumber = this.winningNumbers.getNumber(winningNumberIndex);
                numberCount = guessCorrectNumber(myLottosIndex, numberCount, winningNumber);
                bonusCount = guessBonusNumber(myLottosIndex, Bonus.getBonusNumber());
            }
            myPlaces.add(rankPlace(numberCount, bonusCount));
        }
        return myPlaces;
    }

    private int guessBonusNumber(int myLottosIndex, int bonusNumber) {
        if (myLottos.getMyLotto(myLottosIndex).contain(bonusNumber)) {
            return COUNT_PLUS_ONE;
        }
        return NO_COUNT;
    }

    private PlaceStatus rankPlace(int hasNumberCount, int bonusCount) {
        Place place = new Place(hasNumberCount, bonusCount);
        return place.selectPlace();
    }

    private int guessCorrectNumber(int myLottosIndex, int numberCount, int winningNumber) {
        if (myLottos.getMyLotto(myLottosIndex).contain(winningNumber)) {
            numberCount++;
        }
        return numberCount;
    }
}
