import math as m
def fm(n):
	c = 0;
	binary = bin(int(n)) # inbuilt function to get binary string
	binary = binary[2:] # remove 0b from the start of the binary string
	b = int(binary)
	while b%2==0:
		c += 1
		b /= 10
	return int(binary), c

print("Enter hash equation: h(x) = (ax+b) mod c")
a = input("a = ")
b = input("b = ")
c = input("c = ")
n = input("Enter n = ")
s = []
h = []
bi = []
z = []
print("Enter sequence of "+str(n)+" numbers")
for i in range(n):
	s.append(input())
	h.append(((a*s[i])+b)%c);
	bb,zz = fm(h[i])
	bi.append(bb)
	z.append(zz)
print("S: "+str(s))
print("N: "+str(h))
print("b(N): "+str(bi))
print("r(a): "+str(z))
print("R: "+str(max(z)))