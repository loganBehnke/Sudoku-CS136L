

public class Sudoku{
public char[][] boardState;
  //initialize your state to represent an empty Sudoku puzzle.
  public Sudoku(){
    boardState= new char[9][9];
  }
  //Our second constructor takes a string representing the initial configuration of the puzzle.
  public Sudoku(String starting_config){
    int placeholder = 0;
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9;j++){
        boardState[i][j] = starting_config.charAt(placeholder);
        placeholder++;
      }
    }
  }
  //Should take a row and column number and return the digit in that square.
  public char getSquare(int row, int col){
    return 'e';
  }
  //Takes a row, column and digit, and sets the puzzle to store value at the given location.
  public void setSquare(int row, int col, char value){

  }
  //Returns true if all three Sudoku rules are observed.
  public boolean isValid(){
    return False;
    //return isAllRowsValid() && isAllColumnsValid() && isAllSquaresValid();
  }
  //checks if all rows are vaild
  private boolean isAllRowsValid(){
    for(int i = 0; i< 9; i++){
      if(!isRowValid(i)){
        return False;
      }
    }
    return True;
  }
  //checks row to see if valid
  private boolean isRowValid(int rowIndex){
    return False;
  }
  //checks row to see if valid for a digit
  private boolean isRowValidForDigit(int rowIndex, char digit){
    return False;
  }
  //Returns true if the puzzle has no more blank spaces and is still valid.
  public boolean isSolved(){
    return False;
  }
}
