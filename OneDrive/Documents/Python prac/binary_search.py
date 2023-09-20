def binary_search(b,p):
    first_pos = 0
    
   
    last_pos = len(b)-1
    flag=0
    count=0
    
    while(first_pos<=last_pos and flag==0):
        mid = (first_pos+last_pos)//2
        if(p==b[mid]):
            print("Number found at "+str(mid)+" after "+str(count)+" iterations")
            flag=1
            break
        else:
            if(p>b[mid]):
                first_pos = mid+1
                count+=1
            elif(p<b[mid]):
                last_pos = mid-1
                count+=1
    if(flag==0):
        print('Number is not present')
        
b = []
j = int(input('Enter number you want to search from: '))
k = int(input('Enter number you want to search till: '))
l = int(input('Enter number you want to search : '))
for i in range(j,k):
    b.append(i)
    
binary_search(b, l)