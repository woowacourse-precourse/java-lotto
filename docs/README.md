# ✔️ 구현할 기능 목록

## 설정(`Config`)

게임에 필요한 설정들을 가지고 있으며 유효성 판단을 통해 진행 가능한 게임인지 판별

### 변수
- [x] 로또 번호의 숫자 범위 - LOTTO_RANGE_START_NUMBER, LOTTO_RANGE_END_NUMBER
- [x] 로또 길이 - LOTTO_LENGTH
- [x] 보너스 번호 길이 - BONUS_LOTTO_LENGTH
- [x] 당첨 등수별 금액 - WINNING_RANK_AMOUNT
- [x] 로또 1장 가격 - LOTTO_TICKET_PRICE

### 기능
- [x] 설정값이 적절하게 지정되어 있는지 확인 - validate
    - [x] 숫자 범위가 올바르게 되어있는지 확인 - checkRangeNumber
    - [x] 자연수로 지정된 설정 중에 올바르게 되어있는지 확인 - checkNaturalNumber
    - [x] 0이 포함된 자연수로 지정된 설정 중에 올바르게 되어있는지 확인 - checkZeroOrNaturalNumber
    - [x] 논리적 오류 확인 - checkIllegalLotto
      - [x] 로또 길이보다 보너스 번호 길이가 긴지 확인 - isLongerLottoThanBonus
      - [x] 로또 길이 + 보너스 번호 길이가 숫자 범위 길이보다 큰지 확인 - isLongerTotalThenNumber
      - [x] 상위 등수가 하위 등수 금액보다 같거나 적은지 확인 - isRankAmount

## 로거(`Logger`)

장애 파악 & 알림을 콘솔에 출력

### 기능

- [x] 로그 타입에 따른 콘솔 메시지 출력 - log

## 로또(`Lotto`)

뽑은 당첨 번호 내역

### 기능

- [x] 당첨 번호 유효성 판단
    - [x] 번호 내역이 존재하는지 확인 - checkExistedLotto
    - [x] 로또 길이가 올바른지 확인 - checkLottoLength
    - [x] 번호들이 지정된 범위에 있는지 확인 - checkRangeNumber
    - [x] 중복된 번호가 있는지 확인 - checkDuplicatedNumber

## 보너스(`Bonus`)

뽑은 보너스 번호 내역

- [x] 당첨 번호 유효성 판단
    - [x] 번호 내역이 존재하는지 확인 - checkExistedLotto
    - [x] 보너스 번호 길이가 올바른지 확인 - checkBonusLength
    - [x] 번호들이 지정된 범위에 있는지 확인 - checkRangeNumber
    - [x] 중복된 번호가 있는지 확인 - checkDuplicatedNumber

## 점수(`Score`)

맞은 당첨과 보너스 번호의 개수를 저장

### 기능

- [x] 서로 다른 점수끼리 비교 - compareTo

## 복권 추첨기(`LottoMachine`)

당첨과 보너스 번호를 추첨하고 로또를 발행

### 기능

- [x] 당첨과 보너스 번호 추첨 - draw
    - [x] 번호 추첨
      - [x] 번호 리스트 혹은 번호 입력 - inputNumber
      - [x] 문자열 번호를 숫자 형식으로 변환 - formatStringToNumber
          - [x] 숫자 문자열인지 확인 - checkNumericString
      - [x] 이미 추첨한 번호인지 확인 - checkAlreadyExistedNumber
- [x] 로또 발행 - publish

## 우아한은행(`uahanBank`)

당첨 금액 제공

### 기능

- [x] 등수별 점수 생성 - createRankScore
- [x] 등수별 당첨 금액 반환 - changeLottoToMoney
  - [x] 추점된 로또와 발행된 로또를 가지고 점수 반환 - calculateLottoToScore
    - [x] 정답 번호들과 예측 번호들을 비교하여 맞은 개수를 반환 - compareLottoNumber
## 제어(`Controller`)

게임의 실행과 전반적인 흐름을 담당

- [x] 게임 실행 - run
    - [x] 로또 구입 금액 입력 - inputPurchaseAmount
      - [x] 문자열 번호를 숫자 형식으로 변환 - formatStringToNumber
        - [x] 구입 금액이 숫자인지 확인 - checkNumericString
        - [x] 1,000원으로 나누어 떨어지는지 확인 - checkDivisibleThousand
        - [x] 구입 금액이 1,000원 이상인지 확인 - checkEqualOrBiggerThanThousand
    - [x] 당첨과 보너스 번호를 입력 처리
    - [x] 발행한 로또 수량 및 번호를 출력 - printPublishedLotto
    - [x] 당첨 내역과 총 금액 반환 - calculateWonLotto
      - [x] 당첨 금액을 당첨 등수로 변환 - changeMoneyToRank
      - [x] 당첨 내역 출력 - printWonLotto
        - [x] 숫자를 콤마 패턴으로 표현 - changeNumberToDecimal
    - [x] 수익률 출력 - printYield




# 🚀 기능 요구 사항

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