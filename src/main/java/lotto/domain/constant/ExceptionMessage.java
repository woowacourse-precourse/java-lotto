package lotto.domain.constant;

public enum ExceptionMessage {
  INPUT_IS_NOT_SEPARATED_BY_COMMAS("[ERROR] 입력값은 콤마로 구분되지 않았습니다."),
  INPUT_LENGTH_IS_NOT_11("[ERROR] 입력값의 전체 길이는 11이 아닙니다."),
  INPUT_IS_NOT_SIX_NUMBERS("[ERROR] 입력값의 숫자는 6개가 아닙니다."),
  INPUT_IS_NOT_NUMBER("[ERROR] 입력값은 숫자가 아닙니다."),
  INPUT_NUMBER_RANGE_IS_NOT_CORRECT("[ERROR] 입력값은 1이상 45이하의 숫자가 아닙니다."),
  INPUT_IS_DUPLICATED("[ERROR] 입력값에 중복된 숫자가 있습니다.");

  private String message;

  ExceptionMessage(String message){ this.message = message; }

  public String getMessage(){
    return message;
  }
}
