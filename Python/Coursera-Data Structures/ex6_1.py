name = input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)
dictionary = dict()
time = None
hour=None
for line in handle:
    line=line.rstrip()
    if not line.startswith('From '):continue
    words=line.split()
    time = words[5].split(':')
    hour = time[0]
    dictionary[hour]=dictionary.get(hour,0)+1
lst =sorted([(k,v) for k,v in dictionary.items()])
for k,v in lst:
	print(k,v)