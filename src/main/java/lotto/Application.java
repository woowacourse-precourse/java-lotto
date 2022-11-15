package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoSeller seller = new LottoSeller();

            seller.makeLottoBundle();
            seller.printBundle();

            NumberComparator comparator = new NumberComparator();
            comparator.compareNumber(seller.getBundle());

            WinningPayer payer = new WinningPayer(comparator.getResult(), seller.getMoney());
            payer.repeatTransforamtion();
            payer.calculateWinningRate();
            payer.printResult();
        }
        catch(ArithmeticException error) {
            System.out.println(error.getMessage());
        }
    }
}
