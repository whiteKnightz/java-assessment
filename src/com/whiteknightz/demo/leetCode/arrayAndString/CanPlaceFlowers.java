package com.whiteknightz.demo.leetCode.arrayAndString;

/*
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be
planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false
otherwise.

 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int totalNewPlant = 0;
        int len = flowerbed.length;

        for (int i=0;i<len;i++){
            if (i>0){
                if (i+1==len && flowerbed[i]==0 && flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    totalNewPlant++;
                } else if (i+1<len && flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    totalNewPlant++;
                }
            } else {
                if (i+1==len && flowerbed[i]==0){
                    flowerbed[i]=1;
                    totalNewPlant++;
                } else if (i+1<len && flowerbed[i]==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    totalNewPlant++;
                }
            }
            if (totalNewPlant==n){
                break;
            }
        }

        return totalNewPlant>=n;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{0,1,0};
        int n = 1;

        boolean result = canPlaceFlowers(flowerbed, n);

        System.out.println("Result:"+result);
    }
}
