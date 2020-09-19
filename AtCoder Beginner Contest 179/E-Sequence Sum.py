from collections import defaultdict
N,X,M=map(int,input().split())
cnt=0
index=[X]
d=defaultdict(int)
i=1
while True:
	X=pow(X,2,M)
	if d[X]!=0:
		z=d[X]
		break
	d[X]=i
	i+=1
	index.append(X)
target=len(index)-z
total=0
for i in range(z,len(index)):
	total+=index[i]
for i in range(z):
	cnt+=index[i]
total2=0
for i in range(z,z+(N-z)%target):
	total2+=index[i]
cnt+=total*((N-z)//target)+total2
print(cnt)
