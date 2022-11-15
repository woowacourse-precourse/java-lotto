package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Lotto> lottoList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            System.out.println(OutputMessage.PRICE.get());
            Price p = new Price();
            LottoManager lottoManager = new LottoManager(p);
            System.out.println(lottoManager.getAmount() + OutputMessage.AMOUNT.get());
            lottoManager.printLotteries();

            int count = p.get() / 1000;
            System.out.println(count + OutputMessage.COUNT.get());

            // 로또 수량 만큼 로또 생성
            createLottos(count);
            for (int i = 0; i < count; i++)
                System.out.println(lottoList.get(i).get());

            // 당첨 번호, 보너스 번호 입력
            // 당첨 내역 구하기
        }
        catch (IllegalArgumentException e) {
        }
    }

    public static void createLottos(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 6) {
                int randomNumber = Randoms.pickNumberInRange(1, 45);
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }
            lottoList.add(new Lotto(numbers));
        }
    }

}
