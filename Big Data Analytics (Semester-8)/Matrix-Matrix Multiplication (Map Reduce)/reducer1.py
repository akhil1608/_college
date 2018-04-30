file1 = open("matrixm.txt","r")
file2 = open("matrixn.txt","r")
a = {}
b = {}
# read contents of matrix M in a
for line in file1:
	l = line.split(",")
	i = int(l[2])
	j = int(l[0][1])
	val = int(l[3][:-3])
	if j not in a:
		a[j] = {}
		a[j][i] = val
	else:
		a[j][i] = val
# read contents of matrix N in b
for line in file2:
	l = line.split(",")
	j = int(l[0][1])
	k = int(l[2])
	val = int(l[3][:-3])
	if j not in b:
		b[j] = {}
		b[j][k] = val
	else:
		b[j][k] = val
file1.close()
file2.close()
# Create new file to write output of reducer 1
file = open("reduceout.txt","w")
for m in range(i):
	for o in range(k):
		key = "("+str(m+1)+","+str(o+1)+","
		for n in range(j):
			file.write(key+str(a[n+1][m+1]*b[n+1][o+1])+")\n")