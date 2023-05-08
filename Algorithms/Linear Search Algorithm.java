
1.문제
: 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.
["방향 거리", "방향 거리" … ]
예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.

2.입출력 예
: park	routes	result
["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0



3. Solution

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2]; // x,y 두개저장
        for (int i =0; i<park.length; i++){
            for (int j = 0; j <park[i].length(); j++){
                char target = park[i].charAt(j);
                if (target=='S'){
                    answer[0]=i;
                    answer[1]=j;
                    System.out.println(answer[0]+answer[1]);
                    break;
                }
            }      
        }
        for(int k=0; k < routes.length; k++){
            String temp = routes[k].split(" ")[0];
            Integer move = Integer.parseInt(routes[k].split(" ")[1]);
            System.out.println(temp);
            System.out.println(move);
            System.out.println(" ");
            Boolean isMove = true;   // for를 전체 반복해서 빠져나가는건지,도중에 X를 만나서 빠져나가는지
            if ("E".equals(temp)){
                if (move - answer[1] < 0 && park.length - move < 0){
                    continue;
                }                
                for(int i=1; i<move; i++){
                    if(park[answer[0]].charAt(answer[1]+i)=='X'){
                        isMove = false;
                        break;
                    }
                }
                if(isMove){
                    answer[1] = answer[1]+ move ;
                }
            }
            else if ("W".equals(temp)){
                if (answer[1] - move < 0 && move -park.length <0){
                    continue;
                }
                for(int i=1; i<move; i++){
                    if(park[answer[0]].charAt(answer[1]-i)=='X'){
                        continue;
                    }
                }
                if(isMove){
                    answer[1] = answer[1] -move;
                }             
            }
            else if ("S".equals(temp)){
                if (move -answer[0] < 0 && park[answer[0]].length -move <0){
                    continue;
                }
                for(int i=1; i<move; i++){
                    if(park[answer[0]+i].charAt(answer[1])=='X'){
                        continue;
                    }
                }
                if(isMove){
                    answer[0] = answer[0] +move;
                }               
            }
            else if ("N".equals(temp)){
                if (answer[0] - move < 0 && move - park[answer[0]].length <0){
                    continue;
                }
                for(int i=1; i<move; i++){
                    if(park[answer[0]-i].charAt(answer[1])=='X'){
                        continue;
                    }
                }
                if(isMove){
                    answer[0] = answer[0] -move;
                }   
            }
        }
        return answer;
    }
}
