## 우아한 테크코스 3주차 구현과제 [[미션-로또💸]](https://github.com/woowacourse-precourse/java-lotto) 
***
### 🚀기능 구현 목록
***

⚠️ 절차에 따라 알맞은 메세지를 출력한다. ⚠️

### 1. 구입 금액을 입력받는다.
- 1000원 단위 아닐 시 예외처리
- 유효하지 않은 입력은 예외처리
- 공백은 자동으로 포매팅한다. 포매팅 후에도 유효하지 않은 값일 경우 예외처리한다.

### 2. 당첨 번호를 입력받는다.
- 숫자가 1~45 범위에 속하지 않을 시 예외처리
- “,”로 구분되지 않을 시 예외처리 
- 숫자 중복 시 예외처리
- 숫자 6개 미만 또는 초과 입력 시 예외처리 
- 공백은 자동으로 포매팅한다. 포매팅 후에도 유효하지 않은 값일 경우 예외처리한다.

### 3. 보너스 번호를 입력받는다.
- 숫자가 1~45 범위에 속하지 않을 시 예외처리
- 숫자가 한 개가 아닐 시 예외처리
- 공백은 자동으로 포매팅한다. 포매팅 후에도 유효하지 않은 값일 경우 예외처리한다.

### 4. 결과를 출력한다.
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- 당첨 내역과 수익률(소수점 둘째 자리에서 반올림)을 출력한다.

***
### 🎨클래스 구분 및 메서드 구성 내역
- 참조사항으로 최종 구현 시점까지 언제든 변경 가능하다.
***

## UI
#### 입력
1. class ConsoleUserInput
- List sixWinnningNumbersAndBonusNumber
- inputMoneyForLotto()
- auto_Format()
- inputWinningNumbers()
- inputBounsNumbers()
#### 출력
1. class ConsoleUserOutput
* int NumberOfLottoTickets
* showLottosUserBought()
* showTheNumberOfTickets()
* showTheNumberOfWinningTickets()
* showWinningRate()
#### 예외처리
1. class ExceptionControl
* Boolean invalidInput


## Domain
#### 입력처리(로또 번호 맞추기, 가격에 따라 발급하기)
1. class LottoCounter
- putWinningNumbers(StringTokenizer)()
- arrangeWinningNumbers()
- checkMoneyThousandAsAUnit()

2. class LottoMachine
- drawRandomNumbers()
- putRandomNumbers()
- arrageRandomNumbers()



## enum
1. class RobotClerk
- ASK_MONEY_TO_BUY_LOTTO
- LET_USER_KNOW_THE_NUMBER_OF_TICKETS
- ASK_WINNING_NUMBERS
- ASK_BONUS_NUMBER
- SHOW_WINNING_RATE
- .done()


2. class ErrorClerk
- SHOUT_NOT_NUMBER_ERROR
- SHOUT_NUMBER_RANGE_ERROR
- SHOUT_INVALID_FORMAT_ERROR
- SHOUT_PAYMENT_UNIT_ERROR
- .alarmed() 
