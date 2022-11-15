# Java-Lotto

## 기능 목록

- 구입하려는 금액을 입력하라는 메세지를 출력하는 메서드
    - requestWantBuyAmountInputMessage()
- 구입하려는 금액을 입력받는다.
    - wantBuyAmountInput()
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. <br>
  유저가 잘못된 값을 입력하였을시 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력
    - validWantByAmountInput()

- 로또 1장의 가격으로 나눈 몫의 값(구매 가능한 복권 수량)을 반환한다.
    - canBuyAmount()

- 구매 가능한 복권 수량만큼의 1~45 까지의 중복되지 않은 6개의 숫자를 뽑는다.
    - makeUserRandomLottoNumbers()
- 당첨번호를 입력하라는 지시 메세지 출력.
  - requestWinningNumbersMessage()
- 당첨번호와 보너스 번호를 입력받는다.
    - 당첨번호를 입력 받는다.
      - winningNumbersInput() 
    - 보너스 번호를 입력 받는다.
      - bonusNumberInput()
- 당첨번호를 검증한다.
  - validWinningNumbersInput()
    - validWinningNumbersSize()
    - validDuplicateWinningNumbers()
    - validWinningNumbersRange()
- 보너스 번호를 검증한다.
  - validBonusNumberInputContainWinningNumbers()
  - validBonusNumberRange()
  
- 당첨번호와 사용자가 구매한 로또 번호를 비교한다.
    - compareUserLottoNumbersAndWinningNumbers()
- 당첨내역과 수익률을 출력한다.
    - userScoreBoard()

## 기능 요구 사항

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원

로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.<br>
로또 1장의 가격은 1,000원이다.<br>
당첨 번호와 보너스 번호를 입력받는다.<br>
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.<br>
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

## 입출력 요구 사항

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
- 보너스 번호를 입력 받는다.
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- 당첨 내역을 출력한다.
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

## Lotto Class
- 제공된 Lotto 클래스를 활용해 구현해야 한다.
- Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
- numbers의 접근 제어자인 private을 변경할 수 없다.
- Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
- Lotto의 패키지 변경은 가능하다.
