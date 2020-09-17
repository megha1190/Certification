# Use the file name mbox-short.txt as the file name
fname = input("Enter file name: ")
fh = open(fname)
count=0
total = 0.0;
for line in fh:
    if not line.startswith("X-DSPAM-Confidence:") : continue
    x=line.find('0')
    y=line.find('5',x)
    strNumber= line[x:]
    total = total+float(strNumber)
    count = count+1

print("Average spam confidence:",(total/count))
