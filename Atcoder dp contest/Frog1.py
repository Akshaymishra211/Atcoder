'''
                        *             * * * * * * * *
                        *             *
                        *             *
                        *             *
                        *             *
                        *             *
                        *             *
                        * * * * * * * * * * * * * * *
                                      *             *
                                      *             *
                                      *             *
                                      *             *
                                      *             *
                                      *             *
                        * * * * * * * *             *

'''
import sys
sys.setrecursionlimit(10**7)
dp=[-1]*(10**5+2)
def frog(arr,N):
    if N==0:
        dp[0]=0
        return dp[0]
    elif N==1:
        dp[1]=abs(arr[1]-arr[0])
        return dp[1]
    elif N==2:
        dp[2]=min(frog(arr,N-1)+abs(arr[N]-arr[N-1]),abs(arr[N]-arr[N-2]))
        return dp[2]
    else:
        if dp[N]!=-1:
            return dp[N]
        dp[N]=min(frog(arr,N-2)+abs(arr[N]-arr[N-2]),frog(arr,N-1)+abs(arr[N]-arr[N-1]))
        return dp[N]
if __name__ == "__main__":
    N=int(input())
    h=[int(i) for i in input().split()][:N]
    frog(h,N-1)
    print(dp[N-1])
