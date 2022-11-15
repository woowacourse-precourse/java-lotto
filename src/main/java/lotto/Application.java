package lotto;

import java.util.HashMap;
import java.util.List;

public class Application {
    private static List<Lotto> lottoList;
    private static WinLotto winLotto;
    private static int amount;

    public static void main(String[] args) {
        try {
            // 구입 금액 입력
            System.out.println(OutputMessage.PRICE.get());
            Price price = inputPrice();

            // 수량 만큼 로또 발행
            issueLotteries(price);
            System.out.println(amount + OutputMessage.AMOUNT.get());
            for (int i = 0; i < amount; i++)
                System.out.println(lottoList.get(i).getNumbers());

            // 당첨 번호, 보너스 번호 입력
            inputWinLotto();

            // 당첨 내역 구하기
            WinManager winManager = new WinManager(winLotto, lottoList);
            HashMap<String, Integer> matches = winManager.get();
            calculateYield(price, matches);

        }
        catch (IllegalArgumentException e) {
        }
    }

    private static Price inputPrice() {
        String price = KeyboardInput.read();
        return new Price(price);
    }

    private static void issueLotteries(Price price) {
        LottoIssuer lottoIssuer = new LottoIssuer(price);
        amount = lottoIssuer.getAmount();
        lottoList = lottoIssuer.get();
    }

    private static void inputWinLotto() {
        WinLottoIssuer winLottoIssuer = new WinLottoIssuer();
        winLotto = winLottoIssuer.get();
    }

    private static void calculateYield(Price price, HashMap<String, Integer> matches) {
        double sum = 0;
        double yield = 0.0;

        HashMap<String, Integer> prizes = new HashMap<>(5);
        prizes.put("3", 5_000);
        prizes.put("4", 50_000);
        prizes.put("5", 1_500_000);
        prizes.put("5+1", 30_000_000);
        prizes.put("6", 2_000_000_000);

        for(String key : matches.keySet()){
//            System.out.println(matches.get(key) * prizes.get(key));
            sum += matches.get(key) * prizes.get(key);
        }

        yield = (sum / price.get()) * 100; // 당첨금액/구입금액
        System.out.println(yield);
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }


}
