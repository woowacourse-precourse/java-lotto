package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import lotto.Lotto;
import lotto.LottoAnalyzer;
import lotto.message.ErrorMessage;
import lotto.price.Const;
import lotto.util.Util;

public class LottoGameService {

    private List<Lotto> lottoTickets;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int purchaseAmount;
    private LottoAnalyzer lottoAnalyzer;

    public int buyLottoTickets(final String purchaseAmount) {
        validPurchaseAmount(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
        int lottoTickets = this.purchaseAmount / Const.LOTTO_TICKET_PRICE.getValue();
        return lottoTickets;
    }

    private void validPurchaseAmount(final String purchaseAmount) {
        if (!Pattern.matches("^[0-9]*$", purchaseAmount)) {
            throw new IllegalArgumentException(
                ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER.getErrorMessage());
        }

        int value = Integer.parseInt(purchaseAmount);
        if (value % Const.LOTTO_TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(
                ErrorMessage.PURCHASE_AMOUNT_DIVIDE_1000WON.getErrorMessage());
        }
    }

    public Lotto pickWinningNumbers(final String numbers) {
        validWinningNumbers(numbers);
        winningNumbers = Util.stringToIntegerList(numbers);
        return Lotto.drawLotto(winningNumbers);
    }

    private void validWinningNumbers(final String numbers) {
        String[] winningNumbers = numbers.split(",");
        for (String number : winningNumbers) {
            if (!Pattern.matches("^[0-9]*$", number)) {
                throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBER_NOT_NUMBER.getErrorMessage());
            }
        }
    }

    public List<Lotto> saveLottoTickets(final int lottoTicketCount) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTickets.add(Lotto.issueLottoTicket());
        }
        return lottoTickets;
    }

    public int pickBonusNumber(final String bonusNumber) {
        validBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validBonusNumber(final String number) {
        if (!Pattern.matches("^[0-9]*$", number)) {
            throw new IllegalArgumentException(
                ErrorMessage.LOTTO_NUMBER_NOT_NUMBER.getErrorMessage());
        }

        int bonusNumber = Integer.parseInt(number);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getErrorMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OVERLAP.getErrorMessage());
        }
    }

    public LottoAnalyzer lookUpLotto() {
        lottoAnalyzer = new LottoAnalyzer(lottoTickets, winningNumbers, bonusNumber);
        return lottoAnalyzer;
    }

    public String calculateRate(LottoAnalyzer lottoAnalyzer) {
        float rate = (float) lottoAnalyzer.getWholePrizeMoney() / purchaseAmount * 100;
        return String.format("%,.1f",rate)+"%";
    }
}
