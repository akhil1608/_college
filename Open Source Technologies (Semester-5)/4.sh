#!/bin/bash
echo "Enter year"; read y
cy=`date +'%Y'`
if [ $((y%4)) -eq 0 ]
then
echo "$y is a leap year"
else
echo "$y is not a leap year"
fi
if [ $((cy%4)) -eq 0 ]
then
echo "$cy is a leap year"
else
echo "$cy is not a leap year"
fi