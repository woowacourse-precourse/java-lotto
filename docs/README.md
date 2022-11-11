# 기능 목록

## 로또 번호 추첨

### 랜덤 숫자를 추출하는 클래스 Name : NumberGenerator

- [x] 중복되지 않는 6개의 숫자 뽑기 - #getUniqueRandomNumbers()

### String 형태의 입력을 int 형태로 변환해주는 클래스 Name : InputConverter
- [x] 금액의 입력값을 바꿔주는 기능 - #convertMoneyInput()
- [x] 6개의 당첨 번호 입력값을 바꿔주는 기능 - #convertWinningNumber()
- [x] 보너스 당첨 번호 입력값을 바꿔주는 기능 - #convertBonusNumber()

### 발행된 로또의 번호 List 를 wrapping 하는 클래스 Name : Lotto

- [ ] ~~뽑은 6개의 숫자를 Lotto 클래스 내부의 로또의 번호 List 에 할당~~ - 생성자를 통해 할당
- [x] 발행된 번호를 반환 - #getUserLottoNumbers()
- [x] 입력한 당첨 번호가 유효하지 않은 경우 - #isValidLottoNumbersInput()
  - [x] 숫자이 개수가 6개가 아닌 경우 - #isValidNumberOfNumbers()
  - [x] 중복된 숫자가 포함된 경우 - #isUniqueNumbers()
  - [x] 범위 내의 숫자가 아닌 값이 포함된 경우 - #isInRangeNumbers()

---

## 당첨 여부 확인

### 로또 당첨 결과를 알려주는 클래스 Name : Result

- [ ] (일치 개수, 보너스 번호 일치 여부 ,등수) enum 클래스 Name : Rank
  > 보너스 번호를 확인하지 않거나(일치하는 숫자가 5개가 아니거나) 일치하지 않는 번호인 경우 false
- [ ] (등수, 금액) enum 클래스 Name : Prize
- [ ] 사용자의 번호와 당첨 번호를 비교하여 일치하는 번호 개수를 반환 - #countMatchingNumber()
- [ ] 일치하는 개수에 따른 등수를 반환 - #getRank()
- [ ] 5개의 번호가 일치할 경우 보너스 번호 일치 여부를 확인 - #isMatchingBonusNumber()

---

## 사용자의 입력

### 사용자의 입력을 담당하는 클래스 Name : UserInput

- [ ] 사용자의 구입 금액 입력받기 - #buyLotto()
- [ ] 입력한 구입 금액이 유효하지 않은 경우 예외처리 - #isValidMoneyInput()
  - [ ] 입력한 구입 금액에 숫자가 아닌 값이 포함된 경우 -#isNumeralMoneyInput()
  - [ ] 입력한 구입 금액이 1000원 단위가 아닌경우 -#isValidMoneyUnit()
- [ ] 당첨 번호 입력 - #enterWinnigLottoNumber()
  - [ ] 숫자가 아닌 값이 포함된 경우 예외처리
- [ ] 보너스 번호 입력 - #enterBonusNumber()
- [ ] 입력한 보너스 번호가 유효하지 않은 경우 예외처리 - #isValidBonusNumberInput()
  - [ ] 숫자가 아닌 값인 경우- #isNumeralNumber()
  - [ ] 범위 내의 숫자가 아닌 값이 포함된 경우 - #isInRangeNumber()
  - [ ] 당첨 번호 6개에 포함되는 경우 - #isExistNumber()


---

## 출력

### 출력을 담당하는 클래스 Name : SystemMessage

- [ ] 소수점 둘째 자리에서 반올림한 수익률 출력 - #showEarningRate()
- [ ] 발행한 로또 수량 출력 - #showAmount()
- [ ] 발행한 로또의 번호를 오름차순으로 정렬하여 출력 - #showNumbers()

---
## 예외 처리
> 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고,
> [ERROR] 로 시작하는 에러 메시지를 출력 후 종료한다.
