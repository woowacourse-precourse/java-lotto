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

사용자가 원하는 로또 **구매 금액을 입력** 받는다. 그리고 구매 금액을 입력하면, 그 값을 검증한다.

구매 금액 **검증 조건**은 **1000으로 나누어 떨어지는 정수**이며, **Integer 타입 및 범위**로 정의했다.

유효한 입력값일 때, **입력값을 1000으로 나누어** 최종적으로 **구매할 로또의 갯수를 파악**한다.

파악한 구매 예정 로또 갯수에 따라서 **랜덤한 로또 번호를 발급**한다.

추가로 사용자는 **당첨 로또 번호**를 직접 **입력**해야 한다.

이때 당첨 로또 번호는 1 ~ 45 사이의 **정수** 이여야 하며, 1,2,3,4,5,6 와 같이 , 단위로 분리하여 입력해야한다.

만약 위 형식을 지키지 않았을 시 **유효하지 않은 입력**으로 간주한다.

마지막으로 **보너스 로또 당첨 번호를 입력**한 후 당첨 로또 번호와 동일한 유효성 검사를 수행한다.

이때 **보너스 로또 번호**는 **단 한자리의 1 ~ 45 사이의 정수**가 요구되며, 앞서 입력한 로또 당첨 번호와 **겹치지 않아야** 한다.

사용자가 발급받은 **랜덤 로또 번호와 보너스 로또 번호를 포함한 당첨 로또 번호를 비교**한다.

만약 3,4,5,6 개의 숫자와 일치하는 로또가 있을 경우 각각 일치하는 갯수에 대한 갯수를 파악한다.

파악한 **당첨 정보를 금액으로 환산**하여 **수익률을 계산하고 출력**한다.

    eg. 
    구입금액을 입력해 주세요.
    8000
    
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    
    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6
    
    보너스 번호를 입력해 주세요.
    7
    
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.