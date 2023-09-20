# -*- coding: utf-8 -*-
"""
Created on Wed Sep 20 10:56:42 2023

@author: Marc
"""

import random
import matplotlib.pyplot as plt

account=0
x=[]
y=[]
for i in range(7):
    x.append(i+1)
    bet=int(input("Yor bet: "))
    lucky_draw=random.randint(1,10)
    if (bet==lucky_draw):
       account=account+900-100
    else:
        account=account-100
    y.append(account)
print("Amount in lucky draw: ",account)
plt.plot(x,y)
plt.show()