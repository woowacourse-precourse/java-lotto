package constants;

public class ExceptionMessage {
    public static final String prefix = "[ERROR] ";

    public static final String DUPLICATE_NUMBERS = prefix + "각 숫자들은 중복될 수 없습니다.";
    public static final String WITHIN_RANGE = prefix + "로또 번호는 1부터 45사이의 숫자여야 합니다.";
    public static final String MUST_SIX_DIGIT = prefix + "번호는 반드시 6개여야 합니다.";
    public static final String CONTAIN_BONUS = prefix + "보너스 숫자는 당첨 번호들과 중복될 수 없습니다.";
}
