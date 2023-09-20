# -*- coding: utf-8 -*-
"""
Created on Sat Aug 12 10:18:22 2023

@author: Marc
"""

d = int(input("Enter a number: "))
for i in range(1,d+1):
    if (i%3==0 and i%15 != 0):
      print(str(i),"= Fizz")
    else:
        if (i%5==0 and i%15 != 0):
          print(str(i),"= Buzz")
        else:
            if (i%3==0 and i%5==0):
              print(str(i),"= FizzBuzz")
            else:
              print(str(i))