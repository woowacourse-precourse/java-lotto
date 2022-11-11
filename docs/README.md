**필요 기능 목록**
- User 측
  - [x] User 의 구입금액 입력 받는 기능 (feat 1)
  - [x] User 의 당첨 번호 입력 받는 기능 (feat 2)
  - [x] User 의 보너스 번호 입력 받는 기능 (feat 3)
- Game 측
  - [x] User 의 구입금액에 따라 로또 수량 계산하는 기능 (feat 4)
  - [x] 6 자리 번호 재생하는 기능 (feat 5)
  - [x] 당첨 종류를 계산하는 기능 (feat 6)
  - [x] 당첨 통계를 집계하는 기능 (feat 7)
  - [ ] 당첨 통계를 사용하여 수익률을 계산하는 기능 (feat 8)

**예외 사항 목록**
- 금액 입력 확인  
  - [ ] 숫자인지 체크  
    &rarr; IllegalArgumentException, [ERROR] 입력이 숫자인지 확인하세요  
  - [ ] 1000 으로 나눠 떨어지는지 체크  
    &rarr; IllegalArgumentException, [ERROR] 입력이 1000원으로 나누어 떨어지는지 확인하세요
- 당첨 번호 입력 확인  
  - [ ] ',' 로 구분되어있는지 체크  
    &rarr; IllegalArgumentException, [ERROR] 숫자 구분을 ',' 로 했는지 확인하세요
  - [ ] 길이가 6인지 체크  
    &rarr; IllegalArgumentException, [ERROR] 숫자를 6개 입력했는지 확인하세요
  - [ ] 1 ~ 45 사이의 숫자인지 체크  
    &rarr; IllegalArgumentException, [ERROR] 숫자 범위를 확인하세요
  - [ ] 중복 숫자가 있는지 체크  
    &rarr; IllegalArgumentException, [ERROR] 중복 숫자가 있는지 확인하세요
- 보너스 번호 입력 확인
  - [ ] 길이가 1인지 체크  
    &rarr; IllegalArgumentException, [ERROR] 보너스 번호를 1개 입력했는지 확인하세요
  - [ ] 1 ~ 45 사이의 숫자인지 체크  
    &rarr; IllegalArgumentException, [ERROR] 보너스 번호의 범위 (1~45)를 확인하세요
  - [ ] 기존 입력 번호 (6개) 중 중복되는 숫자인지 체크  
    &rarr; IllegalArgumentException, [ERROR] 보너스 번호가 당첨 번호 6개 중 같은 숫자인지 확인하세요


**프로그래밍 요구 사항**
- [ ] else 예약어 사용 금지
- [ ] enum 사용  
  &rarr; 번호 일치 숫자에 따라 print 함수에 사용
- [ ] 단위 테스트 구현