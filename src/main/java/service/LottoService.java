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
    private List<Integer> lottoResult;

    public LottoService() {
        lottos = new ArrayList<>();

        winningNumbers = new ArrayList<>();

        lottoResult = new ArrayList<>();
    }

    public void init() {
        System.out.println("구입금액을 입력해 주세요.");

        my_money = inputMoney();

        setLottos();

        System.out.println("\n" + my_money/1000 + "개를 구매했습니다.");

        sort();

        lottoPrint();

        inputWinningNumbers();

        inputBonus();
    }

    public void sort() {
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).sort();
        }
    }

    public void inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        setWinningNumbers();
    }

    public void inputBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요");

        winningNumbers.add(Integer.parseInt(Console.readLine()));
    }

    public void result() {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        setLottoResult();

        System.out.println("3개 일치 (5,000원) - " + matchCount(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCount(4) + "개");
        System.out.println("5개 일치 (1,5000,000원) - " + matchCount(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCount(7) + "개");
                System.out.println("6개 일치 (2,000,000,000원) - " + howMatch(6) + "개");
    }

    public int matchCount(int num) {
        int count = 0;

        for(int i = 0; i < 6; i++) {
            count += howMatch(num);
        }

        return count;
    }

    public int howMatch(int num) {
        if(lottoResult.equals(num)) {
            return 1;
        }
        return 0;
    }

    public void setLottoResult() {
        for(int i = 0; i < my_money / 1000; i++) {
            lottoResult.add(calculateItem(i));
        }
    }

    public int calculateItem(int index) {
        int count = 0;

        for(int i = 0; i < 6; i++) {
            count += isEqual(index, i);
        }

        if(count == 5) {
            count += compareBonus(index);
        }
        return count;
    }

    public int compareBonus(int index) {
        if(lottos.get(index).equals(winningNumbers.get(6))) {
            return 2;
        }

        return 0;
    }

    public int isEqual(int index, int i) {
        if(lottos.get(index).contains(winningNumbers.get(i))) {
            return 1;
        }

        return 0;
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
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void lottoPrint() {
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).print();
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
