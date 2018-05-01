#!/bin/bash
for ((i=1;i<=5;i++))
  do
   if [ $i -le 3 ]
   then
   for ((j=1;j<=i;j++))
     do
       echo -n "#"
     done
   else
   for ((j=i;j<=5;j++))
     do
       echo -n "#"
     done
   fi
   echo ""
  done
echo ""
for ((i=0;i<=5;i++))
  do
    for((j=5;j>=5-i;j--))
       do
          echo -n "$j"
       done
    echo ""
  done
echo ""
for ((i=1;i<=5;i++))
  do
   for ((j=1;j<=i;j++))
     do
       if [ $j -eq 1 ]
       then
       echo -n "unix "
       else
       echo -n "linux " 
       fi
     done
   echo ""
  done
echo ""
echo "Enter your name"; read n
for ((i=1;i<=5;i++))
  do
    for((j=1;j<=i;j++))
       do
          echo -n "*$n"
       done
    echo -ne "*\n"
  done