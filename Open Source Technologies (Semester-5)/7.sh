#!/bin/bash
echo -e "enter a string a"
read a
echo -e "enter a string b"
read b
if [ $a = $b ]; then 
   echo -e "string a is equal to b"
else
   echo -e "string a is not equal to b"
fi
if [ -$a ]; then  
   echo -e "a is not empty"
else
   echo -e "a is empty"
fi 
if [ $b ]; then  
   echo -e "b is not empty"
else
   echo -e "b is empty"
fi 
echo -e "enter an integer c"
read c
echo -e "enter an integer d"
read d
if [ $c = $d ]; then 
   echo -e "c is equal to d"
else
   echo -e "c is not equal to d"
fi
if [ $c -gt $d ]; then 
   echo -e "c > d"
else
   echo -e "c < d"
fi
if [ $c -lt $d ]; then 
   echo -e "no d > c"
else
   echo -e "no d < c"
fi
if [ $c -ge $d ]; then 
   echo -e "c >= d"
else
   echo -e "c <= d"
fi
if [ $c -le $d ]; then 
   echo -e "no d >= c"
else
   echo -e "no d <= c"
fi
echo -e "enter a file name"
read fname 
if [ -e $fname ]; then 
   echo -e "file exists"
else
   echo -e "file doesn't exists"
fi
if [ -d $fname ]; then 
   echo -e "file is a directory"
else
   echo -e "file is not a directory"
fi
if [ -x $fname ]; then 
   echo -e "file is executable"
else
   echo -e "file is not executable"
fi
if [ -r $fname ]; then 
   echo -e "file is readable"
else
   echo -e "file is not readable"
fi
if [ -w $fname ]; then 
   echo -e "file is writeable"
else
   echo -e "file is not writeable"
fi