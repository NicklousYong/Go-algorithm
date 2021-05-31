package com.nicklous.algorithm.Easy;/*
 * @AUTHOR   LiXiang
 * @Classname TheThirdMun
 *
 * @Date 2021/5/24 上午9:44
 *
 * @userName
 */

/**
 * 定义一个三位的数组，然后将此数组进行遍历，将大小不符合条件的数据代替掉
 *
 */
public class TheThirdMun_414{

    public static void main(String[] args) throws Exception {
        int[] num = {2,2,3,1};
            TheThirdMun_414  theThirdMun=new TheThirdMun_414();
        System.out.println(theThirdMun.solution(num));
    }

    public int solution(int[] num) throws Exception {
        //接收最小的数
        int min = num[0];
        //接收第一大的数
        int first = num[0];
        //遍历，找出最小的数
        for (int i = 0; i < num.length; i++) {
            if(num[i]<min){
                min = num[i];
            }
        }
        //接收第二大的数
        int second  = min;
        //接收第三大的数
        int third =min;
        //利用循环，先选出最大的数，再利用比较来选出第二大的数，最后选出第三大的数
//        int temp = num[0];
//        int temp1 = num[0];
//        int temp2 = num[0];
        if(num.length==0 || num.length>10000){
            throw new Exception("数组长度异常");
        }else
        //仅有一个数
        if (num.length==1){
            return num[0];
            //仅有两个数
        }else if(num.length==2){
            return Math.max(num[0],num[1]);
        }else{
            for(int i=0;i<num.length;i++){

                if(num[i]>first){
                    first=num[i];
                }

                //first保持为之前最大的数;
                if(i==num.length-1){
                    System.out.println("最大的数为："+first);
                    for(int j=0;j<num.length;j++){
                        //位置数仅小于最大数，设为第二大的数
                        if (num[j]> second && num[j]<first) {
                            second = num[j];
                        }
                        if (j==num.length-1){
                            System.out.println("第二大的数为："+second);
                            for (int k=0;k<num.length;k++){
                                if(num[k]> third && num[k]<second){
                                    third = num[k];
                                }
                                if (k==num.length-1){
                                    System.out.println("第三大的数为："+third);
                                }
                            }
                        }
                    }
                }
            }
            if(second ==third ){
                return first;
            }
            else return third;
            }
        }
    //        //找出第一个数
//            for (int i=0;i<num.length;i++){
//                temp = num[1];
//                if(num[i]>temp)
//                    first=num[i];
//                System.out.println("最大的数为："+first);
//                first = temp;
//            }
//            //找出第二个数
//            for (int i=0;i<num.length;i++){
//                temp = num[i];
//                if(num[i]>temp && num[i]<first)
//                    second = num[i];
//                second = temp;
//                System.out.println("第二大的数为:"+second);
//            }
//            //找出第三个数
//            for (int i=0;i<num.length;i++){
//                temp = num[1];
//                if(num[i]>temp && num[i]<second){
//                    third = num[i];
//                    third = temp;
//                    System.out.println("第三大的数为："+third);
//                }
//            }
    //对数字进行判断，如果第二大的数等于第三大的数，返回第二大的数，否则返回
    //第一大的数
}
