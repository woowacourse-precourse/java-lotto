package lotto;

public class SellingLotto {
    private LottoBuyer buyer;
    private LottoServiceMachine lottoMachine;
    public SellingLotto(){
        buyer = new LottoBuyer();
        lottoMachine = new LottoServiceMachine();
    }
    public void startLotto(){
        buyer.getMoney();
        buyer.buyLotto();
        lottoMachine.getWinningLottoNumber();
        lottoMachine.putInLottoToMachine(buyer.giveLotto());

    }
}
