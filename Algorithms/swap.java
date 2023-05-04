/*1. 달리기 경주

1-1. 문제설명
     : 얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 
       예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때, 
       해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 
       즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
       선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 
       경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
       
    
1-2. 제한사항
     :5 ≤ players의 길이 ≤ 50,000
      players[i]는 i번째 선수의 이름을 의미합니다.
      players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
      players에는 중복된 값이 들어가 있지 않습니다.
      3 ≤ players[i]의 길이 ≤ 10
      2 ≤ callings의 길이 ≤ 1,000,000
      callings는 players의 원소들로만 이루어져 있습니다.
      경주 진행중 1등인 선수의 이름은 불리지 않습니다.
      
1-3. 입출력 예
     :players	                              callings	                      result
      ["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]	["mumu", "kai", "mine", "soe", "poe"]
      
      
      
 */    
2. Solution 

2-1. 이중 for문 활용
     :class Solution {
      public String[] solution(String[] players, String[] callings) {
        for (int i = 0; i < callings.length; i++) {
            String target = callings[i]; //탐색 타겟 설정
            
              for (int j = 0; j < players.length; j++) { 
                  String player = players[j];

                  if (target.equals(player)){
                      String temp = players[j-1];
                      players[j-1] = player;
                      players[j] = temp;
                      break;
                  }
              }
            
         }
            
          return players;
      }
  }
 
2-2. Map을 활용한 풀이


import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i < players.length; i++){
            map.put(players[i], i); //key랑 value 만들기 -> map 형태로
        }
        for (int j=0; j < callings.length; j++){
            String s= callings[j];
            int temp = map.get(s); // 매칭 
            map.put(s, temp - 1); //put 집어넣기 key value 
            map.put(players[temp -1], temp); //put 집어넣기 key value
            players[temp] = players[temp - 1]; // SWAP 값 바꾸기 
            players[temp - 1] = s; // 이전값을 집어넣기 
        }
        return players;
    }
}

