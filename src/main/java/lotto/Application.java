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

    // 당첨 로또 입력 메소드
    private static Lotto winningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        String[] tempWinningLotto = numbers.split(",");

        winningNumbersException(tempWinningLotto);

        List<Integer> winningLotto = new ArrayList<>();
        for(int i = 0; i < LOTTO_NUM_SIZE; i++) {
            winningLotto.add(Integer.parseInt(tempWinningLotto[i]));
        }
        Lotto lotto = new Lotto(winningLotto);
        return lotto;
    }

    // 당첨 로또 입력 예외처리
    private static void winningNumbersException(String[] tempWinningLottoNumbers) {
        if(tempWinningLottoNumbers.length != LOTTO_NUM_SIZE) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < LOTTO_NUM_SIZE; i++) {
            if(Integer.parseInt(tempWinningLottoNumbers[i]) < 1 || 45 < Integer.parseInt(tempWinningLottoNumbers[i])) {
                numberInputException();
            }
        }
    }

    // 보너스 번호 입력 메소드
    private static int bonusLottoNumber(Lotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if(bonusNumber < 1 || 45 < bonusNumber) {
            numberInputException();
        }
        if(winningLotto.getNumbers().contains(bonusNumber)) {
            System.out.println("[ERROR] 유효하지 않은 번호입니다.");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    // 로또 숫자 범위 예외처리
    private static void numberInputException() {
        System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        throw new IllegalArgumentException();
    }

    // 당첨 계산 카운팅 메소드
    private static List<Double> myWinningCount(List<Lotto> myLottoNumbers, Lotto winningLottoNumbers, int bonusNumber) {
        List<Double> winningCount = new ArrayList<>();
        for(int i = 0; i < myLottoNumbers.size(); i++) {
            double count = oneOfMyWinningCount(myLottoNumbers.get(i), winningLottoNumbers);
            if(count == 5 && myLottoNumbers.get(i).getNumbers().contains(bonusNumber)) {
                count += 0.5;
            }
            winningCount.add(count);
        }
        return winningCount;
    }

    // 로또 1개 당첨 계산 카운팅 메소드
    private static double oneOfMyWinningCount(Lotto oneOfMyLottoNumbers, Lotto winningLottoNumbers) {
        double count = 0.0;
        for(int i = 0; i < LOTTO_NUM_SIZE; i++) {
            if(oneOfMyLottoNumbers.getNumbers().contains(winningLottoNumbers.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
