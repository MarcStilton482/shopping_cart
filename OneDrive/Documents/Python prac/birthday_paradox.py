# -*- coding: utf-8 -*-
"""
Created on Sun Aug 20 10:40:49 2023

@author: Marc
"""
import random
import datetime
birthday=[]
i=0
while(i<50):
    year = random.randint(1994,2022)
    print(year)
    if(year % 4==0 and year % 100!=0 or year % 400==0):
        leap=1
    else:
        leap=0
    month=random.randint(1,12)
    if(month == 2 and leap == 1):
        day=random.randint(1,29)
    elif(month == 2 and leap == 0):
        day=random.randint(1,28)
    elif(month == 7 or month == 8):
        day=random.randint(1,31)
    elif(month % 2==0 and month < 7):
        day=random.randint(1,30)
    elif(month % 2!=0 and month >7):
        day=random.randint(1,30)
    else:
        day=random.randint(1,30)
    dd=datetime.date(year,month,day)
    day_of_year=dd.timetuple().tm_yday
    i=i+1
    birthday.append(day_of_year)
birthday.sort()
i=0
while(i<50):
    print(birthday[i])
    i=i+1
    # print("Number of birthday twins...")
    # count = 0 
    # j=0  
    # for i in range(50):
    #     while(j<i):
    #         if(birthday[i] == birthday [j]):
    #             count = count+1
    #             print(count)
    #             j=j+1
                
    # print("No. of birthday Twins fornd are ",count)
                
