#!/bin/sh
INPUT="./input.txt"
FREQ_START=0
FIRST_REP=0
i=1

while [ $FIRST_REP = 0 ]
do
  while read value
  do
    FREQ_START=$((value + FREQ_START))
    if [ -e "hash_$FREQ_START" ]
    then
      #The whole last interation will match. Only register the first match.
      if [ $FIRST_REP = 0 ]
      then
        FIRST_REP=$FREQ_START
        echo "A2:$FIRST_REP"
      fi
    fi
    #Wanna stress the HDD?
    touch "hash_$FREQ_START"
  done < input.txt
  #Only print the result from the first iteration
  if [ $i = 1 ]
  then
    echo "A1:$FREQ_START"
  fi
  i=$((i + 1))
done

#The cleaning lady ;)
y=10
while [ $y -lt 100 ]
do
  rm hash_$y*
  y=$((y + 1))
done
rm hash_*
