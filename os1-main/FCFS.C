#include <stdio.h>
int main()
{
    // count is page fault
    // n is number of pages
    // a[] is page number
    //  no is number of frames
    // frame[] frame array
    int i, j, n, a[50], frame[10], no, k, avail, count = 0; // aji fnck a2 n2
    printf("\n ENTER THE NUMBER OF PAGES:\n");
    scanf("%d", &n);
    printf("\n ENTER THE PAGE NUMBER :\n");
    for (i = 1; i <= n; i++)
    {
        scanf("%d", &a[i]);
    }
    printf("\n ENTER THE NUMBER OF FRAMES :");
    scanf("%d", &no);
    for (i = 0; i < no; i++)
    {
        frame[i] = -1;
    }
    j = 0; // position of frame
    printf("\tref string\t page frames\n");
    for (i = 1; i <= n; i++)
    {
        printf("%d\t\t", a[i]);
        avail = 0;
        for (k = 0; k < no; k++) // if page is already present in the frame
        {
            if (frame[k] == a[i])
            {
                avail = 1;
            }
        }
        if (avail == 0)
        {
            frame[j] = a[i];
            j = (j + 1) % no;
            count++;
            for (k = 0; k < no; k++)
            {
                printf("%d\t", frame[k]);
            }
        }
        printf("\n");
    }
    printf("Page Fault Is %d", count);
    return 0;
}