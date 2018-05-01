#!/bin/bash
echo "Enter n"; read n
let s=0
for ((i=1;i<=$n;i++))
    do
       let s=s+i
    done
echo "Sum of first $n numbers is $s"