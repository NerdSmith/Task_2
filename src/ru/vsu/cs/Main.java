package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static ChessCoordinates translateCoord(String s){
        int x = 1;
        char fchar = s.charAt(0);
        int y = s.charAt(1) - '0';

        switch (fchar){
            case 'a': x = 1;
            break;
            case 'b': x = 2;
            break;
            case 'c': x = 3;
            break;
            case 'd': x = 4;
            break;
            case 'e': x = 5;
            break;
            case 'f': x = 6;
            break;
            case 'g': x = 7;
            break;
            case 'h': x = 8;
            break;
        }
        return new ChessCoordinates(x, y);
    }

    public static boolean pawn(ChessCoordinates from, ChessCoordinates to){
        return (from.x == to.x) && ((from.y+1 == to.y) || (from.y+2 == to.y));
    }

    public static boolean knight(ChessCoordinates from, ChessCoordinates to){
        return (((from.x+1==to.x) || (from.x-1==to.x)) && ((from.y+2==to.y) || (from.y-2==to.y))) ||
                (((from.x+2==to.x) || (from.x-2==to.x)) && ((from.y+1==to.y) || (from.y-1==to.y)));
    }

    public static boolean bishop(ChessCoordinates from, ChessCoordinates to){
        return Math.abs(to.x - from.x) == Math.abs(to.y - from.y) && ((from.x != to.x) && (from.y != to.y));
    }

    public static boolean castle(ChessCoordinates from, ChessCoordinates to){
        return ((from.x != to.x) && (from.y == to.y)) || ((from.y != to.y) && (from.x == to.x));
    }

    public static boolean queen(ChessCoordinates from, ChessCoordinates to){
        return castle(from, to) || bishop(from, to);
    }

    public static boolean king(ChessCoordinates from, ChessCoordinates to){
        return ((to.x - from.x == 1) || (to.y - from.y == 1)) && ((from.x != to.x) && (from.y != to.y));
    }

    public static void figuresPrint(ChessCoordinates firstCoordinate, ChessCoordinates secondCoordinate){
        if (pawn(firstCoordinate, secondCoordinate)){
            System.out.print("Pawn ");
        }
        if (knight(firstCoordinate, secondCoordinate)){
            System.out.print("Knight ");
        }
        if (bishop(firstCoordinate, secondCoordinate)){
            System.out.print("Bishop ");
        }
        if (castle(firstCoordinate, secondCoordinate)){
            System.out.print("Castle ");
        }
        if (queen(firstCoordinate, secondCoordinate)){
            System.out.print("Queen ");
        }
        if (king(firstCoordinate, secondCoordinate)){
            System.out.print("King ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first coordinate: ");
        ChessCoordinates firstCoordinate = translateCoord(scanner.next());
        System.out.print("Enter the second coordinate: ");
        ChessCoordinates secondCoordinate = translateCoord(scanner.next());
        figuresPrint(firstCoordinate, secondCoordinate);
    }
}
