package com.algorithm.ArrayAlg;
//二维数组的查找，从左下角开始比较
public class FindInTVArray {
    public boolean Find(int target, int [][] array) {
        if(array == null){
            return false;
        }
        int weidge = array.length-1;
        int height = array[0].length-1;
        if(weidge < 0 || height<0 ){
            return false;
        }
        int indexNum = array[weidge][0];

        int wIndex = weidge;
        int hIndex = 0;

        while(hIndex <= height && wIndex >= 0){
            if(target == indexNum) {
                return true;
            }
            else if(target > indexNum){
                hIndex++;
                if(hIndex <= height) {
                    indexNum = array[wIndex][hIndex];
                }
            }
            else if(target < indexNum){
                wIndex--;
                if(wIndex >= 0) {
                    indexNum = array[wIndex][hIndex];
                }
            }

        }
        return false;
    }

}
