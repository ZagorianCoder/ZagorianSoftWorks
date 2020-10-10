//STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
public class ComplexNumber{
  private double real;
  private double img;
  //Constructor for creating a Comple Number!
  public ComplexNumber(double real,double img){

    this.real = real;
    this.img = img;
  }

//Accessors!
  public double getReal(){return real;}
  public double getImg(){return img;}
//Mutators!
  public void setReal(double real){this.real = real;}
  public void setImg(double img){this.img = img;}


  public ComplexNumber addComp(ComplexNumber num){
    ComplexNumber new_num = new ComplexNumber(real, img);
    new_num.real += num.real;
    new_num.img += num.img;
    return new_num;
  }
  public ComplexNumber subtractComp(ComplexNumber num){
    ComplexNumber new_num = new ComplexNumber(real, img);
    new_num.real -= num.real;
    new_num.img -= num.img;
    return new_num;
  }
  public ComplexNumber multiplyComp(ComplexNumber num){
    ComplexNumber new_num = new ComplexNumber(real, img);
    new_num.real = real*num.real - img*num.img;
    new_num.img = real*num.img + img*num.real;
    return new_num;
  }
  public String toString(){
    if (img <0) {
      double positive_img=img*(-1);
      return real + " - " + positive_img+"i";
    }
    return real + " + " + img+"i";
  }
  public boolean equals(ComplexNumber num){
    if (real == num.real && img == num.img ) {
      return true;

    }
    return false;
  }
}
