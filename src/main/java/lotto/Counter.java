package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.InfoEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Counter {
    private static List<Lotto> lottoList = new ArrayList<>(); //전체 로또 담을 리스트
    public static List<Lotto> getLottoList() {
        return lottoList;
    }
    public static List<Integer> record = new ArrayList<>(List.of(0, 0, 0, 0, 0)); //로또 통계 기록용 리스트
    public static int BONUS;
    public static Lotto winningLotto;
    public static String payMoney;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static int buyLotto() {
        System.out.println(InfoEnum.MONEY.getMessage());
        payMoney = Console.readLine();

        int lottoNumber = 0;

        try {
            lottoNumber = Integer.parseInt(payMoney) / 1000;
        }
        catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
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
            lottoList.add(lotto); //로또 리스트에 담기
            lotto.printNumbers(); //로또 번호 출력
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

        winningLotto = new Lotto(LottoMachine.winningNumber()); //당첨 로또
        LottoMachine.bonusNumber();

        Statistics stat = new Statistics();
        stat.print();
    }
}
