# -*- coding: utf-8 -*-
"""
Created on Wed Sep  6 07:29:40 2023

@author: Marc
"""
def rec_fact(n):
    if n == 1:
        return 1
    elif n>1:
        return (n*rec_fact(n-1))
    else:
        print("Invalid input")
def itr_fact(n):
    
        product = 1
    
        
        for j in range(1,n+1):
            product = product * j
        return product
        if n<1:
            print("Invalid input")
    
k = int(input("1.Recursion \n 2.Iteration \n"))       
if k==2:
    i = int(input("Enter number whose factorial you want to find: "))
    print("Answer : ",rec_fact(i))
elif k==1:
    j = int(input("Enter number whose factorial you want to find: "))
    f = itr_fact(j)
    print("Answer : ",f)
else:
    print("Invalid Input from menu")