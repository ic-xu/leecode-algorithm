package com.xu.algorithm;

/**
 * @author chenxu
 * @version 1
 * @date 2022/5/13 17:36
 */
public class 大小顶堆 {


    public static void main(String[] args) {
        getTopMin();
    }




    public static void getTopMin(){
        int[]  data = {33,76,34,66,22,31,13,25,90,87,56,65,66,9,6,8,3,77,98,897,789};

        int n = 5; //获取最小的top 5个元素
        int[]  result = new int[n+1];
        for(int i=0;i<n;i++){
            result[i+1] = data[i];
        }
        constructBigHeap(result,n);
        printArray(result);
        for(int i=n;i<data.length;i++){
            if(result[1]>data[i]){
                result[1] = data[i];
                constructBigHeap(result,n);
            }
        }
        printArray(result);


    }

    //构建大顶堆
    static void  constructBigHeap(int[] data,int n){
        //int n = data.length-1;
        for(int i=n/2;i>=1;i--){
            heapify(data,n,i);
        }
    }

    //堆化，调整当前 父节点i及其以下子节点的顺序，大顶堆
    public static void heapify(int[] data,int n,int i){
        while (true) {
            int maxPos = i;

            if (i * 2 <= n && data[i * 2] > data[maxPos]){
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && data[i * 2 + 1] > data[maxPos]) {
                maxPos = i * 2 + 1;
            }

            if (maxPos == i){
                break;
            }
            swap(data, i, maxPos);
            i = maxPos;
        }

    }

    private static void swap(int[] data,int i,int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void printArray(int[] data){
        for(int d:data){
            System.out.print(d+" ");
        }
        System.out.println();
    }



}
