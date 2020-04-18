/*
 * Copyright 2020 Andi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package StrukturData12;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Andi
 */
public class recursive_minArray {
   public static int findMinRec(int A[], int n) 
{ 
    // if size = 0 means whole array has been traversed 
    if (n == 1) 
        return A[0]; 
    return Math.min(A[n-1], findMinRec(A, n-1)); 
} 
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n]; 
        for (int i = 0; i < (n); i++) {
            arr[i]= (new Random().nextInt(100+1));
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println("");
        System.out.println("nilai terkecil = "+findMinRec(arr,n));
    }
}
