package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Printer {

    public enum LottoMatchMoney {
        THREE("3개 일치 (5,000원) - "),
        FOUR("4개 일치 (50,000원) - "),
        FIVE("5개 일치 (1,500,000원) - "),
        FIVEBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        SIX("6개 일치 (2,000,000,000원) - ");
        private String numberMessage;
        LottoMatchMoney(String numberMessage) {
            this.numberMessage = numberMessage;
        }

        public String getNumberMessage() {
            return numberMessage;
        }
    }

    public enum Message{
        BUY("개를 구매했습니다."),
        STATICS ( "당첨 통계\n---"),
        REVENUE ( "총 수익률은 "),
        REVENUE2 ( "%입니다."),
        UNIT ( "개");

        private String message;


        Message(String message) {
            this.message = message;
        }

        public String getOutputMessage(){
            return message;
        }
    }
    Message buyMessage = Message.BUY;
    String buy = buyMessage.getOutputMessage();

    Message staticsMessage = Message.STATICS;
    String statics = staticsMessage.getOutputMessage();

    Message revenueMessage = Message.REVENUE;
    String revenue = revenueMessage.getOutputMessage();

    Message revenueTwoMessage = Message.REVENUE2;
    String revenue2 = revenueTwoMessage.getOutputMessage();

    Message unitMessage = Message.UNIT;
    String unit = unitMessage.getOutputMessage();


    public void printToDo(String toDo) {
        System.out.println(toDo);
    }

    public void printUserLottoNumber(List<List<Integer>> lottoInput) {

        int amountLotto = lottoInput.size();

        System.out.println(amountLotto + this.buy);

        for (int i = 0; i < amountLotto; i++) {
            System.out.println(lottoInput.get(i));
        }

    }

    public void printWinList(List<Integer> correctNumberList) {
        List<Integer> amountEachWin = knowAmountEachWin(correctNumberList);

        System.out.println(this.statics);

        for (LottoMatchMoney matchNumber : LottoMatchMoney.values()) {
            int index = matchNumber.ordinal();

            String numberMessage = matchNumber.getNumberMessage();

            System.out.println(numberMessage + amountEachWin.get(index) + this.unit);
        }
    }

    public List<Integer> knowAmountEachWin(List<Integer> correctNumberList) {

        List<Integer> frequencyList = new ArrayList<>();

        for (int i = 3; i < 8; i++) {
            int frequency = Collections.frequency(correctNumberList, i);
            frequencyList.add(frequency);

        }
        return frequencyList;
    }

    public void printRevenuePercent(int inputMoney, int revenue) {

        double doubleInputMoney = inputMoney;
        double doubleRevenue = revenue;

        double revenuePercent = doubleRevenue / doubleInputMoney * 100;

        System.out.println(this.revenue + String.format("%.1f", revenuePercent) + this.revenue2);

    }

}
