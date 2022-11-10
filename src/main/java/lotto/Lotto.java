package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // set으로 변환하여 중복된 숫자의 사용을 감지한다
        Set<Integer> numSet = new HashSet<>(numbers);

        if (numbers.size() != 6)
            throw new IllegalArgumentException("로또는 반드시 6개의 숫자가 필요합니다.");

        if(numSet.size() != 6)
            throw new IllegalArgumentException("로또는 중복되지 않은 숫자 6개가 필요합니다.");
    }

    // TODO: 추가 기능 구현
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

    public static WINNINGS checkUserLottoWinning(Lotto winningLotto, Lotto userLotto, int bonusNumber){
        int correctCount = 0;
        boolean bonusNumberCorrect = false;

        for(int i = 0; i < winningLotto.numbers.size(); i++){
            int winningNumber = winningLotto.numbers.get(i);
            int userNumber = userLotto.numbers.get(i);

            if(winningNumber == userNumber)
                correctCount++;

            if(userNumber == bonusNumber)
                bonusNumberCorrect = true;
        }

        return WINNINGS.fromInteger(correctCount, bonusNumberCorrect);
    }

    private static List<Integer> convertStringToIntegerList(String userInputWinningLottoNumbers) {
        return Arrays.stream(
                        Stream.of(userInputWinningLottoNumbers.split(","))
                                    .mapToInt(Integer::parseInt)
                                    .toArray())
                        .boxed()
                        .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
