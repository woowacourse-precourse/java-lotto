package lotto.view.printer;

public class OutputPrinter {
    public static void printBuyInformMessage(int numberOfLotto){
        System.out.println(String.format("%d개를 구매했습니다.", numberOfLotto));
    }
}
