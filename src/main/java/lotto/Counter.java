package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.InfoEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Counter {
    private static List<Lotto> lottoList = new ArrayList<>(); //전체 로또 담을 리스트
    public static List<Integer> record = new ArrayList<>(List.of(0, 0, 0, 0, 0)); //로또 통계 기록용 리스트
    public static int BONUS;
    public static String payMoney;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static List<Lotto> getLottoList() {
        return lottoList;
    }

    public static int buyLotto() {
        System.out.println(InfoEnum.MONEY.getMessage());
        payMoney = Console.readLine();

        int lottoNumber = 0;

        try {
            lottoNumber = Integer.parseInt(payMoney) / 1000;
            if (Integer.parseInt(payMoney) % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE + " 1000원 단위의 숫자 형태로 입력해주세요.");
        }
        catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + " 1000원 단위로 입력해주세요.");
        }

        return lottoNumber;
    }

    public static List<Integer> makeRandom() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);

        return numbers;
    }

    public static void printLotto(int lottoNumber) {
        System.out.println("\n" + lottoNumber + InfoEnum.BUY_NUMBER.getMessage());

        for (int cnt = 0; cnt < lottoNumber; cnt++) {
            Lotto lotto = new Lotto(makeRandom());
            lottoList.add(lotto);
            lotto.printNumbers();
        }
    }

    public static void inputException(String numbers) {
        try {
            if (!numbers.contains(",")) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void play() {
        int lottoNumber = buyLotto();
        printLotto(lottoNumber);
    }
}
