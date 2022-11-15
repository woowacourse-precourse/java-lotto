package lotto;

public class Application {
    public static void main(String[] args) {
        LottoSeller seller = new LottoSeller();

        seller.takeMoney();
        seller.makeLottoBundle();
        seller.showBundle();

        NumberComparator comparator = new NumberComparator();

        comparator.setWinningNumber();
        comparator.setBonusNumber();
        comparator.compareNumbers(seller.get());

        WinningPayer payer = new WinningPayer(comparator.result, seller.money);

        payer.makeEnumMap();
        payer.countPrize();
        payer.calculateWinningRate();
        payer.informResult();
    }
}
