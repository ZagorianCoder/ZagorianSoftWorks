#include <stdio.h>
int main()//int argc, char const *argv[])
{
    int a[10] = {0, 2, 4, 6, 8, 7, 6, 4, 2, 0};
	int *pa = &a[1], *pb = &a[8], *pc;

	printf("4.2       pb[1] = %d\n", pb[1]);
	printf("5.2     *(pa += 3) = %d\n", *(pa += 3));
	printf("6.2   pb -= 3 = %p\n", pb -= 3);    
    return 0;

}
