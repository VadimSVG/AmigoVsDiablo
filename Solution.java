package com.vadimsw.task.pro.task06.task0622;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Solution {

    public static int amigoLives = 9;
    public static int diabloLives = 9;

    public static void amigoLostLife() {
        Solution.amigoLives = Solution.amigoLives - 1;
    }

    public static void diabloLostLife() {
        Solution.diabloLives = Solution.diabloLives - 3;
    }

    public static int amigoAttacks() {
        int attackAmigo = getRandomNumber(3);
        return attackAmigo;
    }

    public static int diabloDefends() {
        int diabloDef = getRandomNumber(3);
        return diabloDef;
    }

    public static void battle() {
        while (amigoLives > 0 & diabloLives > 0) {
            if (amigoAttacks() == diabloDefends()) {
                amigoLostLife();
                System.out.println(diabloDefendPhrase);
            }
            if (amigoAttacks() != diabloDefends()) {
                diabloLostLife();
                System.out.println(amigoAttackPhrase);
            }
        }
    }
    public static boolean  isAmigoWin(){
        return  ((Solution.diabloLives == 0 && (Solution.amigoLives != 0) ));

    }



    public static String getFirstPositionPhrase = "Помоги Амиго определить, где спрятался Диабло? Введи номер позиции (1, 2, 3 или 4):";
    public static String getPositionPhrase = "Диабло не обнаружен. Давай попробуем снова. Введи номер позиции (1, 2, 3 или 4):";
    public static String findDiabloPhrase = "Амиго обнаружил Диабло.";
    public static String diabloDefendPhrase = "Амиго атакует. Диабло отбил атаку Амиго и нанес ответный удар.";
    public static String amigoAttackPhrase = "Удар Амиго достиг цели. Диабло потерял 3 жизни.";
    public static String winPhrase = "Амиго одержал победу над Диабло и выбил из его головы загадочный кристалл.";
    public static String loosePhrase = "Диабло победил Амиго.";
    public static int diabloPosition;


    public static void findDiablo() {
        System.out.println(Solution.getFirstPositionPhrase);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        while (input != Solution.diabloPosition) {
            System.out.println(Solution.getPositionPhrase);
            input = scanner.nextInt();
        }
        if (input == Solution.diabloPosition)
            System.out.println(Solution.findDiabloPhrase);
    }


    public static void main(String[] args) {
        diabloPosition = getRandomNumber(4);
        findDiablo();
        battle();
        System.out.println((isAmigoWin())? Solution.winPhrase : Solution.loosePhrase);
    }

    public static int getRandomNumber(int range) {
        return (int) (Math.random() * range) + 1;
    }
}
