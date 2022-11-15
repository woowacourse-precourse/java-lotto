# 구현할 기능 목록

------------------


* 입력 기능
  * [v] 로또를 구입할 금액 입력 - Controller#inputUserMoney()
    * [v] (금액 예외처리) 1000으로 나누어 떨어지지 않는 경우 - ExceptionController#validateMoney()
      * 에러 문구는 “[ERROR]”로 시작되어야 한다
  * [v] 6자리의 당첨번호 받기 (번호는 쉽표를 기준으로 구분) - Controller#purchaseLotto()
    * [v] (당첨번호 예외처리) 중복되지 않는 숫자 입력 - ExceptionController#validateHasDuplicated()
    * [v] 각 숫자는 1부터 45 사이 이어야 함 - ExceptionController#validateRangeError()
  * [] 보너스번호 따로 입력 받기
    * [] (보너스번호 예외처리) 1의자리 하나가 아닌 경우

* 출력 기능
  * [] 발행한 로또 수량 출력
  * [] 발행한 각 로또들의 번호리스트 출력
  * [] 당첨내역 출력
    * [] 일치 갯수에 따라 구분
    * [] 각 일치 갯수별 당첨 금액
    * [] 각 일치 갯수별 당첨된 로또 갯수
  * [] 수익률 출력 (소수점 둘째자리에서 반올림)
# 코드 수행 흐름도

--------



