package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //pirmaUzduotis();
        treciaUzduotis(3);



    }

    public static int[] readArray() throws IOException {
        String file = "C:\\Users\\Darius\\IdeaProjects\\2024-25-07uzduotis\\src\\main\\java\\org\\example\\masyvas.txt";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int i = 0;
        while((bufferedReader.readLine()) != null){
            i++;
        }
        int[] skaiciuMasyvas = new int[i];

        FileReader fileReader1 = new FileReader(file);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);

        String line;
        int j = 0;

        while((line = bufferedReader1.readLine()) != null){
            skaiciuMasyvas[j] = Integer.parseInt(line);
            j++;
        }
        bufferedReader.close();
        fileReader.close();
        return skaiciuMasyvas;
    }
    public static void pirmaUzduotis() throws IOException {
        int[] numbersList = readArray();
        int daugiausia = 0;
        int daugiausiaKartojosi = 0;
        for(int i = 0; i < numbersList.length; i++){
            int dabartinisPasikartojimas = 0;
            for(int j = 0; j < numbersList.length; j++){
                if(numbersList[i] == numbersList[j]){
                    dabartinisPasikartojimas++;
                }
            }
            if(dabartinisPasikartojimas > daugiausia){
                daugiausia = dabartinisPasikartojimas;
                daugiausiaKartojosi = numbersList[i];
            }
        }
        System.out.println("Daugiausia sarase kartojosi skaicius: " + daugiausiaKartojosi + " | " + daugiausia + " kartai.");
    }
    public static void treciaUzduotis(int n){
        int[][] magiskasKvadratas = new int[n][n];
        int skaicius = 1;

        int i = n / 2 - 1;
        int j = 1;

        while(skaicius < n * n + 1){

            i = i + 1;
            j = j - 1;
            if(i == n){
                i = 0;
            }
            if(j < 0){
                j = n - 1;
            }
            if(magiskasKvadratas[j][i] > 0){
                i = i - 1;
                j = j + 1;
                if(j == n){
                    j = 0;
                }
                if(i < 0){
                    i = n - 1;
                }
                j++;
            }
            magiskasKvadratas[j][i] = skaicius;
            skaicius++;

            for(int b = 0; b < n; b++){
                for(int v = 0; v < n; v++){
                    System.out.print(magiskasKvadratas[b][v] + "   ");
                }
                System.out.println();
            }
            System.out.println("---------------------------");
        }
    }

}