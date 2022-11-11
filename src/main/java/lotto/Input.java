package lotto;

public class Input {

    public static void validateLottoNumber(String input) {
        int lottoNumber;
        try {
            lottoNumber = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
        if (lottoNumber < 1 || lottoNumber > 45) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }
}
