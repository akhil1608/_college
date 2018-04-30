m = int(input("Number of rows in the matrix = "))
n = int(input("Number of columns in the matrix = "))
# define a 2D list with m rows and n columns per row to represent the matrix
matrix = [[0 for i in range(n)] for j in range(m)]
print("Enter the values of the matrix")
for i in range(m):
    for j in range(n):
        matrix[i][j] = int(input("Row "+str(i+1)+" Column "+str(j+1)+" = "))
# define a 1D list to represent the vector with n rows
vector = [0 for i in range(n)]
print("Enter the values of the vector")
for i in range(n):
    vector[i] = int(input("Row "+str(i+1)+" = "))
# Create a file to store the output of the mapping
file = open("mapout.txt","w")
# Store (key,value) pairs in the file
for i in range(m):
    for j in range(n):
        key = i+1
        value = matrix[i][j]*vector[j]
        file.write(str(key)+","+str(value)+"\n")
file.close()