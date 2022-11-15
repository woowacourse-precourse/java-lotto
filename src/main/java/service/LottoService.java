package service;

import model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private int my_money;
    private List<Lotto> lottos;
    private static List<Integer> winningNumbers;

    public LottoService() {
        lottos = new ArrayList<>();

        winningNumbers = new ArrayList<>();
    }

    public void init() {
        System.out.println("구입금액을 입력해 주세요.");

        my_money = inputMoney();

        setLottos();

        System.out.println("\n" + my_money/1000 + "개를 구매했습니다.");

        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).print();
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");

        setWinningNumbers();

        System.out.println("\n보너스 번호를 입력해 주세요");

        winningNumbers.add(Integer.parseInt(Console.readLine()));
    }

    public void result() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
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

    public List<Integer> getNumbers(String line) {
        String[] strings = line.split(",");
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < strings.length; i++) {
            numbers.add(Integer.parseInt(strings[i]));
        }

        return numbers;
    }

    public void setLottos() {
        for(int i = 0; i < my_money / 1000; i++) {
            lottos.add(new Lotto(getNumbers(Console.readLine())));
        }
    }

    public void printAll() {
        System.out.print("당첨 번호: ");

        for(int i = 0; i < winningNumbers.size(); i++) {
           System.out.print(winningNumbers.get(i) + " ");
        }

        System.out.println();

        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).print();
        }

        System.out.println("\n보너스 번호: " + winningNumbers.get(6));
    }
}
