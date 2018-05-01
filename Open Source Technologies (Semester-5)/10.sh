#!/bin/bash
echo "Enter n"
read n
echo "Menu."
echo "1. Break 2. Continue 3. Until"
read ch
case $ch in
1) for ((i=1;i<=$n;i++))
do
if [ $i -eq $((n/2+1)) ]; then
break
else
echo -n "$i "
fi
done;;
2) for ((i=1;i<=$n;i++))
do
if [ $(($i%2)) -eq 0 ]; then
echo -n "$i "
else
continue
fi
done;;
3) i=1 
until [ ! $i -le $n ]
do
echo "$i "
i=`expr $i + 1` 
done;;
*) echo "Wrong Input";;
esac
echo ""