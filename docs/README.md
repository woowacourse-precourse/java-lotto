# 로또

## 📄 기능 목록
- [x] 로또 구입 금액을 입력 받는다. - InputOutput#getLottoBuyAmount()
- [x] 1부터 45까지의 서로 다른 수 6개를 생성한다. - NumberGenerator#createRandomNumbers()
- [x] 로또 번호는 오름차순으로 정렬한다. - NumberGenerator#sortAscendingOrder()
- [x] 로또 당첨 번호 6개를 입력 받는다. - InputOutput#getLottoNumbers()
- [x] 로또 보너스 번호 1개를 입력 받는다. - InputOutput#getLottoBonusNumber()
- [x] 당첨번호와 로또번호를 비교할 수 있다. - Referee#compare()
  - [x] 몇 개의 수가 같은지 알 수 있다. - Judgement#sameNumberCount()
  - [x] 보너스 숫자가 포함되어 있는지 알 수 있다. - Judgement#containBonusNumber()
    - [x] LottoResults
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- [x] 당첨 내역을 출력한다. - InputOutput#printWinHistory()
- [x] 수익률을 소수점 둘째 자리까지 계산한다. - Calculate#calculateRateOfProfit()
- [x] 수익률을 출력한다. - InputOutput#printRateOfProfit()
- [x] 예외상황 시 에러 문구를 출력한다. - ExceptionHandler
  - [x] 로또 구입 금액을 입력 받을 때 예외상황 - getLottoBuyAmountException()
    - [x] 입력값이 숫자가 아닐 경우 예외처리한다. - noNumberException()
    - [x] 로또 구입 금액은 1000원 단위가 아닐 경우 예외처리한다. - amountUnitException()
  - [x] 로또 번호 생성할 때 예외상황 - createLottoNumberException()
    - [x] 로또번호가 6개가 아닐 경우 예외처리한다. - lottoNumberException()
    - [x] 서로 다른 수가 아닐 경우 예외처리한다. - overlapException()
  - [x] 로또 당첨 번호를 입력 받을 때 예외상황 - getLottoWinnerNumberException()
    - [x] 콤마 사이의 글자가 숫자가 아닌 경우 예외처리한다. - splitResultNoNumberException()
    - [x] 로또번호가 6개가 아닐 경우 예외처리한다. - lottoNumberException()
    - [x] 1부터 45까지의 범위가 아닌 경우 예외처리한다. - numberRangeException()
    - [x] 서로 다른 수가 아닐 경우 예외처리한다. - overlapException()
  - [x] 로또 보너스 번호를 입력 받을 때 예외상황 - getLottoBonusNumberException()
    - [x] 입력값이 숫자가 아닐 경우 예외처리한다. - noNumberException()
    - [x] 1부터 45까지의 범위가 아닌 경우 예외처리한다. - numberRangeException()

## 📑 기능 요구 사항
로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

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

