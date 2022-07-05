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
import ssl

ssl._create_default_https_context = ssl._create_unverified_context
replace_dic = {'department_neikxx': '内科学系', 'department_xinnk': '心内科',
               'department_huxnk': '呼吸与危重症医学科', 'department_xiaohnk': '消化内科',
               'department_shennk': '肾内科', 'department_xueynk': '血液内科',
               'department_fengsmyk': '风湿免疫科', 'department_ganrnk': '感染内科',
               'department_putnk': '全科医学科（普通内科）', 'department_zhonglnk': '肿瘤内科',
               'department_micu': 'MICU', 'department_laonsfbf': '老年医学科',
               'department_neifmk': '内分泌科', 'department_zhongzylk': '重症医学科（ICU）',
               'department_erk': '儿科', 'department_shenjk': '神经科',
               'department_xinlyxk': '心理医学科', 'department_pifk': '皮肤科',
               'department_biantfyk': '变态反应科', 'department_jizk': '急诊科',
               'department_zhongyk': '中医科', 'department_wulyxkfk': '康复医学科',
               'department_yingyb': '临床营养科'}


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
    # items = divs.find_all('div', attrs={'class': 'item'})
    count = 0
    for item in items:
        count += 1
        print('开始处理第{}个科室'.format(count))
        # 找到各科室对应链接和科室名
        a = item.find('a')
        link = a.get('href')
        # departmentname = a.string
        href = "https://www.pumch.cn" + link
        get_depalldoctor(href)


# 获取医生图片信息
def get_depalldoctor(url):
    filename = url.split("/")[-2]  # 获取文件名
    a_soup = BeautifulSoup(get_htmltext(url), 'html.parser')
    path = f'asclepius-resource{os.sep}{replace_dic[filename]}'
    print(path)
    if not os.path.exists(path):  # 路径不存在则创建
        os.makedirs(path)
    a_divs = a_soup.find_all('div', attrs={'class': 'item'})
    count = 0
    for div in a_divs:
        count += 1
        print('开始处理第{}个医生'.format(count))
        departmentnamedata.append(replace_dic[filename])
        image = div.find('img')
        # 找到属性为'img'的标签
        imageurl = image.get('src')
        inline = div.find('div', attrs={'class': 'h2'})
        inlinestring = inline.string
        inlinestring = inlinestring.replace('\t', '')
        imagename = path + os.sep + inlinestring + '.jpg'
        il = "https://www.pumch.cn" + imageurl
        urlretrieve(url=il, filename=imagename)  # urlretrieve() 方法直接将远程数据下载到本地
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
    # < div class ="title1" > 杜斌
    # < a class ="pubc-more" href="/department_neikxx/doctor.html" > 查看科室更多医生
    # < / a >
    # < / div >
    if title1 is None:
        doctorname = '暂无此医生'
    else:
        dname = title1.contents  # 医生姓名
        doctorname = dname[0]
    if not title2:
        doctorrank = '暂无此医生职称'
        doctorskill = '暂无此医生擅长'
    else:
        doctorrank = title2[0].string  # 医生职称
        doctorskill = title2[1].string  # 医生擅长
    doctornamedata.append(doctorname)
    doctorrankdata.append(doctorrank)
    doctorskilldata.append(doctorskill)


# 存储data至excel表中
def savedoctorInfo():
    dic = {'departmentname': departmentnamedata, 'imagenamedata': imagenamedata, 'doctorname': doctornamedata,
           'doctorrank': doctorrankdata, 'doctorskill': doctorskilldata}
    # 使用pandas库保存数据到本地excel表
    doctorData = pd.DataFrame(dic)
    doctorData.to_excel(f'doctorData.xlsx')


departmentnamedata, imagenamedata, doctornamedata, doctorrankdata, doctorskilldata = [], [], [], [], []
replacedic = {}
headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/103.0.5060.66 Safari/537.36 Edg/103.0.1264.44',
    'Cookie': 'route=8a5a4d1633758e156ed143571227f96b; HttpOnly=true; PHPSESSID=kr1lvfrho4r7jrd1blf4sih3k3; '
              'saw_terminal=default; Secure '
}
url = 'https://www.pumch.cn/doctors.html'
html = get_htmltext(url)
get_department(html)
savedoctorInfo()
print('数据保存完毕')
