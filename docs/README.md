# [미션- 로또] 기능 목록

### 사용자 입력
- [ ] inputUserMoney 
  - Integer Type 으로 사용자에게 **금액을 입력받기**

- [ ] inputWinNumber 
  - Integer Type 으로 사용자에게 **당첨 번호를 입력받기**

- [ ] inputBonusNumber
  - Integer Type 으로 사용자에게 **보너스 번호를 입력받기**

### 사용자 입력 검증
- [ ] validateLottoPurchaseMoney
  - 유저가 구매한 로또 금액이 Integer Type 의 범위를 벗어나면 IllegalArgumentException를 발생시키기

- [ ] validateInputLottoNumber 
  - 로또 당첨번호 입력값이 1 ~ 45 사이의 숫자가 아니라면 IllegalArgumentException를 발생시키기

### 로또 번호 생성
- [ ] generateLottoNumber
  - List<Integer> 타입의 로또번호를 생성한다.

### 수익률 계산
- [ ] calculateYield
  - 수익률을 계산하기

### 출력

- [ ] getPurchaseNumberOfLotto
  - 구매한 로또 갯수 출력

- [ ] getPublishedLottoNumber
  - 발행된 로또 번호를 출력하기

- [ ] getWinCountThree
  - 3개 일치한 로또 갯수 출력하기

- [ ] getWinCountFour
  - 3개 일치한 로또 갯수 출력하기

- [ ] getWinCountFive
  - 3개 일치한 로또 갯수 출력하기

- [ ] getWinCountSix
  - 3개 일치한 로또 갯수 출력하기

- [ ] getCalculatedYield
  - 수익률 출력하기