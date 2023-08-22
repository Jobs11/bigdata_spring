# coding: utf-8
import urllib
import json
import requests
from PIL import Image
from io import BytesIO
import matplotlib.pyplot as plt


client_id = 'qcUGYZKTsr6_i3QBxuZo'
client_secret = 'wJ9ZoC9oXj'
#검색할 구간
def searchTest(search):
    encText = urllib.parse.quote(search)
    url = "https://openapi.naver.com/v1/search/image?query=" + encText + "&display="+str(100)   # JSON 결과
    # url = "https://openapi.naver.com/v1/search/blog.xml?query=" + encText # XML 결과
    request = urllib.request.Request(url)
    request.add_header("X-Naver-Client-Id",client_id)
    request.add_header("X-Naver-Client-Secret",client_secret)
    response = urllib.request.urlopen(request)
    rescode = response.getcode()
    if(rescode==200):
        response_body = response.read()
        res_body = json.loads(response_body.decode('utf-8'))
        # print(response_body.decode('utf-8'))
        img_link_list = []
        for item in res_body['items']:
            # print("title: ", item['title'])
            file_path = item['link']
            img_link_list.append([item['title'], item['link']])

            # reimage = requests.get(file_path)
            # image = Image.open(BytesIO(reimage.content))

    else:
        print("Error Code:" + rescode)

    return img_link_list


a = searchTest('설정')
print(a)