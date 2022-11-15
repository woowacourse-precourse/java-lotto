package service;

import model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private int my_money;
    private final Lotto lotto;
    private static List<Integer> winningNumbers;

    public LottoService() {
        lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));

        winningNumbers = new ArrayList<>();
    }

    public void init() {
        System.out.println("구입금액을 입력해 주세요.");

        my_money = inputMoney();

        System.out.println("8개를 구매했습니다.");

        System.out.println("당첨 번호를 입력해 주세요.");

        setWinningNumbers();

        System.out.println("보너스 번호를 입력해 주세요");

        winningNumbers.add(Integer.parseInt(Console.readLine()));
    }

    public int inputMoney() {
        int money = Integer.parseInt(Console.readLine());

        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        }

        return money;
    }

    public String inputNumbers() {
        return Console.readLine();
    }

    public void setWinningNumbers() {
        String line = inputNumbers();

        String[] strings = line.split(",");

        converToIntegerList(strings);
    }

    public void converToIntegerList(String[] strings) {
        /**
         * 스트링 배열에서 Integer로 변환 후 당첨번호로 저장해 주는 함수
         **/
        for(int i = 0; i < strings.length; i++) {
            winningNumbers.add(Integer.parseInt(strings[i]));
        }
    }

    public void printWinningNumbers() {
        for(int i = 0; i < winningNumbers.size(); i++) {
            System.out.print(winningNumbers.get(i));
        }

        System.out.println("보너스 번호: " + winningNumbers.get(6));
    }
}
