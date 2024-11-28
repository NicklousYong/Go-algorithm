package com.nicklous.algorithm.Easy;/*
 * @AUTHOR   LiXiang
 * @Classname LengthOfArray_697
 *
 * @Date 2021/5/31 下午2:22
 *
 * @userName
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 思路及解法
 *
 * 记原数组中出现次数最多的数为 xx，那么和原数组的度相同的最短连续子数组，
 * 必然包含了原数组中的全部 xx，且两端恰为 xx 第一次出现和最后一次出现的位置。
 *
 * 因为符合条件的 xx 可能有多个，即多个不同的数在原数组中出现次数相同。
 * 所以为了找到这个子数组，我们需要统计每一个数出现的次数，同时还需要统计每一个数第一
 * 次出现和最后一次出现的位置。
 *
 * 在实际代码中，我们使用哈希表实现该功能，每一个数映射到一个长度为 33 的数组，
 * 数组中的三个元素分别代表这个数出现的次数、这个数在原数组中第一次出现的位置和这个数在原数组
 * 中最后一次出现的位置。当我们记录完所有信息后，我们需要遍历该哈希表，找到元素出现次数最多，
 * 且前后位置差最小的数。
 *
 */
public class LengthOfArray_697 {

    public static void main(String[] args) {
        int[] nums = new int[]{};
        LengthOfArray_697 lengthOfArray_697 = new LengthOfArray_697();
        System.out.println(lengthOfArray_697.findShortestSubArray(nums));
    }



    public int findShortestSubArray(int[] nums){
        Map<Integer,int[]> map = new HashMap<Integer,int[]>();
        int n = nums.length;
        /**
         * 对数组进行遍历，如果不存在遍历到的元素，则添加该元素到Map中.
         * 如果存在该元素，则储存该元素出现的次数，第一次出现的位置和最后一次出现的位置
         */
        for (int i = 0; i < n ; i++) {
            if (map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2]=i;
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxNum = 0,minLen=0;
        //对map进行遍历
        for (Map.Entry<Integer,int[]> entry:map.entrySet()){
            int[] arr =entry.getValue();
            if (maxNum<arr[0]){
                maxNum = arr[0];
                minLen = arr[2] - arr[0]+1;
            }else if (maxNum==arr[0]){
                if (minLen>arr[2] - arr[1]+1){
                    minLen = arr[2]-arr[1]+1;
                }
            }
        }
        return minLen;
    }

    public int findShortestSubArray_MyEdition(int[] nums){

        //1.对数组进行遍历，得到每个数出现的次数，第一次出现的位置，最后一次出现的位置
        //2.对步骤一的结果进行遍历，计算出现次数最多的数，该数第一次出现和最后一次出现的位置差。
        Map<Integer ,int[]> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2]=i;
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxNum = 0;int minLen = 0;

        //2.对步骤一的结果进行遍历，计算出现次数最多的数，该数第一次出现和最后一次出现的位置差。
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum<arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[0] + 1;
                //如果不同数字出现的次数相同，取数组中跨度最大的
            }else  if (maxNum==arr[0]){
                if (minLen>arr[2]-arr[1]+1){
                    minLen = arr[2]-arr[1]+1;
                   }
                }
            }
        return minLen;
        }


}
