//Crafted by ZagorianCoder

#include <stdio.h>

int main() {
    
    int number_of_absences;
    int PR1;
    int PR2;
    int FEXGR;
    do
    {
        printf("Insert number of absences: ");
        scanf("%d", &number_of_absences);
        printf("\nInsert the grade for progress1: ");
        scanf("%d", &PR1);
        printf("\nInsert the grade for progress2: ");
        scanf("%d", &PR2);
        printf("\nInsert the grade in Final Exam: ");
        scanf("%d", &FEXGR);

    } while (number_of_absences < 0 && PR1 < 0 && PR2 < 0 && FEXGR < 0);

    int A;

    if (number_of_absences == 0)
    {
        A = 10;

    }else if (number_of_absences == 1)
    {
        A = 5;

    }else
    {
        
        A = 0;
        
    }
    
    double GRL = A*0.2 + PR1*0.4 + PR2*0.4;
    
    if (GRL < 4.5)
    {
        
        printf("Failed in Laboratory Exercises");
        exit(0);

    }
    
    if (FEXGR < 4.5)
    {
         printf("Failed in Final Exam");
         exit(0);

    }

    double FinalGrade = GRL * 0.5 + FEXGR * 0.5;
    printf("\nSuccess!\n You have passed the Course (MYY502) SYSTEMS PROGRAMMING!\n Your grade is %f", FinalGrade);

}