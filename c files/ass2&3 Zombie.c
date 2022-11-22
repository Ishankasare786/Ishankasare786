#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>

int main()
{
int pid;
printf("Current Process ID is: %d\n", pid);
printf("[Forking Child Process ... ]\n");
pid=fork();

if(pid < 0)
	{
		printf("Process can not br cretaed");
 	}
if(pid > 0)
	{
		printf("Parent Process is Sleeping ...");
		sleep(5);
		printf("\nID : %d", getppid());
 	}
else
	{
		exit(0);
	}
return 0;
}
