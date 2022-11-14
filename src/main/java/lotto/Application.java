package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static List<Lotto> lottoList = new ArrayList<>(); //전체 로또 담을 리스트

    private static final int LOTTO_NUMBER = 6;

    public static int BONUS;
    public static Lotto winningLotto;

    public static List<Integer> makeRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static int buyLotto() {
        System.out.println("구매금액을 입력해 주세요.");
        String money = Console.readLine();
        int lottoNumber = Integer.parseInt(money) / 1000;

        return lottoNumber;
    }

    public static void printLotto(int lottoNumber) {
        System.out.println("\n" + lottoNumber + "개를 구매했습니다.");

        for (int cnt = 0; cnt < lottoNumber; cnt++) {
            List<Integer> numbers = makeRandom();
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto); //로또 리스트에 담기
            lotto.printNumbers(); //로또 번호 출옴
        }
    }

    public static List<Integer> winningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        List<Integer> winningNumbersList = new ArrayList<>(); //당첨 번호 담긴 리스트
        StringTokenizer st = new StringTokenizer(numbers, ",");

        while(st.hasMoreTokens()) {
            int element = Integer.parseInt(st.nextToken());
            winningNumbersList.add(element);
        }

        return winningNumbersList;
    }

    public static void bonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        BONUS = Integer.parseInt(Console.readLine());
    }

    public static boolean validBonus(List<Integer> tempLottoNumbers) {
        if (tempLottoNumbers.contains(BONUS)) {
            return true;
        }
        return false;
    }

    public static void printStat() {
        System.out.println("\n당첨 통계\n---");

        List<Integer> record = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)); //로또 통계 기록용 리스트
        int count = 0;
        int element;

        for (int listIdx = 0; listIdx < lottoList.size(); listIdx++) {
            List<Integer> tempLottoNumbers = lottoList.get(listIdx).getNumbers(); //해당 lotto 클래스의 numbers
            count = correctCount(tempLottoNumbers);

            
        }
    }

    public static int correctCount(List<Integer> tempLottoNumbers) {
        int count = 0;
        List<Integer> winningNumbers = winningLotto.getNumbers(); //당첨 로또 번호

        for (int numberIdx = 0; numberIdx < LOTTO_NUMBER; numberIdx++) {
            if (winningNumbers.contains(tempLottoNumbers.get(numberIdx))) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoNumber = buyLotto();
        printLotto(lottoNumber);
        winningLotto = new Lotto(winningNumber()); //당첨 로또
        bonusNumber();
        printStat();
    }
}
