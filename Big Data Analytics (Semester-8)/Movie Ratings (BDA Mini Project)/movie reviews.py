import matplotlib.pyplot as plt
# initialize
file = open("ratings_small2.csv","r")
i = 0
userid = 0
underage = 0
occupation = 0
oc = input("Enter occupation: ")
movies = dict()
users = dict()
# read contents of the csv file
for line in file:
	if i == 0:
		i = 1
		continue
	l = line.rstrip().split(",")
	# count underage users
	if int(l[0])!=userid:
		age = int(l[4])
		if age<=18:
			underage += 1
		userid = int(l[0])
	# count number of movies rated by occupation
	if l[5] == oc:
		if l[1] not in movies:
			occupation += 1
			movies[l[1]] = 1
	# add user, review count
	if userid in users:
		users[userid] += 1
	else:
		users[userid] = 1
# calculate output
most = max(users, key=users.get)
least = min(users, key=users.get)
print("User ID with most ratings: "+str(most)+", Number of movies rated: "+str(users[most]))
print("User ID with least ratings: "+str(least)+", Number of movies rated: "+str(users[least]))
print("Number of movies rated by "+oc+"s: "+str(occupation))
print("Number of underage users: "+str(underage))
# plot graph
plt.title("User v Reviews")
plt.xlabel("User Id")
plt.ylabel("No. of Reviews")
for i in users:
	if i==most:
		plt.plot(i,users[i],"g*")
	elif i==least:
		plt.plot(i,users[i],"r*")
	else:
		plt.plot(i,users[i],"bo")
plt.show()