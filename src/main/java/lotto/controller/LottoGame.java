package lotto.controller;

import lotto.domain.*;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {
    private static final String DELIM = ",";
    private final User user;
    private final Result result;
    private final WinningNumber winningNumber;

    public LottoGame(User user, Result result) {
        this.user = user;
        this.result = result;
        this.winningNumber = new WinningNumber();
    }

    public void run() {
        String money = init();
        validateMoney(money);
        setUser(Integer.parseInt(money), LottoService.generate(Integer.parseInt(money)));
        printAllTickets(user.getTickets());
        getWinningNumber();
        getBonusNumber();
        RatingService.service(result, user.getTickets(), winningNumber);
        printAllRating();

    }

    public String init() {
        OutputView.printStartMessage();
        return readLine();
    }

    public void validatePublic(String input) {
        Validation.validateInteger(input);
        Validation.isStartWithZero(input);
    }

    public void validateMoney(String input) {
        validatePublic(input);
        Validation.validateAmount(Integer.parseInt(input));
    }

    public void setUser(int money, List<Lotto> tickets) {
        user.setMoney(money);
        user.setTickets(tickets);
    }

    public void printAllTickets(List<Lotto> tickets) {
        OutputView.printNotificationMessage(user.getTickets().size());
        for (Lotto ticket : tickets) {
            OutputView.printLottoTickets(ticket.toString());
        }
    }

    public void getWinningNumber() {
        OutputView.printReceiveWinningMessage();
        String winningNumber = readLine();
        validateWinningNumber(winningNumber);
        this.winningNumber.setNumber(translateWinningNumber(winningNumber));
    }

    public void validateWinningNumber(String winningNumber) {
        StringTokenizer st = new StringTokenizer(winningNumber, DELIM);
        Validation.validateNumbers(st.countTokens());
        while (st.hasMoreTokens()) {
            String number = st.nextToken();
            validatePublic(number);
            Validation.validateRange(Integer.parseInt(number));
        }
    }

    public List<Integer> translateWinningNumber(String winningNumber) {
        List<Integer> winningTicket = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(winningNumber, DELIM);

        while(st.hasMoreTokens()) {
            winningTicket.add(Integer.parseInt(st.nextToken()));
        }

        return winningTicket;
    }

    public void getBonusNumber() {
        OutputView.printReceiveBonusMessage();
        String bonus = readLine();
        validatePublic(bonus);
        Validation.validateRange(Integer.parseInt(bonus));
        Validation.validateDuplication(winningNumber.getNumber(), Integer.parseInt(bonus));
        winningNumber.setBonus(Integer.parseInt(bonus));

    }

    public void printAllRating() {
        OutputView.printBeforeResultMessage();
        for (Rating rating : Rating.values()) {
            OutputView.printResultMessage(rating.getCount(), rating.getWrappingReward(), result.getResult(rating));
        }

    }
}
