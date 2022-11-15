package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final String ERROR_TYPE_NUMBER = "[ERROR]로또 입력 형식을 맞춰주세요.";

    public static List<Integer> lottoNumbers;

    public LottoNumber(String lottoNumber) {
        try {
            Lotto.validate(convertStringArrToIntegerList(lottoNumber));
        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException(e.getMessage());
        }
        validate(lottoNumber);
        lottoNumbers = convertStringArrToIntegerList(lottoNumber);
    }

    public static List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validate(String request) {
        if (!isRightLottoNumbersType(request)) {
            System.out.println(ERROR_TYPE_NUMBER);
            throw new IllegalArgumentException(ERROR_TYPE_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
    public static List<Integer> convertStringArrToIntegerList(String numbers) {
        return List.of(numbers.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static boolean isRightLottoNumbersType(String request) {
        for (int i = 1; i < request.length() - 1; i++) {
            if (request.charAt(i) == ',' && (!(Character.isDigit(request.charAt(i - 1))) ||
                    !(Character.isDigit(request.charAt(i + 1))))) {
                return false;
            }
        }

        if (request.charAt(request.length() - 1) == ',' || request.charAt(0) == ',') {
            return false;
        }
        return true;
    }

}
