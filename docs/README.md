# 구현할 기능 목록

#### [구체화 및 구현 과정](./PROCESS.md)

- LottoShop
    - [ ] 금액을 받아 로또를 자동으로 생성


- Lotto
    - [ ] Lotto 입력 형식이 올바른지 체크
      - 입력 형식이 올바르지 않을 경우 `IllegalArgumentException`을 발생
    - [ ] 해당 숫자을 가지고 있는지 확인


- LottoRewardCoordinator
    - [ ] WinningNumber를 생성
    - [ ] 해당 로또가 당첨되었는지를 판단


- WinningNumber
    - [ ] 당첨 숫자가 제대로 입력되었는지 판단함
    - [ ] 로또 숫자가 몇개 당첨되었는지 판단함


- LottoApplicationSetting
  - LottoSetting
    - [ ] 변경 가능한 정보들을 enum 값으로 담고 있음
    - [ ] 해당 정보에 따라 객체(LottoShop)를 생성
  - WinningNumberSetting
    - [ ] 당첨 번호에 대한 정보를 저장하고 있음 (enum)
    - [ ] 해당 정보에 따라 객체(LottoRewardCoordinator)를 생성
  - LottoRewardSetting
    - [ ] 각 상금 조건과 상금 정보를 가지고 있음 (enum)