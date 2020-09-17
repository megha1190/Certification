hrs = input("Enter Hours:")
h = float(hrs)
rate = input("Enter rate :")
r = float(rate)
if(h<=40):
	print(h*r)
elif(h>40):
	d= h-40
	print(40.0*r + d*1.5 *r)
else:
    print('wrong input')