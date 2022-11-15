# 미션 - 로또

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

## 🚀 기능 목록
- [X] 구입 금액을 입력받을 수 있다. 정수가 아니면 예외처리한다. - InputView#getInt()
  - [X] 1,000으로 나누어 떨어지지 않는 경우 예외 처리한다. - Purchase#validate()
- [X] 구입 금액에 해당하는 만큼 로또 번호를 생성한다. - Publish#createLottos()
  - [X] 발행할 로또 수를 알 수 있다. - Purchase#getCount()
  - [X] 1부터 45까지의 서로 다른 임의의 수 6개를 생성한다. - NumberGenerator#createDifferentRandomNumbers()
  - [X] 로또 번호는 오름차순 정렬된다. - NumberGenerator#sortNumbers()
- [X] 발행한 로또 수량을 출력할 수 있다. - Publish#printCount()
- [X] 발행한 로또 번호를 출력한다. - Publish#printLottos()
- [X] 당첨 번호를 입력받는다. 번호는 쉼표(,)를 기준으로 구분한다.
  - [X] 쉼표(,)를 기준으로 구분했을 때 각 데이터가 '1~45범위의 숫자'가 아니면 예외 처리한다.
  - [X] 쉼표(,)를 기준으로 구분했을 때 중복된 데이터가 있으면 예외 처리한다.
- [X] 보너스 번호를 입력 받는다. 정수가 아니면 예외처리한다. - InputView#getInt()
  - [X] 숫자 범위가 1~45가 아니면 예외 처리한다.
- [X] 컴퓨터의 수를 생성한다. 
  - [X] 1부터 45까지의 서로 다른 임의의 수 6개를 생성한다. - NumberGenerator#createDifferentRandomNumbers()
  - [X] 1부터 45까지의 임의의 수 1개를 생성한다. - NumberGenerator#createRandomNumber()
- [X] 로또 등수를 알 수 있다. - Prize#findPrize()
  - [X] 컴퓨터의 수(6자리)와 플레이어의 수(6자리)를 비교할 수 있다. - Player#compare()
    - [X] 몇 개의 숫자가 일치하는지 알 수 있다. - Lotto#getMatchingNumber()
    - [X] 특정 자리에 특정 숫자가 있는지 알 수 있다. - Lotto#hasPlace()
  - [X] 컴퓨터의 수(1자리)와 플레이어의 수(1자리)를 비교할 수 있다. - Player#isEqualBonusNumber()
- [X] 당첨 내역을 출력할 수 있다. - PrizeCount#toString()
  - [X] 당첨 기준과 금액을 알 수 있다. - Prize#toString()
    - [X] 숫자 3자리마다 콤마를 찍을 수 있다. - NumberFormator#divideEvery3Digits()
  - [X] [1~5]등의 각 개수를 알 수 있다. - PrizeCount#items
  - [X] [1~5]등의 각 합산 금액이 얼마인지 알 수 있다. - PrizeCount#getTotalMoney()
  - [X] 총 수익률을 출력할 수 있다. - Profit#toString()
    - [X] 총 당첨 금액을 알 수 있다. - Profit#calculateAmount()
    - [X] 구입금액 대비 총 당첨 금액 비율(%)을 구할 수 있다. - Profit#calculateRate()
    - [X] 숫자를 소수점 둘째 자리에서 반올림할 수 있다. - NumberFormator#roundToTwoDecimalPlaces()
- [X] 예외가 발생하면 메시지를 출력한다.
  - [X] 예외마다 메시지가 다르다.