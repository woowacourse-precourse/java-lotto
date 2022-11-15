package lotto.service;

import lotto.constant.LotteryRank;
import lotto.domain.LotteryTicket;
import lotto.domain.WinningNumber;
import lotto.repository.LotteryTicketRepository;
import java.util.List;

public class LotteryDrawService {
    public WinningNumber createWinningNumber (List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        return new WinningNumber(numbers, bonusNumber);
    }

    public void updateResult (WinningNumber winningNumber) {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        List<String> lotteryTicketIds = repository.findAllTicketId();

        for (String id : lotteryTicketIds) {
            LotteryTicket ticket = repository.findTicketById(id).get();
            LotteryRank rank = rank(ticket, winningNumber);
            repository.updateResultById(id, rank);
        }
    }

    public LotteryRank rank (LotteryTicket lotteryTicket, WinningNumber winningNumber) {
        List<Integer> ticketNumbers = lotteryTicket.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();
        int numberOfMatches = countNumberOfMatches(ticketNumbers, winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(ticketNumbers, winningNumber.getBonusNumber());
        return LotteryRank.findRank(numberOfMatches, hasBonusNumber);
    }

    private int countNumberOfMatches (List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        return (int) ticketNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean hasBonusNumber (List<Integer> ticketNumbers, int bonusNumber) {
        return ticketNumbers.contains(bonusNumber);
    }
}
