import re
from urllib.request import urlopen
import ssl

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

#http://py4e-data.dr-chuck.net/regex_sum_728483.txt
url = input('Enter URL:')
data = urlopen(url, context=ctx).read()
numbers = 0
#numbers = re.findall(r'[1-9]*',data)
new_list =  re.findall(r'\d+', data.decode('utf-8'))
for i in new_list:
    numbers= numbers+ int(i)
print(numbers)
