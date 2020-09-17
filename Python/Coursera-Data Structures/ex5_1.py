name = input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)
dictionary = dict()
senderName = None
sendercount=None
for line in handle:
    line=line.rstrip()
    if not line.startswith('From '):continue
    words=line.split()
    dictionary[words[1]]=dictionary.get(words[1],0)+1
for word,count in dictionary.items():
    if sendercount is None or count > sendercount:
        sendercount=count
        senderName=word
print(senderName,sendercount)
