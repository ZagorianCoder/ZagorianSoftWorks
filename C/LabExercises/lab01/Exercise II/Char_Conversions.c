#include <stdio.h>
#include <stdlib.h>


int main() 
{

    int char_counter = 1;
    char c;
    int lettersPosition[123]={0};
    int nums[30];
    int j= 1;
    int x= 0;
    for ( int i = 97; i < 123; i++)
    {
        lettersPosition[i] = j++;

    }
    
    do
    {
        printf("Give a Character:");
        scanf(" %s", &c);
        printf("");
        char_counter ++;
        if (isupper(c))
        {
            char capitalC = tolower(c);
            printf("The lowercase of %c is %c\n",c,capitalC);

        }else if (islower(c))
        {
               int asciiChar = (int)c;
               printf("The position of %c in alphabet is %d\n",c,lettersPosition[asciiChar]);
            
        }else if (isdigit(c))
        {

            nums[x++]= c - '0';

        }
        else
        {

            printf("You gave %c as a character\n",c);

        }
        
        
        
        
        

    } while (c != '$' && char_counter <= 30);
    if (x != 0)
    {
        for (int i = 0; i < x; i++)
        {
            printf("nums[%d]= %d\n",i,nums[i]);
        }

    }

}