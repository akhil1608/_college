#!/bin/bash
let x=10+10
echo -n "10 + 10 = "; echo $x
echo -n "10 * 10 = "; echo `expr 10 \* 10`
echo -n "10 - 10 = "; echo $((10-10))
echo -n "10 / 10 = "; echo $[ 10 / 10 ]