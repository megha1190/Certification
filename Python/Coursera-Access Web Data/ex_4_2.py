from urllib.request import urlopen
from bs4 import BeautifulSoup
import ssl

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

#url = 'http://py4e-data.dr-chuck.net/known_by_Fikret.html'
url = input('Enter URL:')
count = int(input('Enter count:'))
position = int(input('Enter position:'))-1

html = urlopen(url, context=ctx).read()
soup = BeautifulSoup(html, "html.parser")

href = soup('a')
#print href

for i in range(count):
    link = href[position].get('href', None)
    #print(href[position].contents[0])
    lastname= href[position].contents[0]
    html = urlopen(link).read()
    soup = BeautifulSoup(html,"html.parser")
    href = soup('a')
print(lastname)