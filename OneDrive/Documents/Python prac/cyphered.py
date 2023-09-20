# -*- coding: utf-8 -*-
"""
Created on Sat Sep  2 09:55:09 2023

@author: Marc
"""

import string
dict = {}
data=""
file=open("Cy.txt","w")
for i in range(len(string.ascii_letters)):
    dict[string.ascii_letters[i]]=string.ascii_letters[i-6]
print(dict)
with open("crypt.txt") as f:
    while True:
        c=f.read(1)
        if not c:
            print("End of file")
            break
        if c in dict:
            data = dict[c]
        else :
            data = c
        file.write(data)
        print (data)
file.close()
        
            
            
        