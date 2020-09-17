from urllib.request import urlopen
import ssl
import xml.etree.ElementTree as ET

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

#url = 'http://py4e-data.dr-chuck.net/known_by_Fikret.html'
url = input('Enter URL:')
html = urlopen(url, context=ctx).read()
tree= ET.fromstring(html)
list = tree.findall('comments/comment')
print('List count = ',len(list))
count = 0
for item in list:
    count = count + int(item.find('count').text)
print(count)