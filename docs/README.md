# [미션- 로또] 기능 목록

### 사용자 입력
- [x] getPurchaseMoney 
  - 사용자에게 금액을 입력받기

- [x] publishWinningLottoNumbers 
  - 사용자에게 로또 당첨 번호를 입력받기

- [x] publishWinningBonusNumber
  - 사용자에게 보너스 번호를 입력받기

### 사용자 입력 검증
- [x] validateLottoPurchaseMoney
  - 유저가 구매한 로또 금액이 Integer Type 의 범위를 벗어나면 IllegalArgumentException를 발생시키기
  - 유저가 구매한 로또 금액이 1000 으로 나누어 떨어지지 않으면 IllegalArgumentException를 발생시키기

- [x] validateInputLottoNumber
  - [x] validateLottoNumberRange 
    - 로또 당첨번호 입력값이 1 ~ 45 사이의 숫자가 아니라면 IllegalArgumentException를 발생시키기
  - [x] validateLottoWinNumberOverlap
    - 로또 당첨번호 입력값이 중복된 수 일때 IllegalArgumentException를 발생시키기
  - [x] validateLottoWinNumberLength
    - 보너스 번호를 포함하지 않은 로또 당첨번호 입력값이 6보다 크다면 IllegalArgumentException를 발생시키기
  - [x] validateLottoWinNumberLengthContainBonusNumber
    - 보너스 번호를 포함한 로또 당첨번호 입력값이 7보다 크다면 IllegalArgumentException를 발생시키기

### 로또 번호 생성
- [x] generateLottoNumber
  - List<List<Integer>> 타입의 로또번호를 생성한다. (구매한 로또 갯수에 따라 각 로또 번호를 담는 리스트를 반환 하도록한다.)

### 로또 번호 매칭하기
- [x] match

### 수익률 계산
- [x] countMatchResult
  - 수익률을 계산하기

### 출력
- [x] buyLotto
  - [x] getPurchaseMoney
    - 구매할 로또 갯수 입력 
    - 구매한 로또 갯수 출력

- [x] getLottoPaper
  - [x] getPublishedLottoNumber
    - 발행된 로또 번호를 출력하기

- [x] getYield
  - 수익률 출력하기