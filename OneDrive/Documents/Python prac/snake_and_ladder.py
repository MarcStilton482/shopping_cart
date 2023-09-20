# -*- coding: utf-8 -*-
"""
Created on Sun Sep 10 13:31:53 2023

@author: Marc
"""
from PIL import Image
import random
end = 100
def show_board():
    img=Image.open('slb.png')
    img.show()
def check_ladder(points):
    if points == 1:
        print('Ladder ')
        return 38
    elif points == 4:
        print('Ladder ')
        return 14
    elif points == 9:
        print('Ladder ')
        return 31
    elif points == 51:
        print('Ladder ')
        return 67
    elif points == 21:
        print('Ladder ')
        return 42
    elif points == 28:
        print('Ladder ')
        return 84
    elif points == 72:
        print('Ladder ')
        return 91
    elif points == 80:
        print('Ladder ')
        return 99
    else:
        return points
def check_snake(points):
    if points == 17:
        print('Snake ')
        return 7
    elif points == 62:
        print('Snake ')
        return 19
    elif points == 54:
        print('Snake ')
        return 34
    elif points == 64:
        print('Snake ')
        return 60
    elif points == 87:
        print('Snake ')
        return 36
    elif points == 93:
        print('Snake ')
        return 73
    elif points == 95:
        print('Snake ')
        return 75
    elif points == 98:
        print('Snake ')
        return 79
    else:
        return points
def reached_end(points):
    if points == end:
        return True
    else:
        return False
    
    
    

def play():
    p1_name = input('Player 1, enter your name: ')
    p2_name = input('Player 2, enter your name: ')
    pp1 = 0
    pp2 = 0
    turn = 0
    while(1):
        if turn % 2 == 0:
            print(p1_name,' your turn ')
            c = input('Press 1 to continue and 0 to quit ')
            if c==0:
                print(p1_name,' scored ',pp1)
                print(p2_name,' scored ',pp2)
                print('Quitting the game, Thanks for playing')
                break
            dice = random.randint(1,6)
            print('dice showed: ',dice)
            pp1 = pp1 + dice
            pp1 = check_ladder(pp1)
            pp1 = check_snake(pp1)
            
            if pp1>end:
                pp1 = end
            print(p1_name, ' score ',pp1)
            if reached_end(pp1):
                print(p1_name,' won')
                break
        else:
            print(p2_name,' your turn ')
            c = input('Press 1 to continue and 0 to quit ')
            if c==0:
                print(p1_name,' scored ',pp1)
                print(p2_name,' scored ',pp2)
                print('Quitting the game, Thanks for playing')
                break
            dice = random.randint(1,6)
            print('dice showed: ',dice)
            pp2 = pp2 + dice
            pp2 = check_ladder(pp2)
            pp2 = check_snake(pp2)
            
            if pp2 > end:
                pp2 = end
            print(p2_name, ' scored ',pp2)
            if reached_end(pp2):
                print(p2_name,' won')
                break
        turn = turn + 1
show_board()    
play()