package org.share.java.sa.datastructure.array;

import java.util.Arrays;

/**
 * Created by DawnSailing on 2020/10/4 12:05
 */
public class SparseArray {

    public static void main(String[] args) {
        int [][] array02 = twoDimensionalArrayTOSparseArray();
        System.out.println(Arrays.toString(array02));
        int [][] array03 = sparseArrayToTwoDimensionalArray(array02);
        System.out.println(Arrays.toString(array03));
    }

    private static int [][] twoDimensionalArrayTOSparseArray() {
        int[][] array01 = new int [11][11];
        array01[0][1] = 1;
        array01[1][2] = 2;
        Integer sum = 0;
        for(int i = 0; i<array01.length;i++) {
            for(int j = 0;j<array01[i].length;j++) {
                if(array01[i][j]!=0) {
                    sum++;
                }
            }
        }
        int [][] array02 = new int[sum+1][3];
        array02[0][0] = array01.length;
        array02[0][1] = array01[0].length;
        array02[0][2] = sum;
        Integer sum2 = 0;
        for(int i = 0; i<array01.length;i++) {
            for(int j = 0;j<array01[i].length;j++) {
                if(array01[i][j]!=0) {
                    sum2++;
                    array02[sum2][0] = i;
                    array02[sum2][1] = j;
                    array02[sum2][2] = array01[i][j];
                }
            }
        }
        return array02;
    }

    private static int [][] sparseArrayToTwoDimensionalArray(int [][] array02) {
        int [][] array03 = new int[array02[0][0]][array02[0][1]];
        for(int i = 1;i<array02.length;i++) {
            array03[array02[i][0]][array02[i][1]] = array02[i][2];
        }
        return array03;
    }

}
