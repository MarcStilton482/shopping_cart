# -*- coding: utf-8 -*-
"""
Created on Tue Sep 12 07:04:16 2023

@author: Marc
"""
import turtle
from random import randint
turtle.bgcolor("black")
ser = turtle.Turtle()
width = 5
height = 7
dot_distace = 25
ser.penup()
list_color=["red","white","blue","yellow","orange","green","brown","grey","purple"]
ser.setpos(-250,250)

def spiral(m, n):
    k=0
    l=0
    f=0
    col=randint(0,8)
    ser.color(list_color[col])
    while (k<m and l<n):
        if (f==1):
            ser.right(90)
        for i in range(l,n):
            ser.dot()
            ser.forward(dot_distace)
            # print(a[k][i], end=" ")
        k+=1
        f=1
        ser.right(90)
        col=randint(0,8)
        ser.color(list_color[col])
        for i in range(k,m):
            ser.dot()
            ser.forward(dot_distace)
            # print(a[i][n-1],end=" ")
        n-=1
        ser.right(90)
        if(k<m):
            col=randint(0,8)
            ser.color(list_color[col])
            for i in range(n-1,l-1,-1):
                ser.dot()
                ser.forward(dot_distace)
                # print(a[m-1][i],end=" ")
            m-=1
        ser.right(90)
        if(l<n):
            col=randint(0,8)
            ser.color(list_color[col])
            for i in range(m-1,k-1,-1):
                ser.dot()
                ser.forward(dot_distace)    
                # print(a[i][l], end=" ")
            l+=1
            
spiral(20,20)
turtle.done
        