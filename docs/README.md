# [미션 - 로또]

---

## 기능 목록

### 사용자 입력
- [x] inputUserMoney()
  - 사용자에게 구매 금액을 입력받는다.

- [x] inputWinningLottoNumbers()
  - 사용자에게 로또 당첨 번호를 입력받는다.

- [x] inputWinningBonusNumber()
  - 사용자에게 보너스 번호를 입력받는다.

### 사용자 구매 금액 입력 검증
- [x] validateLottoPurchaseMoney()
  - validatePurchaseMoneyInteger()
    - 유저가 입력한 로또 구매 금액이 정수형아니고, Integer의 범위를 벗어나면 IllegalArgumentException을 발생시킨다. 
  - validatePurchaseMoneyDividable()
    - 유저가 구매한 로또 금액이 1000 으로 나누어 떨어지지 않으면 IllegalArgumentException을 발생시킨다.

### 당첨 번호 입력 검증
- [x] validateInputLottoNumber()
  - [x] validateLottoNumbersLength()
    - 보너스 번호를 포함하지 않은 로또 당첨번호 입력값이 6보다 크다면 IllegalArgumentException을 발생시킨다.
  - [x] validateLottoNumbersOverlap()
    - 로또 당첨번호 입력값이 중복된 수 일때 IllegalArgumentException을 발생시킨다.
  - [x] validateIntegerValue()
    - 입력값이 정수형 범위가 아니면 IllegalArgumentException을 발생시킨다.
  - [x] validateLottoNumberRange()
    - 로또 당첨번호 입력값이 1 ~ 45 사이의 숫자가 아니라면 IllegalArgumentException을 발생시킨다.

### 보너스 당첨 번호 입력 검증
- [x] validateInputBonusLottoNumber()
  - [x] validateIntegerValue()
    - 보너스 번호가 단 하나의 정수 값이 아니면 IllegalArgumentException을 발생시킨다.
  - [x] validateBonusNumberRange()
    - 보너스 번호가 1 ~ 45 범위를 벗어나면 IllegalArgumentException을 발생시킨다.
  - [x] validateBonusNumberOverlap()
    - 보너스 번호가 이미 입력된 당첨된 번호들과 중복된다면 IllegalArgumentException을 발생시킨다.

### 로또 번호 생성
- [x] generateLottoNumber()
  - List<List<Integer>> 타입의 로또번호를 생성한다. 이때, 구매한 로또 갯수에 따라 각 로또 번호를 담는 리스트를 반환 하도록한다.

### 로또 번호 출력
- [x] getGeneratedLottoNumber()
  - 랜덤 값으로 발행된 로또 번호를 출력한다. 단, 사용자가 입력한 로또 구매 갯수만큼 출력한다.

### 로또 번호 매칭
- [x] matchWinningLotto()
  - 발급 받은 로또 번호와 당첨 번호를 비교하여 당첨 갯수를 반환한다.

- [x] countContainBonusNumber()
  - matchWinningLotto() 메서드에서 반환된 값을 토대로 당첨된 로또들 중 보너스 번호를 포함하여 5개를 맞춘 갯수를 반환한다.

### 당첨 통계
- [x] extractStatistic()
  - 당첨 통계를 추출한다.
    - [x] considerBonusNumber()
      - 당첨 통계를 추출하는 과정에서, 보너스 번호가 포함된 5개 일치 로또를 찾아낸다.

### 당첨 통계 출력
- [x] showStatistic()
  - 당첨 통계를 콘솔에 보여준다.

### 수익률 계산
- [x] countMatchResult()
  - 당첨 통계를 바탕으로 사용자의 수익률을 계산한다.

### 수익률 출력
- [x] getYield()
  - countMatchResult() 에서 계산된 수익률을 출력한다. 단, 소수점은 첫째 자리까지 출력한다.

---

## 기능 요구 사항

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

---

## 입출력 요구사항 체크리스트

### 입력

- [x] 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000
```

- [x] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6
```

- [x] 보너스 번호를 입력 받는다.

```
7
```

#### 출력

- [x] 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- [x] 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- [x] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```
총 수익률은 62.5%입니다.
```

- [x] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```