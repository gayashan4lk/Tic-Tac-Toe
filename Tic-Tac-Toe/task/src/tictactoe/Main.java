package tictactoe;

import java.util.*;

public class Main {

    public static void printField (char [][] arr) {
        System.out.println("---------");
        for (int i=0; i < 3; i++) {
            System.out.print("| ");
            for(int j= 0; j < 3; j++) {
                System.out.print(arr [i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean isNumber (char character) {
        boolean flag = false;
        char [] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        for (char number : numbers){
            if (character == number) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isWithingRange (char character) {
        boolean flag = false;
        char [] range = { '1', '2', '3' };
        for (char numbersInRange : range){
            if(character == numbersInRange){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isOccupied (char a, char b, char [][] field) {
        int index = 0;
        boolean flag = false;
        String str = getOccupiedCells(field);
        for(int i = 0; i < str.length(); i = i+2 ){
            int x = index;
            int y = ++index;
            if (a == str.charAt(x) && b == str.charAt(y)){
                flag = true;
            }
            index++;
        }
        return flag;
    }

    public static int isValidInput (char[] coordinates, char [][] field) {
        // 0=> input is valid , 1=> not a number , 2=> not within range , 3=> occupied coordinates
        int error;
        if(coordinates.length < 3){
            if (isNumber(coordinates[0]) && isNumber(coordinates[1])){
                if (isWithingRange(coordinates[0]) && isWithingRange(coordinates[1])){
                    if (!(isOccupied(coordinates[1], coordinates[0], field))){
                        error = 0;
                    } else {
                        error = 3;
                    }
                } else {
                    error = 2;
                }
            } else {
                error = 1;
            }
        } else {
            error = 1;
        }
        return error;
    }

    public static char getFirstCoordinate (int i) {
        char y;
        if(i == 0 ) {
            y = '3';
        }else if (i == 1) {
            y = '2';
        }else if (i == 2) {
            y = '1';
        }else {
            y = 'n';
        }
        return y;
    }

    public static char getSecondCoordinate (int i) {
        char y;
        if (i == 0) {
            y = '1';
        }else if (i == 1) {
            y = '2';
        }else if (i == 2) {
            y = '3';
        }else {
            y = 'n';
        }
        return y;
    }

    public static int getRowIndex (char y) {
        int i;
        if (y == '3'){
            i = 0;
        }else if (y == '2'){
            i = 1;
        }else if (y == '1'){
            i = 2;
        }else{
            i = 99;
        }
        return i;
    }

    public static int getColumnIndex (char x) {
        int i;
        if (x == '1'){
            i = 0;
        }else if (x == '2'){
            i = 1;
        }else if (x == '3'){
            i = 2;
        }else{
            i = 99;
        }
        return i;
    }

    public static String getOccupiedCells (char [][] field) {
        StringBuilder occupiedCells = new StringBuilder () ;
        for (int i = 0; i < 3; i++ ){
            for (int j = 0; j < 3; j++){
                if(field[i][j] == 'X' || field[i][j] == 'O' ){
                    occupiedCells.append(getFirstCoordinate(i));
                    occupiedCells.append(getSecondCoordinate(j));
                }
            }
        }
        return occupiedCells.toString();
    }

    public static char [] getUserInput (Scanner scanner) {
        System.out.print("Enter the coordinates: ");
        char [] coordinates;
        String inputString = scanner.next();
        String formattedString = inputString.replaceAll("\\s","");
        coordinates = formattedString.toCharArray();
        return coordinates;
    }

    public static boolean xWins (StringBuilder checkingStr) {
        boolean flag = false;
        if (checkingStr.toString().equals("XXX")) {
            flag = true;
        }
        return flag;
    }

    public static boolean oWins (StringBuilder checkingStr) {
        boolean flag = false;
        if (checkingStr.toString().equals("OOO")) {
            flag = true;
        }
        return flag;
    }

    public static int gameStatus ( StringBuilder checkingStr , char [][] field) {
        int status = 99; //status : 0=> Game not finished 1=> X wins 2=> O wins 3=> Draw 4=> Impossible
        boolean xWins = false;
        boolean oWins = false;
        boolean [] xWinsRow = new boolean[3];
        boolean [] oWinsRow = new boolean[3];
        boolean [] xWinsCol = new boolean[3];
        boolean [] oWinsCol = new boolean[3];
        boolean xWinsFD;
        boolean oWinsFD;
        boolean xWinsBD;
        boolean oWinsBD;
        boolean emptyCells = false;
        boolean impossible = false;
        int xCount = 0;
        int oCount = 0;
        int diff = 0;

        // checking empty cells
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == '_' || field[i][j] == ' ') {
                    emptyCells = true;
                    break;
                }
            }
            if (emptyCells) {
                break;
            }
        }

        // checking impossible
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (field [i][j] == 'X'){
                    xCount++;
                }
                if (field [i][j] == 'O'){
                    oCount++;
                }
            }
        }
        if (oCount > xCount){
            diff = oCount - xCount;
        }
        if (xCount > oCount){
            diff = xCount - oCount;
        }
        if (diff >= 2){
            impossible = true;
        }

        //checking rows
        checkingStr.setLength(0);
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                checkingStr.append(field[i][j]);
            }
            xWinsRow[i] = xWins(checkingStr);
            oWinsRow[i] = oWins(checkingStr);
            checkingStr.setLength(0);
        }

        //checking columns
        checkingStr.setLength(0);
        for (int i = 0; i < 3; i++ ) {
            for (int j = 0; j < 3; j++ ) {
                checkingStr.append(field [j][i]);
            }
            xWinsCol[i] = xWins(checkingStr);
            oWinsCol[i] = oWins(checkingStr);
            checkingStr.setLength(0);
        }

        //checking forward diagonal
        checkingStr.setLength(0);
        for (int i = 0; i < 3; i++) {
            checkingStr.append(field[i][i]);
        }
        xWinsFD = xWins(checkingStr);
        oWinsFD = oWins(checkingStr);

        //checking backward diagonal
        checkingStr.setLength(0);
        for (int i = 0; i < 3; i++) {
            for (int j = 2 ; j >= 0; j--) {
                if (i == 0 ) {
                    checkingStr.append(field [i][j]);
                    break;
                }
                if (i == 1 && j == 1 ) {
                    checkingStr.append(field [i][j]);
                    break;
                }
                if (i == 2 && j == 0) {
                    checkingStr.append(field [i][j]);
                    break;
                }
            }
        }
        xWinsBD = xWins(checkingStr);
        oWinsBD = oWins(checkingStr);

        for (int i = 0; i < 3; i++){
            if (xWinsRow[i] || xWinsCol[i] || xWinsFD || xWinsBD) {
                xWins = true;
                break;
            }
        }
        for (int i = 0; i < 3; i++){
            if (oWinsRow[i] || oWinsCol[i] || oWinsFD || oWinsBD) {
                oWins = true;
                break;
            }
        }

        //0=> Game not finished 1=> X wins 2=> O wins 3=> Draw 4=> Impossible

        if (!xWins && !oWins && emptyCells ) {
            status = 0; // game not finished
        }
        if (xWins && !oWins) {
            status = 1; // x Wins
        }
        if (!xWins && oWins) {
            status = 2; // o Wins
        }
        if (!xWins && !oWins && !emptyCells ) {
            status = 3; // Draw
        }
        if (xWins && oWins || impossible ) {
            status = 4; // impossible
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        StringBuilder checkingStr = new StringBuilder();
        char [][] field = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                field[i][j] = ' ';
            }
        }
        printField(field);
        char [] coordinates;
        char [] gameSymbols = {'X' ,'O' };
        int counter = 0;
        //int error;
        int statusOfGame = 0;

        while (statusOfGame == 0) {
            coordinates = getUserInput(scanner);
            int error = isValidInput(coordinates, field);
            switch (error){
                case 0:
                    field [getRowIndex(coordinates[1])][getColumnIndex(coordinates[0])] = gameSymbols[counter%2];
                    counter++;
                    statusOfGame = gameStatus(checkingStr , field);
                    printField(field);
                    break;
                case 1:
                    System.out.println("You should enter numbers!");
                    break;

                case 2:
                    System.out.println("Coordinates should be from 1 to 3!");
                    break;

                case 3:
                    System.out.println("This cell is occupied! Choose another one!");
                    break;
            }
        }

            switch (statusOfGame){
                case 1:
                    System.out.println("X wins");
                    break;

                case 2:
                    System.out.println("O wins");
                    break;

                case 3:
                    System.out.println("Draw");
                    break;

                case 4:
                    System.out.println("Impossible");
                    break;
            }
    }
}