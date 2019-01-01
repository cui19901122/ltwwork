import tornado.web
import tornado.ioloop
import suds
from suds import client
from phone.phone import *
import json
from phone.huancuen import Huancuen


class IndexHandler(tornado.web.RequestHandler):
    #self：当前对象
    def get(self):
        print("接收用户get请求")

        #信息写入
        self.render("login.html",failmsg=None)

class UserHandler(tornado.web.RequestHandler):
    def post(self):
        print("接受到用户post请求")
        print("user用户登录")

        method=self.get_argument("action")
        print("method--->",method)

        #判断用户请求
        if method=="login":
            #获取用户输入的传参
            Username=self.get_argument("username")

            Userpwd=self.get_argument("userpwd")

            print(Username,Userpwd)

            url="http://127.0.0.1:8100/userdataservice/user?wsdl"

            service=suds.client.Client(url)

            msg=service.service.quaryUserInfoll(Username,Userpwd)

            print("msg--->",msg)

            # 怎么来区分是浏览器还是手机的请求
            # 得到请求的头
            headsInfo = self.request.headers

            hinfo = headsInfo["User-Agent"]

            print("hinfo--->",hinfo)

            val=checkPCorMobile(hinfo)
            print("val--->",val)

            jsonDatas = ""
            if msg=='登录成功':
                '''url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
                service = suds.client.Client(url)
                data = service.service.queryMenuData()
                print("data-->", data)
                print(type(data))
                jsonDatas = json.loads(data)
                print("jsonDatas-->", jsonDatas)'''

                huancuen=Huancuen()
                jsonDatas=huancuen.getHuancuenData("keyname")

                if val == "PC":
                    self.render("index.html",contentdata=jsonDatas)
                else:
                    # json数据格式
                    self.finish({"msg": "success","contentdata":jsonDatas})
            else:
                if val == "PC":
                    self.render("login.html",failmsg=msg)
                else:
                    # json数据格式
                    self.finish({"msg": "fail"})

        elif method=="zhuce":
            self.render("zhuce.html")

class AntvHandler(tornado.web.RequestHandler):
    def post(self):
        print("antv报表功能")
        methond=self.get_argument("antv")
        print("methond--->",methond)
        if methond=="quaryUsercount":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsercount()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("jsonDatas-->", jsonDatas)
            self.finish({"jsonDatas":jsonDatas})
        elif methond=="quaryUsersexcount":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsersexcount()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("sexDatas-->", jsonDatas)
            self.finish({"sexDatas":jsonDatas})
        elif methond=="querylistclass":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.querylistclass()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("querylistclass-->", jsonDatas)
            self.finish({"querylistclass":jsonDatas})
        elif methond=="quaryUsersexcount1":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsersexcount1()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUsersexcount1-->", jsonDatas)
            self.finish({"quaryUsersexcount1":jsonDatas})
        elif methond == "quaryUsersexcount2":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsersexcount2()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUsersexcount2-->", jsonDatas)
            self.finish({"quaryUsersexcount2": jsonDatas})
        elif methond == "quaryUsersexcount3":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsersexcount3()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUsersexcount3-->", jsonDatas)
            self.finish({"quaryUsersexcount3": jsonDatas})
        elif methond == "quaryUsersexcount4":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsersexcount4()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUsersexcount4-->", jsonDatas)
            self.finish({"quaryUsersexcount4": jsonDatas})
        elif methond == "quaryUsersaddres1":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsersaddres1()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUsersaddres1-->", jsonDatas)
            self.finish({"quaryUsersaddres1": jsonDatas})
        elif methond == "quaryUserstatecount":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUserstatecount()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUserstatecount-->", jsonDatas)
            self.finish({"quaryUserstatecount": jsonDatas})
        elif methond == "quaryUsersaddres2":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsersaddres2()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUsersaddres2-->", jsonDatas)
            self.finish({"quaryUsersaddres2": jsonDatas})
        elif methond == "quaryUsersaddres3":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUsersaddres3()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUsersaddres3-->", jsonDatas)
            self.finish({"quaryUsersaddres3": jsonDatas})
        elif methond == "quaryUserstatecount1":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUserstatecount1()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUserstatecount1-->", jsonDatas)
            self.finish({"quaryUserstatecount1": jsonDatas})
        elif methond == "quaryUserstatecount2":
            url = "http://127.0.0.1:8100/userdataservice/user?wsdl"
            service = suds.client.Client(url)
            data = service.service.quaryUserstatecount2()
            print("data-->", data)
            print(type(data))
            jsonDatas = json.loads(data)
            print("quaryUserstatecount2-->", jsonDatas)
            self.finish({"quaryUserstatecount2": jsonDatas})


settings={
    "template_path":"templates",
    "static_path":"static",
    "static_url_prefix":"static",
}
#创建应用对象，路由请求的动作对应着类方法
app=tornado.web.Application([(r'/',IndexHandler),
                             (r'/user',UserHandler),
                             (r'/antv',AntvHandler)
                             ],**settings)


if __name__=="__main__":
    #绑定监听端口，与内网一致
    app.listen(8011)
    #启动程序，监听端口连接
    tornado.ioloop.IOLoop.current().start()