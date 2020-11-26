#include <stdio.h>
int main()//int argc, char const *argv[])
{
    int a[10] = {0, 2, 4, 6, 8, 7, 6, 4, 2, 0};
	int *pa = &a[1], *pb = &a[8], *pc= &a[0];

    printf("1.3 pc= %d", *pc);   
    return 0;
    
}
