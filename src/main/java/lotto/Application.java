package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = inputMoney();
        if (!validateMoney(input)) {
            return;
        }
        int NumberOfLotto = getNumberOfLotto(input);

        List<Lotto> lottoList = makeBunchOfLotto(NumberOfLotto);

        printLottoList(lottoList);
    }

    public static String inputMoney() {
        String input;
        System.out.println("구입금액을 입력해 주세요.");
        input = Console.readLine();
        return input;
    }

    public static boolean validateMoney(String input) {
        int money;
        try {
            if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
                throw new IllegalArgumentException();
            }
            money = Integer.parseInt(input);
            if (money < 1000 || money % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액을 제대로 입력해주세요.");
            return false;
        }
        return true;
    }

    public static int getNumberOfLotto(String input) {
        int money = Integer.parseInt(input);

        return money / 1000;
    }

    public static Lotto makeLottoNumbers() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));

        return lotto;
    }

    public static List<Lotto> makeBunchOfLotto(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottos.add(makeLottoNumbers());
        }
        return lottos;
    }

    public static void printLottoList(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto i : lottos) {
            i.printLotto();
        }
    }
    
    public static String[] inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] result = input.split(",");

        return result;
    }
}