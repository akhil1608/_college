m = int(input("Number of rows in the first matrix = "))
n = int(input("Number of columns in the first matrix = "))
o = int(input("Number of columns in the second matrix = "))
# not asking for rows because the rows of second matrix must match the columns of the first
# define a 2D list with m rows and n columns per row to represent the first matrix
matrix1 = [[0 for i in range(n)] for j in range(m)]
print("Enter the values of the first matrix")
for i in range(m):
    for j in range(n):
        matrix1[i][j] = int(input("Row "+str(i+1)+" Column "+str(j+1)+" = "))
# define a 2D list with n rows and o columns per row to represent the second matrix
matrix2 = [[0 for i in range(o)] for i in range(n)]
print("Enter the values of the second matrix")
for i in range(n):
    for j in range(o):
        matrix2[i][j] = int(input("Row "+str(i+1)+" Column "+str(j+1)+" = "))
# Create files to store the output of the mapping
file1 = open("matrixm.txt","w")
file2 = open("matrixn.txt","w")
# Store (key,value) pairs in the file
for j in range(n):
	for i in range(m):
		string = "("+str(j+1)+",(M,"+str(i+1)+","+str(matrix1[i][j])+"))\n"
		file1.write(string)
for j in range(n):
	for k in range(o):
		string = "("+str(j+1)+",(N,"+str(k+1)+","+str(matrix2[j][k])+"))\n"
		file2.write(string)
file1.close()
file2.close()