package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        int money = getMoneyInput();
        int lottoTicketNum = calculateHowManyTicketUserCanBuy(money);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoTicketNum; i++) {
            lottoList.add(new Lotto(pickLottoNumbersByRandom()));
        }
        List<WinningStatistic> statistics = new ArrayList<>();
//        for (int i = 0; i < lottoTicketNum; i++) {
//            statistics.add(LottoMarker.produceWinningStatistic())
//        }
    }

    private static int getMoneyInput() {
        int moneyInput = getIntegerInput();
        if (moneyInput < 0) {
            throw new IllegalArgumentException();
        }
        return moneyInput;
    }

    private static int getIntegerInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int calculateHowManyTicketUserCanBuy(int money) {
        return money / LottoWinNo.price;
    }

    private static List<Integer> pickLottoNumbersByRandom() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static List<Integer> getLottoNumbersInput() {
        String oneLine = Console.readLine();
        try {
            return Arrays.stream(oneLine.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

}
