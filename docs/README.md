Lotto Class

    valduplicate
        이중 for문 탐색하며 중복 값이 있는지 검사. 있으면 return false
        없으면 true return
    valrange
        for문 순회하며 로또 번호 값이 범위를 넘어가는지 검사. 있으면 return false
        없으면 return true
    validate
        size 탐색, valduplicate 실행, valrange 실행
        실패 시 exception throw
    findidx
        numbers 순회하며 숫자 n이 있는지 찾아봄
    getRtn
        발표된 로또 번호를 바탕으로 당첨금액이 얼마인지 return
    printInfo
        저장되어 있는 로또 번호를 출력

Application Class
    int bonusnum : 입력받는 보너스 숫자
    List<Integer> truenum : 입력받는 로또 숫자 다섯개
    List<Lotto> lottos : 입력받은 금액으로 만든 로또 리스트
    List<Integer> res : 최종 결과를 저장
    
    printAllLottos : 저장되어 있는 모든 로또 정부 출력
    generateLotto : 가격 입력받아서 로또들 생성
    allocateInital : 입력받아서 bonusnum,truenum 만듬
    calcFinal : 로또 보고 몇등인지 계산하고 저장
    printFinal : 마지막 결과 출력 
    

    