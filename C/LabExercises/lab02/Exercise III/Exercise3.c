#include <stdio.h>
double minmaxavg(double array[], int num, double *max, double *min);

int main(){
    
    double A[10] = {0.2, 4.6, 8.4, 2.5, -0.2, 100.2, 45.3, -12.5, 45.77, 31.2};
    double min, max, avg;
    avg = minmaxavg(A, 10, &max, &min);
    printf("Max Element: %.2lf\n", max);
    printf("Min Element: %.2lf\n", min);
    printf("Average of Matrix Elements: %.2lf", avg);

    return 0;
}

double minmaxavg(double array[], int num, double *max, double *min){
    *min = array[0];
    *max = array[0];
    double sum = array[0];

    for (size_t i = 0; i < num; i++)
    {
        if (array[i] < *min)
        {
            
            *min = array[i];

        }
        else if (array[i] > *max)
        {

            *max = array[i];

        }
        sum += array[i];
        
    }
    return sum/(double)num;
    
}