package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // set으로 변환하여 중복된 숫자를 제거한다
        Set<Integer> numSet = new HashSet<>(numbers);

        if (numbers.size() != 6)
            throw new IllegalArgumentException("로또는 반드시 6개의 숫자가 필요합니다.");

        if(numSet.size() != 6)
            throw new IllegalArgumentException("로또는 중복되지 않은 숫자 6개가 필요합니다.");

        for (Integer integer : numSet) {
            if(integer < 1 || integer > 45)
                throw new IllegalArgumentException("1~45 사이의 숫자를 입력해주세요.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printLottoNumbers(){
        System.out.println(numbers);
    }

    public static Lotto inputWinningLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInputWinningLottoNumbers = Console.readLine();

        List<Integer> winningLottoNumbers = convertStringToIntegerList(userInputWinningLottoNumbers);
        winningLottoNumbers.stream().sorted();

        return new Lotto(winningLottoNumbers);
    }

    public static WINNING checkUserLottoWinning(Lotto winningLotto, Lotto userLotto, int bonusNumber){
        int correctCount = 0;
        boolean bonusNumberCorrect = false;

        for(int i = 0; i < userLotto.numbers.size(); i++){
            int userNumber = userLotto.numbers.get(i);
            // 데이터가 정렬되어 있으므로, 이분탐색으로 탐색
            if(Arrays.binarySearch(winningLotto.numbers.toArray(), userNumber) >= 0)
                correctCount++;

            if(userNumber == bonusNumber)
                bonusNumberCorrect = true;
        }

        return WINNING.fromInteger(correctCount, bonusNumberCorrect);
    }

    private static List<Integer> convertStringToIntegerList(String userInputWinningLottoNumbers) {
        // 유저 로또 문자열을 정수 리스트로 변환
        return Arrays.stream(
                        Stream.of(userInputWinningLottoNumbers.split(","))
                                    .mapToInt(Integer::parseInt)
                                    .toArray())
                        .boxed()
                        .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int userInputBonusNumber = Integer.parseInt(Console.readLine());

        if(userInputBonusNumber < 1 || userInputBonusNumber > 45)
            throw new IllegalArgumentException("1~45 사이의 숫자를 입력해주세요.");

        return userInputBonusNumber;
    }
}
