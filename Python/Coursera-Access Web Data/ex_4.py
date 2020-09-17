from urllib.request import urlopen

import unidecode as unidecode
from bs4 import BeautifulSoup
import ssl
import re

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url = input('Enter - ')
html = urlopen(url, context=ctx).read()
soup = BeautifulSoup(html, "html.parser")

total = 0;
# Retrieve all of the span tags
tags = soup('span')
for tag in tags:
    # Look at the parts of a tag
    #print('TAG:', tag)
    word = unidecode.unidecode(tag.contents[0])
    #print('Contents:', word)
    #assert isinstance(word, str)
    total= total+int(word)
print(total)