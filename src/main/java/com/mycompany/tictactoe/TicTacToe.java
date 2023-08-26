/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TicTacToe {

    static ArrayList<Integer> PlayerPosition = new ArrayList<>();
    static ArrayList<Integer> ComputerPosition = new ArrayList<>();

    public static void main(String args[]) {
        char[][] board = {{' ', '|', ' ', '|', ' '},
        {'+', '+', '+', '+', '+'},
        {' ', '|', ' ', '|', ' '},
        {'+', '+', '+', '+', '+'},
        {' ', '|', ' ', '|', ' '}};

        printBoard(board);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the position from 1-9");
            int userpos = sc.nextInt();

            while(PlayerPosition.contains(userpos) || ComputerPosition.contains(userpos))
            {
                System.out.println("Please enter diferent position");
                userpos = sc.nextInt();
                
            }

            symbol(userpos, board, "Player");
            String win = checkWinner();        
            if(win.length() > 0 )
            {
                System.out.println(win);
                break;
                
                
            }

            Random rnd = new Random();
            int compos = rnd.nextInt(9) + 1;
            while(PlayerPosition.contains(compos) || ComputerPosition.contains(compos))
            {
                compos = rnd.nextInt(9) + 1;
                
            }
            symbol(compos, board, "Computer");

            printBoard(board);
            win = checkWinner();
            if(win.length() > 0 )
            {
                System.out.println(win);
                break;
            }
        }

    }

    public static void printBoard(char[][] board) {

        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }

            System.out.print("\n");
        }

    }

    public static void symbol(int userpos, char[][] board, String usersinput) {
        char symbol = 'X';
        if (usersinput.equals("Player")) {
            symbol = 'X';
            PlayerPosition.add(userpos);
        } else if (usersinput.equals("Computer")) {
            symbol = 'O';
            ComputerPosition.add(userpos);
        }

        switch (userpos) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
            default:
                break;

        }

    }

    public static String checkWinner() {
        List toprow = Arrays.asList(1, 2, 3);
        List middlerow = Arrays.asList(4, 5, 6);
        List bottomrow = Arrays.asList(7, 8, 9);
        List firstcolumn = Arrays.asList(1, 4, 7);
        List middlecolumn = Arrays.asList(2, 5, 8);
        List lastcolumn = Arrays.asList(3, 6, 9);
        List firstdia = Arrays.asList(1, 5, 9);
        List seconddia = Arrays.asList(3, 5, 7);

        List<List> condition = new ArrayList<>();
        condition.add(toprow);
        condition.add(bottomrow);
        condition.add(middlerow);
        condition.add(firstcolumn);
        condition.add(middlecolumn);
        condition.add(lastcolumn);

        condition.add(firstdia);
        condition.add(seconddia);
        
        for(List win:condition)
        {
            if(PlayerPosition.containsAll(win))
            {
                return "Player wins";
            }
            else if(ComputerPosition.containsAll(win))
            {
                return "Computer wins!!";
            }
            else if(PlayerPosition.size() +ComputerPosition.size() == 9)
            {
                return "It's tie:)";
            }
        }
        return "";

    }
}
