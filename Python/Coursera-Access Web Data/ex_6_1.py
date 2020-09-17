import json
from urllib.request import urlopen
import ssl

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

#http://py4e-data.dr-chuck.net/comments_728488.json
url = input('Enter URL:')
data = urlopen(url, context=ctx).read()
try:
    info = json.loads(data)
except:
    info = None
print('Coments count:', len(info))
total = 0
for item in info["comments"]:
    total = total + int(item['count'])
print(total)