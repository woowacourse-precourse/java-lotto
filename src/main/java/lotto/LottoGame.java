package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int moneyToBuy;
    private final List<Lotto> purchasedLottoTickets = new ArrayList<>();
    private Lotto winningNumber;
    private Integer bonusNumber;

    /* get method */
    public List<Lotto> getPurchasedLottoTickets() {
        return purchasedLottoTickets;
    }

    /* set method */
    public void setMoneyToBuy(String answer) {
        validateMoney(answer);
        this.moneyToBuy = Integer.parseInt(answer);
    }

    public void setWinningNumber(String[] answer) {
        checkArrayOnlyNumber(answer);
        this.winningNumber = makeArrayToLotto(answer);
    }

    public void setBonusNumber(String answer) {
        validateBonusNumber(answer);
        this.bonusNumber = Integer.parseInt(answer);
    }

    /* validate method */
    public void validateMoney(String answer) {
        if (checkOnlyNumber(answer) || checkDivisibleNumber(answer)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkOnlyNumber(String answer) {
        return (answer.matches("[^0-9]"));
    }

    private boolean checkDivisibleNumber(String answer) {
        return (Integer.parseInt(answer) % Lotto.PRICE_OF_LOTTO != 0);
    }


    private void checkArrayOnlyNumber(String[] answer) {
        for (String number : answer) {
            if (checkOnlyNumber(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateBonusNumber(String answerBonusNumber) {
        if (checkOnlyNumber(answerBonusNumber)
                || checkOutOfRange(answerBonusNumber)
                || checkOverlapWinningNumber(answerBonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkOutOfRange(String answerBonusNumber) {
        return (Integer.parseInt(answerBonusNumber) > Lotto.MAX_NUMBER
                || Integer.parseInt(answerBonusNumber) < Lotto.MIN_NUMBER);
    }

    private boolean checkOverlapWinningNumber(String answerBonusNumber) {
        Integer bonusNumber = Integer.parseInt(answerBonusNumber);
        for (Integer lottoNumber : this.winningNumber.getLottoNumbers()) {
            if (lottoNumber.equals(bonusNumber)) {
                return true;
            }
        }
        return false;
    }

    /* else */
    public void buyLotto() {
        for (int count = 0; count < this.moneyToBuy; count += Lotto.PRICE_OF_LOTTO) {
            this.purchasedLottoTickets.add(createLotto());
        }
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LOTTO_SIZE));
    }

    private Lotto makeArrayToLotto(String[] answer) {
        List<Integer> answerNumber = new ArrayList<>();
        for (String number : answer) {
            answerNumber.add(Integer.parseInt(number));
        }
        return new Lotto(answerNumber);
    }
}
