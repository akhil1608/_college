import numpy as np
n = int(input("Enter n = "))
m = np.empty([n,n])
print("Type 1 if link exists else 0")
for i in range(n):
    sum = 0
    for j in range (n):
   	 m[i][j] = input(str(i+1)+" to "+str(j+1)+" = ")
   	 sum += m[i][j]
    if sum!=0:    
   	 m[i] /= sum
m = m.transpose()
v = np.ones(n)/n
k = input("Enter iterations = ")
print("M = ")
print(m)
print("V0 = "+str(v))
for i in range(k):
    v = np.dot(m,v)
    print("V"+str(i+1)+" = "+str(v))
print("Page Rank (out of 10) after "+str(k)+" iterations")
for i in range(k):
    print(str(i+1)+": "+str(v[i]*10))
