### flow

1. 구입 금액 입력 메시지 출력하기
2. 사용자로부터 구입 금액 입력받기
   - 예외처리1 : 1000원 단위로 나누어 떨어지지 않는 경우
   - 예외처리2 : 숫자 외 다른 문자가 입력되는 경우
3. 구매 내역 출력하기
4. 당첨 번호 입력 메시지 출력하기
5. 사용자로부터 당첨 번호 입력받기
   - 예외처리1 : 입력받은 숫자의 범위가 1이상 45이하가 아닌 경우
   - 예외처리2 : 숫자의 개수가 6개 초과 혹은 미만인 경우
   - 예외처리3 : 입력 양식이 틀린 경우
6. 보너스 번호 입력 메시지 출력하기
7. 사용자로부터 보너스 번호 입력받기
    - 예외처리1 : 입력받은 숫자의 범위가 1 이상 45이하가 아닌 경우
    - 예외처리2 : 숫자의 개수가 2개 이상인 경우
    - 예외처리3 : 입력 양식이 틀린 경우
8. 당첨 통계 및 수익률 계산하기
9. 당첨 통계 내역 출력하기

<hr>

### functions

1. 메시지 입력 관련
   - inputMoney : 사용자로부터 구입 금액을 입력 받는다.
   - inputWinningNumber : 사용자로부터 당첨 번호를 입력받는다.
   - inputBonusNumber : 사용자로부터 보너스 넘버를 입력받는다.
2. 메시지 출력 관련
   - printInputMoneyMessage : 구입 금액 입력 안내 메시지를 출력한다.
   - printPurchaseConfirmMessage : 구입 완료 안내 메시지를 출력한다.
   - printInputWinningNumberMessage : 당첨 번호 입력 안내 메시지를 출력한다.
   - printInputBonusNumberMessage : 서비스 번호 입력 안내 메시지를 출력한다.
   - printWinningResult : 당첨 결과를 출력한다.
   - printEarningsRate : 수익률을 출력한다.
3. 계산 관련
   - ticketHowManyLotto : 로또를 몇 개 구입할 것인지 확인한다.
   - ticketLotto : 로또 객체를 만든다.
   - checkWinningNumber : 몇 개의 당첨 번호가 로또에 해당되는지 확인한다.
   - calculateEarningRate : 수익률을 계산한다.
4. 예외처리 관련
   - checkLottoNumberRange : 입력받은 로또 번호의 숫자 범위를 체크한다.
   - checkHowManyNumbers : 입력 받은 숫자의 개수를 체크한다.
   - checkInputForm : 입력 양식을 체크한다.