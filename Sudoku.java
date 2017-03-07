import java.lang.System;

public class Sudoku{
  private char[][] boardState;
  /**
  initialize your state to represent an empty Sudoku puzzle.
  */
  public Sudoku(){
    boardState= new char[9][9];
  }
  /**
  Our second constructor takes a string representing the initial configuration of the puzzle.
  */
  public Sudoku(String starting_config){
    boardState = new char[9][9];
    String[] rows = starting_config.split("\n");
    for(int rowIndex = 0; rowIndex <9; rowIndex++){
      for(int colIndex = 0; colIndex <9; colIndex++){
        boardState[rowIndex][colIndex] = rows[rowIndex].charAt(colIndex);
      }
    }
  }
  /**Should take a row and column number and return the digit in that square.
  @param row a rowindex for the boardState array
  @param col a column index for the boardState array
  @return char at that position of the board
  */
  public char getSquare(int row, int col){
    return boardState[row][col];
  }
  /**
  Takes a row, column and digit, and sets the puzzle to store value at the given location.
  @param row a rowindex for the boardState array
  @param col a column index for the boardState array
  @param value the value of the new char
  */
  public void setSquare(int row, int col, char value){
    boardState[row][col] = value;
  }
  //Returns true if all three Sudoku rules are observed.
  public boolean isValid(){
    return isAllRowsValid() && isAllColumnsValid() && isAllSquaresValid();
  }
  //checks if all rows are vaild
  private boolean isAllRowsValid(){
    for(int i = 0; i< 9; i++){
      if(!isRowValid(i)){
        return false;
      }
    }
    return true;
  }
  //checks row to see if valid for all digits
  private boolean isRowValid(int rowIndex){
    for(int i = 1; i < 10; i++){
      if(!isRowValidForDigit(rowIndex, (char) (i+48))){
        return false;
      }
    }
    return true;
  }
  //checks row to see if valid for a digit
  private boolean isRowValidForDigit(int rowIndex, char digit){
    int counter = 0;
    for(int i = 0; i < 9; i++){
      if(digit == boardState[rowIndex][i]){

        counter++;
      }
    }
    //System.out.println(counter);
    return !(counter > 1);
  }
  //checks if all columns are vaild
  private boolean isAllColumnsValid(){
    for(int i = 0; i < 9; i++){
      if(!isColumnsValid(i)){
        return false;
      }
    }
    return true;
  }
  //checks columns to see if valid for all digits
  private boolean isColumnsValid(int colIndex){
    for(int i = 1; i < 10; i++){
      if(!isColumnsValidForDigit(colIndex, (char) (i+48))){
        return false;
      }
    }
    return true;
  }
  //checks columns to see if valid for a digit
  private boolean isColumnsValidForDigit(int colIndex, char digit){
    int counter = 0;
    for(int i = 0; i < 9; i++){
      //System.out.println(digit == boardState[i][colIndex]);
      if(digit == boardState[i][colIndex]){
        counter++;
      }
    }
    //System.out.println(counter);
    return !(counter > 1);
  }
  //checks if all squares are vaild
  private boolean isAllSquaresValid(){
    for(int i = 0; i < 9; i+=3){
      for(int j = 0; j < 9; j+=3){
        if (!isSquaresValid(i,j)){
          return false;
        }
      }
    }
    return true;
  }
  //checks cube to see if valid for all digits
  private boolean isSquaresValid(int colIndex, int rowIndex){
    for(int i = 1; i < 10; i++){
      if(!isSquaresValidForDigit(colIndex, rowIndex, (char) (i+48))){
        return false;
      }
    }
    return true;
  }
  //checks cube to see if valid for a digit
  private boolean isSquaresValidForDigit(int colIndex, int rowIndex, char digit){
    int counter = 0;
    for(int r = rowIndex; r < rowIndex + 3; r++){
      for(int c = colIndex; c < colIndex + 3; c++){
        if(digit == boardState[r][c]){
          counter++;
        }
      }
    }
    return !(counter > 1);
  }
  //Returns true if the puzzle has no more blank spaces and is still valid.
  public boolean isSolved(){
    for(int rowIndex = 0; rowIndex <9; rowIndex++){
      for(int colIndex = 0; colIndex <9; colIndex++){
        if(boardState[rowIndex][colIndex] == (char)32){
          return false;
        }
      }
    }
    return isValid();
  }
}
