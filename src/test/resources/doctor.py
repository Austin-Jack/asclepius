# -*- coding :  utf-8 -*-
# @Time      :  2022/6/30
# @author    :  wyy
# 爬取医院的医生图片及其信息
import time
from urllib.request import urlretrieve
import requests
from bs4 import BeautifulSoup
import pandas as pd
import os

# 获取网页源代码文本内容
def get_htmltext(url):
    try:
        # 请求打开网页
        r = requests.get(url, headers=headers, timeout=10)
        # 判断打开网页是否成功
        r.raise_for_status()
        # 设定编码与内容编码一致
        r.encoding = r.apparent_encoding
        # 返回获取的页面源代码文本
        return r.text
    except:
        return '获取网页失败'

# 获取科室信息
def get_department(html):
    soup = BeautifulSoup(html, 'html.parser')
    items = soup.find('div', attrs={'class': 'part2 p1'}).find_all('div', attrs={'class': 'item'})
    #items = divs.find_all('div', attrs={'class': 'item'})
    count = 0
    for item in items:
        count += 1
        print('开始处理第{}个科室'.format(count))
        # 找到各科室对应链接和科室名
        a = item.find('a')
        link = a.get('href')
        #departmentname = a.string
        href = "https://www.pumch.cn" + link
        print(href)
        get_depalldoctor(href)

# 获取医生图片信息
def get_depalldoctor(url):
    filename = url.split("/")[-2]  # 获取文件名
    print(filename)
    a_soup = BeautifulSoup(get_htmltext(url), 'html.parser')
    #  path = f'E:\\pycharm\\PycharmProject\\pythonProject\\asclepius\\{filename}'
    path = f'.\\asclepius\\{filename}'
    if not os.path.exists(path): # 路径不存在则创建
        os.makedirs(path)
    a_divs = a_soup.find_all('div', attrs={'class': 'item'})
    count = 0
    for div in a_divs:
        count += 1
        print('开始处理第{}个医生'.format(count))
        departmentnamedata.append(filename)
        image = div.find('img')
        # 找到属性为'img'的标签
        imageurl = image.get('src')
        inline = div.find('div', attrs={'class': 'h2'})
        inlinestring = inline.string
        inlinestring = inlinestring.replace('\t', '')
        imagename = path + '\\' + inlinestring + '.jpg'
        print('正在下载', imageurl)
        il = "https://www.pumch.cn" + imageurl
        urlretrieve(url=il, filename=imagename)  # urlretrieve() 方法直接将远程数据下载到本地
        time.sleep(0.5)
        print('下载完成', imagename)
        imagenamedata.append(imagename)
        ah = div.find('a')
        l = ah.get('href')
        get_doctormessage("https://www.pumch.cn" + l)

# 获取医生具体信息
def get_doctormessage(url):
    b_soup = BeautifulSoup(get_htmltext(url), 'html.parser')
    # 找到医生姓名以及职称、擅长
    title1 = b_soup.find('div', attrs={'class': 'title1'})
    title2 = b_soup.find_all('div', attrs={'class': 'title2'})
    #< div class ="title1" > 杜斌
        #< a class ="pubc-more" href="/department_neikxx/doctor.html" > 查看科室更多医生
        #< / a >
    #< / div >
    if title1 is None:
        doctorname = '暂无此医生'
    else:
        dname = title1.contents  # 医生姓名
        doctorname = dname[0]
    print(doctorname)
    if not title2:
        doctorrank = '暂无此医生职称'
        doctorskill = '暂无此医生擅长'
    else:
        doctorrank = title2[0].string  # 医生职称
        doctorskill = title2[1].string  # 医生擅长
    print(doctorrank)
    print(doctorskill)
    doctornamedata.append(doctorname)
    doctorrankdata.append(doctorrank)
    doctorskilldata.append(doctorskill)

# 存储data至excel表中
def savedoctorInfo():
    print(departmentnamedata)
    print(imagenamedata)
    print(doctornamedata)
    print(doctorrankdata)
    print(doctorskilldata)
    dic = {'departmentname': departmentnamedata, 'imagenamedata':imagenamedata, 'doctorname': doctornamedata, 'doctorrank': doctorrankdata, 'doctorskill': doctorskilldata}
    # 使用pandas库保存数据到本地excel表
    doctorData = pd.DataFrame(dic)
    doctorData.to_excel(r'.\asclepius\doctorData.xlsx')


departmentnamedata, imagenamedata, doctornamedata, doctorrankdata, doctorskilldata = [], [], [], [], []
headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36',
            'Cookie': 'Hm_lvt_e433a0b553c50c4663c2ef927781bc71=1656573557,1656673172; Hm_lpvt_e433a0b553c50c4663c2ef927781bc71=1656673172; Hm_lvt_fa06b5d83a50d14d11bd70f117d24063=1656573557,1656673172; Hm_lpvt_fa06b5d83a50d14d11bd70f117d24063=1656673172'
        }
url = 'https://www.pumch.cn/doctors.html'
html = get_htmltext(url)
get_department(html)
savedoctorInfo()
print('数据保存完毕')
