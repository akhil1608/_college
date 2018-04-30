# Open the mapout file with (key,value) pairs
file = open("mapout.txt","r")
product = {}
for line in file:
	l = line.split(",")
	k = int(l[0]) # key
	v = int(l[1]) # value
	if k not in product:
		product[k] = v;
	else:
		product[k] += v;
file.close()
# Save the result of matrix-vector multiplication
file = open("output.txt","w")
for k,v in product.items():
	file.write(str(k)+","+str(v)+"\n")
file.close()