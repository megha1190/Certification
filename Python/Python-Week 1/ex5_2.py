score = input("Enter Score: ")
try:
	sc= float(score)
except:
    print('please enter proper score between 0.0 and 1.0')

if(sc>=0.9):
	print('A')
elif(sc>=0.8):
	print('B')   
elif(sc>=0.7):
	print('C')
elif(sc>=0.6):
	print('D')
elif(sc<0.6):
	print('F')
else:
	print('please enter proper score between 0.0 and 1.0')
	quit()