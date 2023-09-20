# -*- coding: utf-8 -*-
"""
Created on Tue Aug 22 05:50:01 2023

@author: Marc
"""
import random
movies = ['The Shawshank Redemption','Inception','The Godfather','Pulp Fiction','The Dark Knight','Forrest Gump','The Matrix','Fight Club','Star Wars A New Hope','The Lord of the Rings: The Return of the King','Jurassic Park','Avatar','Harry Potter and the Sorcerers Stone','E.T. the Extra-Terrestrial','The Lion King','Titanic','Indiana Jones and the Raiders of the Lost Ark','Back to the Future','The Avengers','The Social Network'
]
def create_question(movie):
    n=len(movie)
    letters=list(movie)
    temp=[]
    for i in range (n):
        if letters[i]==' ':
            temp.append(' ')
        else:
            temp.append('*')
    qn=''.join(str(x) for x in temp)
    return qn
def is_present(letter,movie):
    c=movie.count(letter)
    if c==0:
        return False
    else:
        return True
def unlock(qn,movie,letter):
    ref=list(movie)
    qn_list = list(qn)
    temp=[]
    n=len(movie)
    for i in range(n):
        if ref[i] ==' ' or ref[i]==letter:
            temp.append(ref[i])
        else:
            if qn_list[i]    == '*':
                temp.append('*')
            else :
                temp.append(ref[i])
    qn_new=''.join(str(x) for x in temp)
    return qn_new
def play():
    p1name=input("Player1: Enter your name ")
    p2name=input("Player2: Enter your name ")
    pp1=0
    pp2=0
    turns=0
    willings=True
    while willings:
        if(turns%2==0):
            print("Player 1 your turn: ")
            picked_movie = random.choice(movies)
            qn=create_question(picked_movie)
            print(qn)
            modified_qn = qn
            not_said=True
            while not_said:
                letter=input("Enter your letter: ")
                if(is_present(letter,picked_movie)):
                    modified_qn=unlock(modified_qn,picked_movie,letter )
                    print(modified_qn)
                    d=input("Press 1 to guess the movie name and 2 to unlock another letter: ")
                    if d==1:
                        ans=input("Answer :")
                        if ans==picked_movie:
                            pp1=pp1+1
                            print("correct!")
                            not_said=False
                            print(p1name," Your score: ",pp1)
                        else:
                            print("Wrong answer, Try Again.")
                else:
                    print("Letter not present.")
            c=input("Press 1 to continue and 0 to quit")
            if(c==0):
                print(p1name, "Your score: ", pp1)
                print(p2name, "Your score: ", pp2)
                print("Thank You for playing")
                willings=False
                
        else:
            print("Player 1 your turn: ")
            picked_movie = random.choice(movies)
            create_question(picked_movie)
            print(qn)
            modified_qn = qn
            not_said=True
            while not_said:
                letter=input("Enter your letter: ")
                if(is_present(letter,picked_movie)):
                    modified_qn=unlock(modified_qn,picked_movie,letter )
                    print(modified_qn)
                    d=input("Press 1 to guess the movie name and 2 to unlock another letter: ")
                    if(d==1):
                        ans=input("Answer :")
                        if ans==picked_movie:
                            pp2=pp2+1
                            print("correct!")
                            not_said=False
                            print(p2name," Your score: ",pp2)
                        else:
                            print("Wrong answer, Try Again.")
                else:
                    print("Letter not present.")
            c=input("Press 1 to continue and 0 to quit")
            if(c==0):
                print(p1name, "Your score: ", pp1)
                print(p2name, "Your score: ", pp2)
                print("Thank You for playing")
                willings=False
            
        turns=turns+1
play()               
        