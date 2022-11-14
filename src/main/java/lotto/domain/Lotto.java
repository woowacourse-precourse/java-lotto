public class Lotto {
    private static final String DUPLICATE_ERROR = "[ERROR] 로또 개수는 중복이 불가능합니다.";
    private static final int LOTTO_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String DELIMITER = ",";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoDuplicate(numbers);

    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()){
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto (String input){
        String[] stringArr = input.split(DELIMITER);
        validateLottoNumbers(stringArr);
    }

    private void validateLottoNumbers(String[] stringArr) {
        validateLottoCount(stringArr);
        validateDuplicateCount(stringArr);
    }

    private void validateLottoCount(String[] array) {
        if (array.length != LOTTO_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 개수는 " + LOTTO_COUNT + "개로 제한됩니다."));
        }
    }

    private void validateDuplicateCount(String[] arr) {
        int distinctCount = calDistinctCountFromArray(arr);

        if (arr.length != distinctCount) {
            throw new IllegalArgumentException(String.format(DUPLICATE_ERROR));
        }
    }
