package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final int STATIC_LOTTO_NUMBERS_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumbersRange(numbers);
        validateContainNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto newLotto() {
        return new Lotto(randomLottoNumbers());
    }

    private static List<Integer> randomLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < STATIC_LOTTO_NUMBERS_SIZE) {
            int num = RandomNum(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            if (lottoNumbers.contains(num)){
                System.out.println("[ERROR] 로또 번호에 중복된 숫자가 있으면 예외 발생");
            }
            lottoNumbers.add(num);
        }
        return lottoNumbers;
    }

    public static int RandomNum(final int startNum, final int endNum) {
        Random RANDOM = new Random();
        if (startNum < 0) {
            throw new IllegalArgumentException();
        }
        if (startNum > endNum) {
            throw new IllegalArgumentException();
        }
        if (startNum == endNum) {
            return startNum;
        }
        return startNum + RANDOM.nextInt(endNum - startNum + 1);
    }

    public static Lotto newLottoWinningNumbers(String WinningNumbers) {
        ArrayList<Integer> setLottoNumbers = new ArrayList<>();
        for (String number : WinningNumbers.split(",")) {
            validateInt(number);
            setLottoNumbers.add(Integer.parseInt(number));
        }
        return new Lotto(setLottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private static void validateInt(String number) {
        try {
            Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수(1~45)만 입력 가능합니다.");
        }
    }

    private void validateLottoNumbersRange(List<Integer> Numbers) {
        for(Integer number : Numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private void validateContainNumber(List<Integer> Numbers) {
        ArrayList<Integer> li = new ArrayList<>();
        for(Integer number : Numbers) {
            if (li.contains(number)){
                System.out.println("[ERROR] 로또 번호에 중복된 숫자가 있으면 예외가 발생");
            }
            li.add(number);
        }
    }
}
