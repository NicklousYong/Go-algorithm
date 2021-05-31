package com.nicklous.algorithm.Easy;/*
 * @AUTHOR   LiXiang
 * @Classname MaxConsecutiveOnes
 *
 * @Date 2021/5/21 上午10:04
 *

    给定一个二进制数组， 计算其中最大连续 1 的个数。

示例：

输入：[1,1,0,1,1,1]
输出：3
解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.


提示：

输入的数组只包含 0 和 1 。
输入数组的长度是正整数，且不超过 10,000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-consecutive-ones
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @userName
 */

import java.util.Arrays;

public class MaxConsecutiveOnes_485 {

    public MaxConsecutiveOnes_485(int[] template){
    }
    public static void main(String[] args) throws Exception {
        int[] template ={1,0,1,10,1,1,1,1,1,0,0,0};

        System.out.println(MaxConsecutiveOnes_485.MaxConsecutiveOnes(template));
    }
    //将数组转化为String数组，并得到其中最多1的一组
    public static int MaxConsecutiveOnes(int[] nums) throws Exception {
        int result = 0;
        int addTemp = 0;
        if(nums.length<0||nums.length>1000){
            throw new Exception("数组长度异常！！！");
        }
        String s = Arrays.toString(nums);
        String[] splitNum = s.split("0");
        int j = 0;
        for (String s1 : splitNum) {
            //找到数组长度最大值
            j++;
            //将数组中的值进行遍历，如果符合条件，则加一。
            for (int k=0;k<s1.length();k++){
                    if(s1.charAt(k)=='1'){
                            addTemp++;
                    }
            }

            //确保result的值为当前最大长度
            if(addTemp>result){
                result=addTemp;
            }

            addTemp=0;
//            System.out.println("第"+j+"次循环！！！");
//            System.out.println("s1长度为："+s1.length());
//            System.out.println("S1内容为： "+s1.toString());
//            System.out.println("Re为："+result);
            continue;
        }

        return result;
    }



    }






