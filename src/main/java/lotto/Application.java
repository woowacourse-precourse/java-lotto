package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int LOTTO_NUM_SIZE = 6;

    // 로또 구입 메소드
    private static int buyLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if(!checkNumber(input)) {
            System.out.println("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(input);
        if(money%1000 != 0) {
            System.out.println("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        int lottoCount = money/1000;
        return lottoCount;
    }

    // 입력값 숫자인지 확인 메소드
    private static boolean checkNumber(String input){
        char check;
        if(input.equals("")) {
            return false;
        }
        for(int i = 0; i < input.length(); i++){
            check = input.charAt(i);
            if(check < 48 || check > 58) {
                return false;
            }
        }
        return true;
    }

    // 나의 로또 생성 메소드
    private static List<Lotto> myLotto(int lottoCount) {
        List<Lotto> myLotto = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUM_SIZE);
//            Collections.sort(numbers);
            sortLotto(numbers);
            Lotto lotto = new Lotto(numbers);
            myLotto.add(lotto);
        }
        return myLotto;
    }

    // 로또 오름차순 정렬 메소드
    private static List<Integer> sortLotto(List<Integer> numbers) {
        for(int i = 0; i < numbers.size() - 1; i++) {
            for(int j = i + 1; j < numbers.size(); j++) {
                numbers = changeNumbers(numbers, i ,j);
            }
        }
        return numbers;
    }

    // 오름차순 숫자 바꾸기 메소드
    private static List<Integer> changeNumbers(List<Integer> numbers, int i, int j) {
        if(numbers.get(i) > numbers.get(j)) {
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(j));
            numbers.set(j, temp);
        }
        return numbers;
    }

    // 나의 로또 출력 메소드
    private static void printMyLotto(List<Lotto> myLotto) {
        System.out.println(myLotto.size() + "개를 구매했습니다.");
        for(int i = 0; i < myLotto.size(); i++) {
            System.out.println(myLotto.get(i).getNumbers());
        }
    }
    public static void main(String[] args) {

    }
}
