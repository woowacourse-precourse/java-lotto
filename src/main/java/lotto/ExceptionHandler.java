package lotto;

public class ExceptionHandler extends IllegalArgumentException{

    public void foolExceaption(String options) {
        if (options.equals("amount")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        if (options.equals("lottoLength")) {
            throw new IllegalArgumentException("[ERROR] 번호의 개수는 6개입니다.");
        }
        if (options.equals("lottoDuplicate")) {
            throw new IllegalArgumentException("[ERROR] 번호에 중복된 숫자가 있습니다.");
        }
        if (options.equals("lottoCondition")) {
            throw new IllegalArgumentException("[ERROR] 번호는 1~45 사이의 수로 이루어져 있습니다.");
        }
        if (options.equals("RandomlottoCondition")) {
            throw new IllegalArgumentException("[ERROR] 동일한 번호의 로또가 있습니다.");
        }
        if (options.equals("Nospace")) {
            throw new IllegalArgumentException("[ERROR] 띄어쓰기는 불가합니다.");
        }
    }
}
