# [미션- 로또] 기능 목록

---

### 사용자 입력
- [x] inputUserMoney 
  - 사용자에게 구매 금액을 입력받는다.

- [x] inputWinningLottoNumbers 
  - 사용자에게 로또 당첨 번호를 입력받는다.

- [x] inputWinningBonusNumber
  - 사용자에게 보너스 번호를 입력받는다.

### 사용자 구매 금액 입력 검증
- [x] validateLottoPurchaseMoney
  - validatePurchaseMoneyInteger(유저가 입력한 로또 구매 금액이 정수형아니고, Integer의 범위를 벗어나면 IllegalArgumentException를 발생시키기) 
  - validatePurchaseMoneyDividable(유저가 구매한 로또 금액이 1000 으로 나누어 떨어지지 않으면 IllegalArgumentException를 발생시키기)

### 당첨 번호 입력 검증
- [x] validateInputLottoNumber
  - [x] validateLottoNumbersLength
    - 보너스 번호를 포함하지 않은 로또 당첨번호 입력값이 6보다 크다면 IllegalArgumentException를 발생시킨다.
  - [x] validateLottoNumbersOverlap
    - 로또 당첨번호 입력값이 중복된 수 일때 IllegalArgumentException를 발생시킨다.
  - [x] validateIntegerValue
    - 입력값이 정수형 범위가 아니면 IllegalArgumentException를 발생시킨다.
  - [x] validateLottoNumberRange
    - 로또 당첨번호 입력값이 1 ~ 45 사이의 숫자가 아니라면 IllegalArgumentException를 발생시킨다.

### 보너스 당첨 번호 입력 검증
- [x] validateInputBonusLottoNumber
  - [x] validateIntegerValue
    - 보너스 번호가 단 하나의 정수 값이 아니면 IllegalArgumentException를 발생시킨다.
  - [x] validateBonusNumberRange
    - 보너스 번호가 1 ~ 45 범위를 벗어나면 IllegalArgumentException를 발생시킨다.
  - [x] validateBonusNumberOverlap
    - 보너스 번호가 이미 입력된 당첨된 번호들과 중복된다면 IllegalArgumentException를 발생시킨다.

### 로또 번호 생성
- [x] generateLottoNumber
  - List<List<Integer>> 타입의 로또번호를 생성한다. (구매한 로또 갯수에 따라 각 로또 번호를 담는 리스트를 반환 하도록한다.)

### 로또 번호 출력
- [x] getGeneratedLottoNumber
  - 랜덤 값으로 발행된 로또 번호를 출력한다. 단, 사용자가 입력한 로또 구매 갯수만큼 출력한다.

### 로또 번호 매칭
- [x] matchWinningLotto
  - 발급 받은 로또 번호와 당첨 번호를 비교하여 당첨 갯수를 반환한다.

- [x] getYield
  - 수익률 출력하기

- [x] countContainBonusNumber
  - matchWinningLotto() 메서드에서 반환된 값을 토대로 당첨된 로또들 중 보너스 번호를 포함하여 5개를 맞춘 갯수를 반환한다.

### 당첨 통계
- [x] extractStatistic
  - 당첨 통계를 추출한다.
    - [x] considerBonusNumber
      - 당첨 통계를 추출하는 과정에서, 보너스 번호가 포함된 5개 일치 로또를 찾아낸다.

### 당첨 통계 출력
- [x] showStatistic
  - 당첨 통계를 콘솔에 보여준다.

### 수익률 계산
- [x] countMatchResult
  - 당첨 통계를 바탕으로 사용자의 수익률을 계산한다.

### 수익률 출력
- [x] getYield
  - countMatchResult 에서 계산된 수익률을 출력한다. 단, 소수점은 첫째 자리까지 출력한다.