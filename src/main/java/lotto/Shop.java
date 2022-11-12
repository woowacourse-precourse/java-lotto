package lotto;

public class Shop {

    Buyer buyer = new Buyer();
    LottoMachine lottoMachine = new LottoMachine();
    Printer printer = new Printer();

    public Shop() {

    }

    public void sellLottos() {
        buyer.payMoney();
        int money = Buyer.money;
        printer.printHowManyLottos(money);
        lottoMachine.makeLottos(money);
    }
}
