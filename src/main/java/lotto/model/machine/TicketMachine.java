package lotto.model.machine;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.LongStream;

import lotto.io.Output;
import lotto.io.Message;

import lotto.model.Money;

import lotto.model.lucky.BonusNumber;
import lotto.model.lucky.WinningNumber;

public class TicketMachine {

    private final Money money;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private final List<LottoTicket> lottoTickets;
    private final NumbersMatchRepository numbersMatchRepository;

    public TicketMachine(Money money) {
        this.money = money;
        this.lottoTickets = new ArrayList<>();
        this.numbersMatchRepository = new NumbersMatchRepository();
    }

    public void generateTickets() {
        LongStream.range(0, money.countInThousands())
                .forEach(i -> lottoTickets.add(new LottoTicket()));
    }

    public void showAllTickets(Output output) {
        output.print(Message.QUANTITY, money.countInThousands());
        LongStream.range(0, money.countInThousands())
                .forEach(i -> lottoTickets.get((int) i).showTicketNumbers(output));
    }

    public void calculateResult() {
        numbersMatchRepository.compareLotto(lottoTickets, winningNumber, bonusNumber);
    }

    public void showResult(Output output) {
        numbersMatchRepository.showWinningHistory(output);
        numbersMatchRepository.showYield(output, money);
    }
    public void setWinningNumber(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

}
