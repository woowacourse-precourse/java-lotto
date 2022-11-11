# 로또 게임
## 🚀 기능 목록

- [x] 구입금액 입력 메세지를 출력한다. - View#PURCHASE_INPUT_GUIDE_MESSAGE
- [x] 로또 구입 금액을 입력한다. - Input#userInput()
  - [x] 잘못된 값 입력시 예외 발생 - Checker#checkUserInput()

- [x] 구입금액에 해당하는 만큼 로또를 산다. - LottoProgram#createLotto()
  - [x] 1~45까지의 6개의 숫자를 뽑는다 - LottoProgram#createLottoNumbers()
  - [x] 로또의 숫자를 오름차순으로 정렬한다 - LottoProgram#createLotto()

- [x] 구매 메세지를 출력한다. - View#LOTTO_PURCHASED_GUIDE_MESSAGE
  - [x] 로또들의 숫자들을 출력한다. - View#showLottoNumbers()

- [x] 당첨 번호 입력 메세지를 출력한다. - View#WINNING_NUMBER_INPUT_GUIDE_MESSAGE
- [x] 당첨 번호 입력 받는다. - Input#userInput()
  - [x] 잘못된 당첨 번호값 입력시 예외 발생 - Checker#checkWinningNumberInput()

- [x] 보너스 번호 메세지를 출력한다. - View#BONUS_NUMBER_GUIDE_MESSAGE
- [x] 보너스 번호를 입력 받는다. - Input#userInput()
  - [x] 잘못된 보너스 번호 입력시 예외 발생 - Checker#checkBonusNumberInput()

- [x] 사용자의 로또 번호와 당첨 번호를 비교한다. - makeWinner#compareNumbers()
  - [x] List에 n등에 대한 맞춰야하는 번호, 보너스 번호 맞춤여부, 상금을 담음 - makeWinner#initWinnerPrize()
    - [x] 1등: 6개 번호 일치 / 2,000,000,000원 - MakeWinner#initWinnerPrize()
    - [x] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 - MakeWinner#initWinnerPrize()
    - [x] 3등: 5개 번호 일치 / 1,500,000원 - MakeWinner#initWinnerPrize()
    - [x] 4등: 4개 번호 일치 / 50,000원 - MakeWinner#initWinnerPrize()
    - [x] 5등: 3개 번호 일치 / 5,000원 - MakeWinner#initWinnerPrize()

- [] 당첨 통계 메세지를 출력한다. - View#WINNING_MESSAGE_GUIDE_MESSAGE
  - [] 각 등수가 몇 개인지 출력한다. - View#showWinnings()

- [] 총 수익률을 출력한다. - View#showYield()

## 🤓로또 게임이란?

로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
