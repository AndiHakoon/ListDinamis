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

import java.util.Scanner;

/**
 * @author Andi
 * 
 */
public class Rekursi_pangkat {

    /**
     * @param args the command line arguments
     */
    public static int pangkat(int x, int y){
        if (y==0) {
            return 1;
        }else{
            return x*pangkat(x,y-1);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Bilangan : ");int a=in.nextInt();
        System.out.print("Masukkan pangkat bilangan : ");int b = in.nextInt();
        System.out.println(" A ^ B = "+a+" ^ "+b+" = "+pangkat(a,b));
    }

}
