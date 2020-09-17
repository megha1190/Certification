text = "X-DSPAM-Confidence:    0.8475";
x=text.find('0')
y=text.find('5',x)
strNumber= text[x:]
print(float(strNumber))