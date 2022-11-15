package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int moneyToBuy;
    private final List<Lotto> purchasedLottoTickets = new ArrayList<>();
    private Lotto winningNumber;
    private Integer bonusNumber;
    private int[] winningCount;
    private long earnedMoney;

    /* get method */

    public List<Lotto> getPurchasedLottoTickets() {
        return purchasedLottoTickets;
    }

    public double getRevenue() {
        return ((double)this.earnedMoney / (double)this.moneyToBuy);
    }

    public int[] getWinningCount() {
        return winningCount;
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

    public void setWinningCount() {
        List<Integer> winningRank = new ArrayList<>();
        for (Lotto ticket : this.purchasedLottoTickets) {
            winningRank.add(rankLotto(ticket));
        }
        this.winningCount = countWinningRank(winningRank);
    }

    public void setEarnedMoney() {
        this.earnedMoney = countMoney();
    }

    /* validate method */
    private void validateMoney(String answer) {
        if (checkOnlyNumber(answer) || checkDivisibleNumber(answer)) {
            throw new IllegalArgumentException(ErrorType.INPUT_MONEY_ERROR.getMessage());
        }
    }

    private boolean checkOnlyNumber(String answer) {
        try {
            Integer.parseInt(answer);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean checkDivisibleNumber(String answer) {
        return (Integer.parseInt(answer) % Lotto.PRICE_OF_LOTTO != 0);
    }


    private void checkArrayOnlyNumber(String[] answer) {
        for (String number : answer) {
            if (checkOnlyNumber(number)) {
                throw new IllegalArgumentException(ErrorType.INPUT_WINNING_NUMBER_ERROR.getMessage());
            }
        }
    }

    private void validateBonusNumber(String answerBonusNumber) {
        if (checkOnlyNumber(answerBonusNumber)
                || checkOutOfRange(answerBonusNumber)
                || checkOverlapWinningNumber(answerBonusNumber)) {
            throw new IllegalArgumentException(ErrorType.INPUT_BONUS_NUMBER_ERROR.getMessage());
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

    private int rankLotto(Lotto ticket) {
        int rank;
        int countOfMatches;
        boolean correctBonusNumber = false;
        countOfMatches = compareWinningNumberAndLotto(ticket);
        if (countOfMatches == 5) {
            correctBonusNumber = compareBonusNumberAndLotto(ticket);
        }
        rank = makeRank(countOfMatches, correctBonusNumber);
        return rank;
    }

    private int compareWinningNumberAndLotto(Lotto ticket) {
        int countOfMatches = 0;
        List<Integer> correctNumbers = winningNumber.getLottoNumbers();
        for (Integer number : ticket.getLottoNumbers()) {
            if (correctNumbers.contains(number)) {
                countOfMatches += 1;
            }
        }
        return countOfMatches;
    }

    private boolean compareBonusNumberAndLotto(Lotto ticket) {
        return ticket.getLottoNumbers().contains(this.bonusNumber);
    }

    private int makeRank(int countOfMatches, boolean correctBonusNumber) {
        int[] rank = {5, 4, 3, 1};
        if (countOfMatches < 3) {
            return 0;
        }
        if (countOfMatches == 5 || correctBonusNumber) {
            return rank[countOfMatches - 3] + 1;
        }
        return rank[countOfMatches - 3];
    }

    private int[] countWinningRank(List<Integer> winningRank) {
        int[] winningCount = new int[Lotto.MONEY_OF_RANK.length];
        for (Integer rank : winningRank) {
            if (rank != 0) {
                winningCount[rank - 1] += 1;
            }
        }
        return winningCount;
    }

    private long countMoney() {
        long money = 0;
        for (int rankIndex = 0; rankIndex < this.winningCount.length; rankIndex++) {
            money += this.winningCount[rankIndex] * Lotto.MONEY_OF_RANK[rankIndex];
        }
        return money;
    }

}
