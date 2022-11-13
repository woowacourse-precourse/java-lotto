## 🔖 기능 목록

### UI
- [ ] 로또 구매 금액을 입력 받는다.
  - [ ] 정수로 변환할 수 없는 경우 예외처리
- [ ] 당첨 번호를 입력 받는다.
  - [ ] 쉼표(,)를 기준으로 6개의 수를 입력했는지 검증
  - [ ] 각 수가 1~45 범위 내의 수인지 검증
  - [ ] 각 수가 중복되지 않는지 검증
- [ ] 보너스 번호를 입력 받는다.
    - [ ] 1~45 범위 내의 수를 입력했는지 검증


- [ ] 구매한 로또 수를 출력한다. 
- [ ] 구매한 로또 리스트를 (한 개 이상) 출력한다.
- [ ] 당첨 통계를 출력한다.
    -[ ] 당첨 내역 (로또 리스트가 각각 몇 등 했는지 정보 포함)
    -[ ] 총 수익률

### Domain


#### Buyer
- [ ] 구매할 수 있는 로또 수만큼 로또를 구매 - Buyer#Buyer(int count)
  - [X] 구매 가능한 수만큼 로또 생성 - Randoms#pickUniqueNumbersInRange()
- [ ] 구매 금액을 통해 몇 장의 로또를 구매할 수 있는지 계산 - Buyer#calculateNumberOfLottos(String won)
  - [ ] 1,000 미만의 값인 경우 예외처리 - Buyer#validateIsUnderMinCost(String won) 
  - [ ] 1,000 단위로 나누어 떨어지지 않는 경우, 1,000 단위 아래는 버림 처리 (ex. 1,200 -> 1,000) - Buyer#roundDown1000Units(String won)
- [ ] 구매한 로또 리스트를 반환 - Buyer#getLottos() 


#### Lotto
- [ ] 로또 생성 Lotto#Lotto(List<Integer> numbers)
  - [X] 로또 번호 리스트의 사이즈가 6인지 검증 Lotto#validateLottoSize(List<Integer> numbers)
  - [ ] 로또의 각 번호가 1~45 숫자 범위 내에 있는지 검증 Lotto#validateEachNumberInRange(List<Integer> numbers)
  - [ ] 로또의 각 번호가 중복되는지 검증 Lotto#validateHasDuplicate(List<Integer> numbers)
  - [ ] 로또 번호 리스트를 오름차순으로 정렬 Lotto#ascendingSort(List<Integer> numbers)
- [ ] 로또 1장 가격 상수 처리 (1000) 
- [X] 로또 번호 리스트 사이즈 상수 처리 (6)
- [ ] 로또 각 번호 숫자 범위 상수 처리 (1~45)
- [ ] 로또 번호 리스트에 보너스 번호가 포함되어 있는지 확인 Lotto#containsBonusNumber(int bonusNumber)
- [ ] 로또 번호 리스트 반환 Lotto#getNumbers()


#### BonusNumber
- [ ] 보너스 번호 생성 - BonusNumber#BonusNumber(int number)
  - [ ] 보너스 번호가 1~45 범위 내의 수인지 검증 - BonusNumber#validateNumberInRange(int number)
- [ ] 보너스 번호 값 반환 - BonusNumber#getNumber()


#### WinningLotto
- [ ] 로또 당첨 정보(로또 번호 + 보너스 번호) 생성 WinningLotto#WinningLotto(Lotto winningLotto, BonusNumber bonusNumber)
  - [ ] 보너스 번호가 로또 당첨 번호에 포함되어 있는지 검증 - WinningLotto#validateWinningLottoContainsBonusNumber(Lotto winningLotto, BonusNumber bonusNumber)
- [ ] 로또 당첨 번호 리스트 반환 - WinningLotto#getWinningLottoNumbers() 
- [ ] 보너스 번호 반환 - WinningLotto#getBonusNumber() 


#### Judgement
- [ ] 구매한 각 로또가 몇 등에 해당하는지 계산 - Judgement#compare(Lotto lotto, Lotto winningLotto) 
  - [ ] 구매한 로또 번호 리스트와 로또 당첨 번호 리스트 비교 후 몇 개의 번호가 일치하는지 확인 - Judgement#LottoRetainAll(Lotto winningLotto)


#### Statistics
- [ ] 구매한 모든 로또에 대해 몇 등을 기록했는지 저장 - Statistics#record()
- [ ] 발행된 Lotto 수와 총 당첨금 정보를 활용해 수익률 계산 - Statistics#calculateEarningsRate()
  - [ ] 소수점 둘째 자리에서 반올림 처리 (ex. 100.0%, 51.5%, 1,000,000,0%) - Statistics#roundToTwoDecimalPlaces()