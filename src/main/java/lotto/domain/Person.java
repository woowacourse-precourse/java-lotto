package lotto.domain;

public class Person {
    public static final int FIRST_INDEX = 0;
    public MyLottos myLottos;
    public Lotto winningNumbers;


    public Person(MyLottos myLottos, Lotto winningNumbers) {
        this.myLottos = myLottos;
        this.winningNumbers = winningNumbers;
    }

    public void buyLotto() {
        confirmResult();
    }

    private void confirmResult() {
        for (int myLottosIndex = FIRST_INDEX; myLottosIndex < myLottos.getMyLottoSize(); myLottosIndex++) {
            int hasNumberCount = 0;
            for (int winningNumberIndex = FIRST_INDEX; winningNumberIndex < 6; winningNumberIndex++) {
                int winningNumber = this.winningNumbers.getNumber(winningNumberIndex);
                hasNumberCount = guessCorrectNumber(myLottosIndex, hasNumberCount, winningNumber);
            }
            rankPlace(hasNumberCount);
        }
    }

    private static void rankPlace(int hasNumberCount) {
        Place place = new Place(hasNumberCount);
        place.selectPlace();
    }

    private int guessCorrectNumber(int myLottosIndex, int hasNumberCount, int winningNumber) {
        if (myLottos.getMyLotto(myLottosIndex).contain(winningNumber)) {
            hasNumberCount++;
        }
        return hasNumberCount;
    }
}
