package com.nicklous.algorithm.Easy;/*
 * @AUTHOR   LiXiang
 * @Classname Solution
 *
 * @Date 2021/5/31 上午9:40
 *

 * @userName
 */

import java.util.Arrays;

public class MaxmumMulty_628 {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3};
         MaxmumMulty_628 maxmumMulty_628 = new MaxmumMulty_628();
        System.out.println(maxmumMulty_628.maxmumProduct(nums));
    }

    public int maxmumProduct(int[] nums){

        Arrays.sort(nums);
        //全正  全﹣ 两个-一个+
        int max1=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        //两个+ 一个-
        int max2=nums[0]*nums[1]*nums[nums.length-1];
        return Math.max(max1,max2);



    }
}
