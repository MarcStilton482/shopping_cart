# -*- coding: utf-8 -*-
"""
Created on Mon Aug 28 06:39:34 2023

@author: Marc
"""

import random
door = [0]*3
goatdoor = [0]*2
swap=0
dont_swap=0
j=0
while(j<10):
    x=random.randint(0,2)
    door[x]="Mercedes"
    for i in range(0,3) :
        if(i==x):
            continue
        else :
            door[i] = "Goat"
            goatdoor.append(i)
    choice=int(input("Enter your choice: "))
    door_open=random.choice(goatdoor)
    while(door_open==choice):
        door_open=random.choice(goatdoor)
    ch = input("Do you want to swap Y/N ?")
    if(ch=='Y'):
        if (door [choice]=='Goat'):
            print('Player won')
            swap=swap+1
        else:
            print("Player lost")
    else:
        if (door [choice]=='Goat'):
            print('Player lost')
        else:
            print("Player won")
            dont_swap=dont_swap+1
    j=j+1
print("Number of swaps won: ",swap)

print("Number of no swaps won: ",dont_swap)