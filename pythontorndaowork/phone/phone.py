import re
#正則表答式

def checkPCorMobile(info):
    phonedatas=["android","mac","windowphone"]

    #遍历
    for data in phonedatas:
        val=re.search(data,info.lower())

        if val is None:
            return "PC"
        else:
            return "Mobile"
