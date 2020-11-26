#include <stdio.h>

int *search(int array[], int size, int num);  /* prototype */


int main(void)
{

    int A[10] = {0, 4, 8, 2, -2, 100, 45, -12, 45, 31};
    int *key;
    key = search(A,10,100);

    if (key != NULL){
        
        printf("key element: %d\n", *key);
        printf("key position in the matrix: %d", key-A);

    }
    else{

        printf("The element you're searching for doesn't exist");

    }
    
    return 0;

}


int *search(int matrix[], int size, int number){

    for (int i = 0; i < size; i++){

        if (matrix[i] == number){

            return &(matrix[i]);

        }
        
    }
    
    return NULL;

}