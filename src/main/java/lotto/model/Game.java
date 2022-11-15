package lotto.model;

import lotto.io.Input;
import lotto.io.Message;
import lotto.io.Output;

import lotto.model.lucky.BonusNumber;
import lotto.model.machine.TicketMachine;
import lotto.model.lucky.WinningNumber;

public class Game {

    private final Input input;
    private final Output output;

    public Game(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        output.print(Message.MONEY_INPUT);
        Money money = inputMoney();
        TicketMachine ticketMachine = setTicketMachine(money);
        ticketMachine.generateTickets();
        ticketMachine.showAllTickets(output);

        inputLuckyNumber(ticketMachine);

        output.print(Message.STATISTICS);
        outputStatistics(ticketMachine);
    }

    public Money inputMoney() {
        return new Money(this.input.scan());
    }

    public TicketMachine setTicketMachine(Money money) {
        return new TicketMachine(money);
    }

    public void inputLuckyNumber(TicketMachine ticketMachine) {
        output.print(Message.WINNING_INPUT);
        WinningNumber winningNumber = inputWinningNumber();
        ticketMachine.setWinningNumber(winningNumber);

        output.print(Message.BONUS_INPUT);
        BonusNumber bonusNumber = inputBonusNumber(winningNumber);
        ticketMachine.setBonusNumber(bonusNumber);
    }

    public WinningNumber inputWinningNumber() {
        String inputWinningNumber = this.input.scan();
        return new WinningNumber(inputWinningNumber);
    }

    public BonusNumber inputBonusNumber(WinningNumber winningNumber) {
        String inputBonusNumber = this.input.scan();
        return new BonusNumber(inputBonusNumber, winningNumber);
    }


    public void outputStatistics(TicketMachine ticketMachine) {
        ticketMachine.calculateResult();
        ticketMachine.showResult(output);
    }

}
