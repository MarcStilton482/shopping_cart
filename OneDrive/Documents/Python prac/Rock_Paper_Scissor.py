# -*- coding: utf-8 -*-
"""
Created on Mon Aug 28 13:46:40 2023

@author: Marc
"""
def rock_paper_scissor(num1,num2,bit1,bit2):
    p1=int(num1[bit1])%3
    p2=int(num2[bit2])%3
    if(player_one[p1]==player_two[p2]):
       print("Draw")
    elif(player_one[p1]=='Rock' and player_two[p2]=='Scissor'):
        print("Player one wins")
    elif(player_one[p1]=='Paper' and player_two[p2]=='Scissor'):
        print("Player two wins")
    elif(player_one[p1]=='Rock' and player_two[p2]=='Paper'):
        print("Player two wins")
    elif(player_one[p1]=='Scizzor' and player_two[p2]=='Paper'):
        print("Player one wins")
    elif(player_one[p1]=='Paper' and player_two[p2]=='Rock'):
        print("Player one wins")
    else:
        print("Player two wins")
    
player_one = {0:'Rock', 1:'Paper', 2:'Scissor'}
player_two = {0: 'Paper', 1:'Rock', 2: 'Scissor'}
while(1):
    num1=input("Player one enter your choice: ")
    num2=input("Player two enter your choice: ")
    bit1=int(input("Enter your secret bit position P1: "))
    bit2=int(input("Enter your secret bot position P2: "))
    rock_paper_scissor(num1, num2, bit1, bit2)
    ch = input("Do you want to continue Y/N?")
    if(ch=='N'):
        break