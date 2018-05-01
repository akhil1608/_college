#!/bin/bash
a=$1
op=$2
b=$3
if [ $# -ne 3 ]; then
echo "Wrong Input"
else 
if [ $op = + ]; then
echo "$a + $b is $(($a+$b))"
fi
if [ $op = - ]; then
echo "$a - $b is $(($a-$b))"
fi
if [ $op = x ]; then
echo "$a * $b is $(($a*$b))"
fi
if [ $op = / ]; then
echo "$a / $b is $(($a/$b))"
fi
if [ $op = % ]; then
echo "$a % $b is $(($a%$b))"
fi
fi