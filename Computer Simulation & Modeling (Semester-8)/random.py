# program generates random numbers based on current time.
# please make sure to remove comments as it only used to make you understand the program.
import time, math
t = int(time.time())
t = t%1000 # last 3 digits
t = t*t # squared. just random shiz
n = int(input("Enter number of random numbers to be generated: "))
print("Enter range (r1-r2)")
r1 = int(input("r1 = "))
r2 = int(input("r2 = "))
random = [] # define list
k = 2
while len(random)!=n:
	r = int(math.log(t)*10000/math.log(k))%10000 # again random shiz. can use exp,sin etc. instead of log
	r = r%(r2-r1+1)+r1 # to fit into the range
	if r in random: # if it is already in the list update t
		t += 1
		continue
	k += 1
	random.append(r)
print("List of random numbers generated: "+str(random))