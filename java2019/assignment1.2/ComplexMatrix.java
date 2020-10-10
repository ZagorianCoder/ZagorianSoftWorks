//STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
import java.util.Random;


public class ComplexMatrix{


  private ComplexNumber [][] Matrix;
  private Random rand = new Random();

//Default Constructor!
  public ComplexMatrix(){}

//Constructor for duplicating a Matrix of type ComplexNumber  !
  public ComplexMatrix(ComplexMatrix original){
  	int rows = original.Matrix.length;
  	int cols = original.Matrix[0].length;
  	Matrix = new ComplexNumber[rows][cols];
  	for (int i=0; i<rows; i++){
  		for (int j=0; j<cols; j++){
  			double real = original.Matrix[i][j].getReal();
  			double img = original.Matrix[i][j].getImg();
  			Matrix[i][j] = new ComplexNumber(real,img);
  		}
  	}
  }


  //Constructor for making a Matrix with ComplexNumber objects as elements!
  public ComplexMatrix(int rows, int cols){
    Matrix = new ComplexNumber[rows][cols];
    ComplexMatrix random_number = new ComplexMatrix();
    for (int i=0; i < rows ; i++ ) {
      for (int j=0; j < cols ; j++ ) {
        double real_part = random_number.computeRandom();
        double img_part = random_number.computeRandom();
        Matrix[i][j] = new ComplexNumber(real_part,img_part);
      }
    }
  }


//The Method for making random numbers of type double
  private double computeRandom(){
    int randomNum = (int) ( (rand.nextDouble()-0.5)*rand.nextInt(20)*100);
    return randomNum/100.0;
  }



  //toString method
  public String toString(){
    String matrixofComplexnumbers="[";
    if (Matrix.length == 1 && Matrix[0].length == 1) {

      matrixofComplexnumbers+=Matrix[0][0].toString()+"]";
      return  matrixofComplexnumbers;

    }
    for(int i=0;i < Matrix.length; i++){
      if (Matrix[i].length == 1) {

        if (i < Matrix.length - 1) {

            matrixofComplexnumbers+=Matrix[i][0].toString()+", ";

        }else{
            matrixofComplexnumbers+=Matrix[i][0].toString()+"]";
            return matrixofComplexnumbers;
        }

      }else{

        for(int j=0;j < Matrix[i].length; j++){
          if (Matrix.length ==1) {
            if (j < Matrix[i].length - 1 ) {
              matrixofComplexnumbers+=Matrix[0][j].toString()+", ";
            }else{
              matrixofComplexnumbers+=Matrix[0][j].toString();
            }
          }else{

            if (j < Matrix[i].length - 1 ) {

                matrixofComplexnumbers+=Matrix[i][j].toString()+", ";

            }else{

                matrixofComplexnumbers+=Matrix[i][j].toString();

            }

          }

        }
        if (i < Matrix.length -1) {

          matrixofComplexnumbers+=";\n";

        }
      }
    }
    matrixofComplexnumbers+=";]";
    return matrixofComplexnumbers;
  }

  public ComplexMatrix CompAdd(ComplexMatrix matrix){
    ComplexMatrix new_Matrix = new ComplexMatrix();
    if (this.Matrix.length == matrix.Matrix.length && this.Matrix[0].length == matrix.Matrix[0].length) {
      new_Matrix.Matrix = new ComplexNumber [Matrix.length][Matrix[0].length];
      for (int i=0; i < new_Matrix.Matrix.length ; i++ ) {
        for (int j=0; j < Matrix[i].length ; j++ ) {

          new_Matrix.Matrix[i][j] = Matrix[i][j].addComp(matrix.Matrix[i][j]);

        }

      }
      
      return new_Matrix;
    
    }
    
    return null;


  }
  public ComplexMatrix CompSubtract(ComplexMatrix matrix){
    ComplexMatrix new_Matrix = new ComplexMatrix();
    if (this.Matrix.length == matrix.Matrix.length && this.Matrix[0].length == matrix.Matrix[0].length) {
      new_Matrix.Matrix = new ComplexNumber [Matrix.length][Matrix[0].length];
      for (int i=0; i < new_Matrix.Matrix.length ; i++ ) {
        for (int j=0; j < Matrix[i].length ; j++ ) {

          new_Matrix.Matrix[i][j] = Matrix[i][j].subtractComp(matrix.Matrix[i][j]);

        }
      }
      return new_Matrix;
    }
    return  null;
  }
}
