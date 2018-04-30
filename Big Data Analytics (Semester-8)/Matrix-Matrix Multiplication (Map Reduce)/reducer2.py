file = open("reduceout.txt","r")
product = {}
for line in file:
	l = line[1:-2].split(",")
	i = int(l[0])
	j = int(l[1])
	val = int(l[2])
	if i not in product:
		product[i] = {}
		product[i][j] = val
	else:
		if j not in product[i]:
			product[i][j] = val
		else:
			product[i][j] += val
file.close()
# Save the result of matrix-matrix multiplication
file = open("output.txt","w")
for k1 in range(i):
	for k2 in range(j):
		file.write(str(k1)+","+str(k2)+","+str(product[k1+1][k2+1])+"\n")
file.close()