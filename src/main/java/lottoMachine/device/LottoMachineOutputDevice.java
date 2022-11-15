package lottoMachine.device;

import java.util.List;

interface LottoMachineOutputDevice {

    void printReceivePriceMessage();

    void printPurchaseAmount();

    void printLottoTickets();

    void printReceiveWinningNumberMessage();

    void printReceiveBonusNumberMessage();

    void printWinningStatistics(List<Integer> winningHistory);

    void printReturnOfRate(long totalWinningMoney, int purchaseMoney);
}
