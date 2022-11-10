# 로또 미션
## 🚀 기능 목록

- [] 구입금액 입력 메세지를 출력한다. - View#PURCHASE_INPUT_GUIDE_MESSAGE
- [] 로또 구입 금액을 입력한다. - Input#userInput()

- [] 구입금액에 해당하는 만큼 로또를 발행해야한다. - Lotto#createLotto()
  - [] 로또 1장의 가격은 1,000원이다. - Lotto#PRICE
  - [] 1개의 로또를 발행할 때 1~45까지의 6개의 숫자를 뽑는다 - Lotto#createNumbers()
    - [] 이 때, 6개의 숫자는 중복되지 않아야한다. - Checker#checkSameNumber()

- [] 구매 메세지를 출력한다. - View#LOTTO_PURCHASED_GUIDE_MESSAGE
  - [] 구매한 만큼 6개의 번호를 출력한다. - View#showLottoNumbers()

- [] 당첨 번호 입력 메세지를 출력한다. - View#WINNING_NUMBER_INPUT_GUIDE_MESSAGE
- [] 당첨 번호 입력 받는다. - Input#userInput()
  - [] 잘못된 값 입력시 예외 발생 - Checker#checkUserInput()

- [] 보너스 번호 메세지를 출력한다. - View#BONUS_NUMBER_GUIDE_MESSAGE
- [] 보너스 번호를 입력 받는다. - Input#userInput()
  - [] 잘못된 값 입력시 예외 발생 - Checker#checkUserInput()

- [] 사용자의 로또 번호와 당첨 번호를 비교한다. - CompareNumbers#compareNumbers()
  - [] 1등: 6개 번호 일치 / 2,000,000,000원 - CompareNumbers#FIRST
  - [] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 - CompareNumbers#SECOND
  - [] 3등: 5개 번호 일치 / 1,500,000원 - CompareNumbers#THIRD
  - [] 4등: 4개 번호 일치 / 50,000원 - CompareNumbers#FOURTH
  - [] 5등: 3개 번호 일치 / 5,000원 - CompareNumbers#FIFTH

- [] 당첨 통계 메세지를 출력한다. - View#WINNING_MESSAGE_GUIDE_MESSAGE
  - [] 각 등수가 몇 개인지 출력한다. - View#showWinnings()

- [] 총 수익률을 출력한다. - View#showYield()

    
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
