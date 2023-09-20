def linear_search(n,a,x):
    element = []
    for i in range(n,a):
        element.append(i)
    count = 0
    flag = 0
    for i in element:
        count+=1
        if (i==x):
            print('Number found , at position '+str(i))
            flag=1
            break
    if(flag==0):
        print('Number not found')
    print('Number of iterations: '+str(count))
j = int(input('Enter number you want to search from: '))
k = int(input('Enter number you want to search till: '))
l = int(input('Enter number you want to search : '))
linear_search(j, k, l)