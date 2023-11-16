package com.example.a64

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
                // 전체 학생수 n
                // 도난당한 학생들의 번호 lost
                // 여벌의 체육복을 가져온 학생들 reserve
                // 체육 수업을 들을수 있는 학생 수를 리턴
                var answer = 0
                var check = Array<Boolean>(n,{true})

                //출석가능한지 비교가능한 값 배열 선언
                for(index in 0..lost.size-1){
                    check[lost[index]-1] = false
                }


                var pre = 0
                var back =0
                // 빌려줄 수 있는지 판단후 계산
                for(index in 0..reserve.size-1){
                    //reserve 에가 lost하면 빌려줄수 없다..
                    if(!check[reserve[index]-1]) {
                        check[reserve[index]-1] = true
                        reserve[index] =-2
                        continue
                    }

                    pre = reserve[index]-1 -1
                    back = reserve[index]-1 +1
                    //if(pre==-1|| back == n) continue
                    if(pre<=-1) check[back] = true
                    else if(back == n) check[pre] = true
                    else{
                        //여기서 판단을 잘해야하는구나...누군가 빌려주면 누구는 못빌려줄수있으니까
                        if(!check[back]) check[back] = true
                        else if(!check[pre]) check[pre] =true

                    }
                }

                //출석 체크
                for(index in 0..n-1){
                    if(check[index]) answer++
                }

                return answer
            }
        }
        val a = Solution()
        a.solution(5,intArrayOf(2,4),intArrayOf(1,3,5))//5
        a.solution(5,intArrayOf(2,4),intArrayOf(3))//4
        a.solution(3,intArrayOf(3),intArrayOf(1))//2
        a.solution(4, intArrayOf(2,3), intArrayOf(3,4))//3
        // o o x
    }
}