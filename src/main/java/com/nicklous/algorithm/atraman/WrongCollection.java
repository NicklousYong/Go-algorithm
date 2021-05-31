package com.nicklous.algorithm.atraman;/*
 * @AUTHOR   LiXiang
 * @Classname WrongCollection
 *
 * @Date 2021/5/31 上午10:24
 *

 * @userName
 */

import javax.crypto.spec.PSource;
import java.util.Arrays;

public class WrongCollection {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,4,5,6};
        WrongCollection rc  = new WrongCollection();
        int[] result=rc.Solution(nums);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public int[] Solution(int[] nums){
        int[] counter = new int[nums.length+1];
        for (int i:nums){
            counter[i]++;
        }
        int[] result = new int[2];
        for (int i=0;i<nums.length;i++){
            if (counter[i]==0){
                result[0]=i;
            }else if (counter[i]==2){
                result[1]=i;
            }
        }
        return result;
    }


}
