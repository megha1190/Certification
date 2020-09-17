def computepay(h,r):
	if(h<=40):
		return h*r
	elif(h>40):
		d= h-40
		return (40.0*r + d*1.5 *r)
hrs = input("Enter Hours:")
h = float(hrs)
rate = input("Enter rate :")
r = float(rate)
p = computepay(h,r)
print("Pay",p)