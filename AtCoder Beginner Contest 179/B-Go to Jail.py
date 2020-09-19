N=int(input())
arr=[[-1 for j in range(2)] for i in range(N)]
for i in range(N):
	arr[i][0],arr[i][1]=map(int,input().split())
cnt=0
for i in range(N-2):
	if arr[i][0]==arr[i][1] and arr[i+1][0]==arr[i+1][1] and arr[i+2][0]==arr[i+2][1]:
		cnt+=1
if cnt>0:
	print("Yes")
else:
	print("No")
