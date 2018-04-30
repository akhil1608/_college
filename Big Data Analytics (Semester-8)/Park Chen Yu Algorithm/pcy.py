import itertools as itr, numpy as np

def pairs(l):
	cart = itr.product(l,l) # cartesian product
	pairs = [item for item in cart if item[0]!=item[1] and item[0]<item[1]] # removes (i,i) and (j,i) pairs
	return pairs

f = open("basket.txt")
b = input("Number of buckets = ")
s = input("Minimum support = ")
buckets = np.zeros(b,dtype="int")
items = {}
pair = {}
# pass 1
for line in f:
	l = line.rstrip().split(",")
	l = map(int,l)
	# count the items
	for k in l:
		if k in items:
			items[k] += 1
		else:
			items[k] = 1
	# assign buckets and count the pairs
	p1 = pairs(l)
	for k in p1:
		K = (k[0]+k[1])%b
		buckets[K] += 1
		if k in pair:
			pair[k] += 1
		else:
			pair[k] = 1
print("\nAfter Pass 1:")
print("Item\tCount")
for i in items:
	print(str(i)+"\t"+str(items[i]))
print("Pair\tCount")
for i in pair:
	print(str(i)+"\t"+str(pair[i]))
print("Bucket\tCount")
for i in range(b):
	print(str(i)+"\t"+str(buckets[i]))
# pass 2
# remove all items with count less than minimum support
freq_items = [key for key in items if items[key]>=s]
# remove all buckets with count less than minimum support
freq_buckets = [bucket for bucket in range(b) if buckets[bucket]>=s]
p2 = pairs(freq_items) # generate pairs of frequent items
# remove all pairs with count less than support or not in frequent bucket
freq_pairs = [p for p in p2 if (p[0]+p[1])%b in freq_buckets and pair[p]>=s] 
freq_itemsets = []
freq_itemsets.extend(freq_items)
freq_itemsets.extend(freq_pairs)
print("\nAfter Pass 2:")
print("FreqItem\tCount")
for i in freq_items:
	print(str(i)+"\t\t"+str(items[i]))
print("FreqPair\tCount")
for i in freq_pairs:
	print(str(i)+"\t\t"+str(pair[i]))
print("FreqBucket\tCount")
for i in freq_buckets:
	print(str(i)+"\t\t"+str(buckets[i]))
print("\nThe frequent itemsets are : "+str(freq_itemsets))