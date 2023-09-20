# -*- coding: utf-8 -*-
"""
Created on Tue Aug 15 08:44:37 2023

@author: Marc
"""
import random
def choose():
    words = ( 'Apple','Banana','Cucumber','Delightful','Energetic','Fantastic','Giraffe','Happiness','Illumination','Journey','Kangaroo','Lively','Mountain','Nurturing','Optimistic','Pineapple','Quirky','Radiant','Sunflower','Tiger')
    pick = random.choice(words)
    return pick
def jumble(word):
    j = "".join(random.sample(word,len(word)))
    return j
def thank(p1n,p2n,p1p,p2p):
    print(p1n,"Thanks for playing",p1p,"\n")
    print(p2n,"Thanks for playing",p2p,"\n")
    print("Thanks for playing!")

    
def play():
    
  p1name = input("Enter your name player 1\n")
  p2name = input("Enter your name Player 2\n")
  pp1 = 0
  pp2 = 0
  turn = 0
  while(1):
      picked_word=choose()
      qn=jumble(picked_word)
      print(qn)
      if turn % 2 == 0:
          print(p1name,",it's your turn\n")
          ans = input("What word have you thought of ?\n")
          if ans == picked_word:
              pp1=pp1+1
              print("Your points",p1name," :",pp1)
          else:
              print("Better luck next time, I thought of",picked_word,"\n")
              c = int(input("To continue press1 to exit press 0\n"))
              if c==0:
                  thank(p1name,p2name,pp1,pp2)
                  break
      else:
          print(p2name,",it's your turn\n")
          ans = input("What word have you thought of ?\n")
          if ans == picked_word:
              pp2=pp2+1
              print("Your points",p2name," :",pp2)
          else:
              print("Better luck next time, I thought of",picked_word+"\n")
              c = int(input("To continue press1 to exit press 0\n"))
              if c==0:
                  thank(p1name,p2name,pp1,pp2)
                  break
      turn=turn+1
play()
                  
      
              
              