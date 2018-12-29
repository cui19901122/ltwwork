import  suds
from suds import client
from phone.phone import *
import json

class Huancuen():
    huancuendata={}

    def __init__(self):
        print("---------产生对象缓存--------------")

    #取出缓存中的数据
    def getHuancuenData(self,key):
        if key in self.huancuendata:
            print("缓存存在此对象的数据")
            #返回数据
            return self.huancuendata[key]
        else:
            print("缓存不存在此对象的数据,前往数据库调取数据")
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.queryMenuData()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("jsonDatas-->", jsonDatas)
            self.huancuendata[key] = jsonDatas
            return jsonDatas

