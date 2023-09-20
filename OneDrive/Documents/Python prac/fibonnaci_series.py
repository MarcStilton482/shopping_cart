# -*- coding: utf-8 -*-
"""
Created on Wed Sep  6 07:58:46 2023

@author: Marc
"""

def fib(n):
    if n < 2:
        return n
    else:
        return (fib(n-1) + fib(n-2))
k = int(input("Enter a non negative number to find required fibonnaci series: "))
if k < 0 :
    print("Not defined for negative numbers")
else:
    print("Fibbonaci series of element ",k," is ",fib(k))
    