package lotto;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;

    public LottoController(InputView inputView, OutputView outputView, LottoFactory lottoFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoFactory = lottoFactory;
    }

    public void lottery(){
        UserMoney money;
        WinningNumbers winningNumbers;

        try{
            money=insertMoney();
        }
        catch (Exception e){
            return;
        }

        try{
            winningNumbers = pickWinningNumbers();
        }
        catch (Exception e){
            return;
        }

        Ticket ticket = purchaseLottoTicket(money);
        Result result = new Result(ticket.checkRankingCount(winningNumbers));
        checkResult(money,result);

    }





    private UserMoney insertMoney(){
        return new UserMoney(inputView.requestUserMoney());
    }

    private Ticket purchaseLottoTicket(UserMoney money) {
        Ticket ticket = new Ticket(lottoFactory.purchaseLottos(money));
        outputView.printLottoTickets(ticket.getTicket());
        return ticket;
    }

    private WinningNumbers pickWinningNumbers() {
        WinningNumbers winningNumbers= new WinningNumbers(inputView.requestWinningNumbers());
        winningNumbers.pickBonusNumber(inputView.requestBonusNumber());
        return winningNumbers;
    }

    private void checkResult(UserMoney money,Result result) {
        outputView.printResult(result.getResult());
        outputView.printProfitRate(result.profitRate(money));
    }


}
