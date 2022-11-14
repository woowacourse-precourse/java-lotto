package lotto.domain.constant;

public enum ExceptionMessage {
  INPUT_IS_NULL("[ERROR] 입력값이 null입니다."),
  INPUT_IS_ZERO_OR_MINUS("[ERROR] 입력값이 0 혹은 음수입니다."),
  INPUT_IS_NOT_SEPARATED_BY_COMMAS("[ERROR] 입력값은 단일 콤마로 구분되지 않았습니다."),
  INPUT_IS_NOT_SIX_NUMBERS("[ERROR] 입력값의 숫자는 6개가 아닙니다."),
  INPUT_IS_NOT_NUMBER("[ERROR] 입력값은 숫자가 아닙니다."),
  INPUT_NUMBER_RANGE_IS_NOT_CORRECT("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
  INPUT_IS_DUPLICATED("[ERROR] 입력값에 중복된 숫자가 있습니다."),
  INPUT_IS_NOT_MULTIPLE_OF_1000("[ERROR] 입력값은 1000의 배수가 아닙니다.");

  private String message;

  ExceptionMessage(String message){ this.message = message; }

  public String getMessage(){
    return message;
  }
}
