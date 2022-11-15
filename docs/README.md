# 시나리오에 따른 기능 목록 정리

### 금액 입력 받음
- camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 예외처리로 IllegalArgumentException 발생 후 [ERROR]로 시작하는 메세지 출력

### 사용자 입력 금액 계산 및 validate
- 번호문자만 허용
- 입력값 1000원 단위 체크
- [예외발생 시]
- IllegalArgumentException에서 메세지 "[ERROR]" 출력 후 0 리턴하여 Main함수 종료 
- throw IllegalException로 구현 시 예외 발생 테스트에서 Failed로 인한 우회적 프로그램 종료 

###  입력 받은 금액 크기에 맞게 Lotto 객체 생성
- input을 1000으로 나눈 몫의 값 만큼 반복하여 Lotto 객체 생성
- 중복없는 1~45 사이의 랜덤번호 6자리 생성 후 오름차순 정렬 후 Lotto 생성자에 넣음
- Lotto에서는 validate을 하여 중복된 수 유무와 크기를 체크
- 이들을 저장하는 Lotto List에 전부 추가한 후 구매 메세지 출력

###  당첨번호 입력 받음
- 처음 금액 입력에 사용한 함수로 입력 받음

### 사용자 입력 당첨번호 validate
- 6자리 번호인지 체크
- `,`를 delimiter로 구분하여 총 6자리
- `,`(쉼표) 외 다른 delimiter 체크
- 중복된 번호 체크
- 모든 번호가 1~45 사이 체크
- 번호 외 다른 문자 유무 체크
- [예외발생 시]
- throw IllegalException에 [ERROR] 메세지 출력

### 보너스 번호 입력 받음
- 처음 금액 입력에 사용한 함수로 입력 받음

### 보너스 번호 validate
- 한 자리 번호 형태 외 다른 문자형태 체크
- 1~45 사이 체크
- 당첨번호와 중복되는지 체크
- [예외발생 시]
- throw IllegalException에 [ERROR] 메세지 출력

### 생성된 lotto 번호들에서 겹치는 번호가 몇개 있는지 확인 및 당첨금 계산
- 오름차순으로 정렬된 Lotto 번호들이기에 사용자 입력 당첨번호가 비교 대상보다 작을 경우 break
- 당첨번호 일치 수와 보너스 번호 일치 수를 통해 각 Lotto 객체마다 사용자 입력 당첨번호와 같은 경우의 수를 Java enum을 사용해 HashMap에 저장하여 관리
- 해당되는 enum에 따라 당첨금 계산하여 totalIncome에 저장 

### 겹친 번호 수 만큼 당첨금 출력
- 일치한 횟수에 따라 해당하는 enum을 key로 Hashmap에서 횟수 value를 가져와 출력

### 당첨금과 구입 금액으로 수익률 계산 
- 사용자 입력 금액과 당첨금을 통해 수익률 계산(소수점 둘째 자리에서 반올림)



