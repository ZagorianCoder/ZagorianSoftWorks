#include <stdio.h>
int main()//int argc, char const *argv[])
{
    int a[10] = {0, 2, 4, 6, 8, 7, 6, 4, 2, 0};
	int *pa = &a[1], *pb = &a[8], *pc;

	printf("1.     *(a + 6) = %d\n", *(a + 6));
	printf("2.      pb - pa = %ld\n", pb - pa);
	printf("3.        pb[1] = %d\n", pb[1]);
	printf("4.       &pb[1] = %p\n", &pb[1]);
	printf("5.     *pa += 3 = %d\n", *pa += 3);
	printf("6.   *(pb -= 3) = %d\n", *(pb -= 3));    
    return 0;
}
